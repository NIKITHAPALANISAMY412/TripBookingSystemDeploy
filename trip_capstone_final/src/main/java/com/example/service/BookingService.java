package com.example.service;

import com.example.dto.BookingDTO;
import com.example.entity.BookingEntity;
import com.example.entity.TravelPackageEntity;
import com.example.entity.UserEntity;
import com.example.entity.WalletEntity;
import com.example.exceptions.IdNotFoundException;
import com.example.mapper.BookingMapper;
import com.example.repository.AppBookingRepository;
import com.example.repository.AppWalletRepository;
import com.example.repository.TravelPackageRepository;
import com.example.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final AppBookingRepository bookingRepository;
    private final BookingMapper bookingMapper;
    private final WalletService walletService;
    private final TravelPackageRepository packageRepository;
    private final AppUserRepository userRepository;
    private final AppWalletRepository walletRepository;

    // Get all bookings
    public List<BookingDTO> getAllBookings() {
        return bookingRepository.findAll()
                .stream()
                .map(bookingMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Get booking by ID
    public BookingDTO getBookingById(Long id) {
        BookingEntity entity = bookingRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("Booking", "id", id));
        return bookingMapper.toDTO(entity);
    }

    // Get bookings by user ID
    public List<BookingDTO> getBookingsByUserId(Long userId) {
        return bookingRepository.findByBookedById(userId)
                .stream()
                .map(bookingMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<BookingDTO> getBookingsByUserIdAndStatus(Long userId, String status) {
        return bookingRepository.findByBookedById(userId)
                .stream()
                .filter(b -> b.getBookingStatus().equals(status))
                .map(bookingMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Get bookings by package ID
    public List<BookingDTO> getBookingsByPackageId(Long packageId) {
        return bookingRepository.findByBookedPackageId(packageId)
                .stream()
                .map(bookingMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Add new booking
    public BookingDTO addBooking(BookingDTO dto) {
        BookingEntity entity = bookingMapper.toEntity(dto);
        BookingEntity saved = bookingRepository.saveAndFlush(entity);
        return bookingMapper.toDTO(saved);
    }

    public BookingDTO processBookingPayment(Long userId, Long packageId, Long transportId, BigDecimal totalAmount) {
        // Validate user and package
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new IdNotFoundException("User", "id", userId));
        TravelPackageEntity pkg = packageRepository.findById(packageId)
                .orElseThrow(() -> new IdNotFoundException("Package", "id", packageId));

        // Check wallet balance
        walletService.debitMoneyFromWallet(userId, totalAmount);

        // Credit admin wallet (assuming admin user ID is 1)
        try {
            walletService.addMoneyToWallet(1L, totalAmount);
        } catch (Exception e) {
            // If admin wallet doesn't exist, create it
            UserEntity admin = userRepository.findById(1L).orElse(null);
            if (admin != null) {
                WalletEntity adminWallet = new WalletEntity();
                adminWallet.setWalletOwner(admin);
                adminWallet.setWalletBalance(totalAmount);
                walletRepository.saveAndFlush(adminWallet);
            }
        }

        // Decrement available slots
        if (pkg.getPackageAvailableSlots() > 0) {
            pkg.setPackageAvailableSlots(pkg.getPackageAvailableSlots() - 1);
            packageRepository.saveAndFlush(pkg);
        } else {
            throw new IllegalArgumentException("No available slots for this package");
        }

        // Create booking
        BookingEntity booking = new BookingEntity();
        booking.setBookedBy(user);
        booking.setBookedPackage(pkg);
        booking.setBookingTotalAmount(totalAmount);
        booking.setBookingStatus("CONFIRMED");
        if (transportId != null) {
            booking.setTransport(null); 
        }

        BookingEntity saved = bookingRepository.saveAndFlush(booking);
        return bookingMapper.toDTO(saved);
    }

    public BookingDTO cancelBooking(Long bookingId) {
        BookingEntity booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new IdNotFoundException("Booking", "id", bookingId));

        if ("CANCELLED".equals(booking.getBookingStatus())) {
            throw new IllegalArgumentException("Booking is already cancelled");
        }

        // Refund to user wallet
        walletService.addMoneyToWallet(booking.getBookedBy().getId(), booking.getBookingTotalAmount());

        // Deduct from admin wallet
        try {
            walletService.debitMoneyFromWallet(1L, booking.getBookingTotalAmount());
        } catch (Exception e) {
        }

        // Increment available slots
        TravelPackageEntity pkg = booking.getBookedPackage();
        pkg.setPackageAvailableSlots(pkg.getPackageAvailableSlots() + 1);
        packageRepository.saveAndFlush(pkg);

        // Update booking status
        booking.setBookingStatus("CANCELLED");
        BookingEntity updated = bookingRepository.saveAndFlush(booking);

        return bookingMapper.toDTO(updated);
    }

    // Update existing booking
    public BookingDTO updateBooking(BookingDTO dto) {
        BookingEntity existing = bookingRepository.findById(dto.getId())
                .orElseThrow(() -> new IdNotFoundException("Booking", "id", dto.getId()));
        BookingEntity updated = bookingMapper.toEntity(dto);
        updated.setId(existing.getId());
        return bookingMapper.toDTO(bookingRepository.save(updated));
    }

    // Delete booking
    public void deleteBooking(Long id) {
        BookingEntity entity = bookingRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("Booking", "id", id));
        bookingRepository.delete(entity);
    }
}
