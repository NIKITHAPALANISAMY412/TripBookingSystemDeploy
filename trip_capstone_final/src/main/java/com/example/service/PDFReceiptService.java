package com.example.service;

import com.example.entity.BookingEntity;
import com.example.entity.BookingPassengerEntity;
import com.example.entity.TravelPackageEntity;
import com.example.entity.TransportModeEntity;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class PDFReceiptService {

    public byte[] generateBookingReceipt(BookingEntity booking, List<BookingPassengerEntity> passengers) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, baos);
            document.open();

            // Title
            Paragraph title = new Paragraph("TRAVEL BOOKING RECEIPT");
            title.setAlignment(Element.ALIGN_CENTER);
            title.getFont().setSize(20);
            title.getFont().setStyle(Font.BOLD);
            document.add(title);

            document.add(new Paragraph("\n"));

            // Booking Details
            Paragraph bookingHeader = new Paragraph("BOOKING DETAILS");
            bookingHeader.getFont().setSize(14);
            bookingHeader.getFont().setStyle(Font.BOLD);
            document.add(bookingHeader);

            document.add(new Paragraph("Booking ID: " + booking.getId()));
            document.add(new Paragraph("Booking Date: " + booking.getBookingDate()));
            document.add(new Paragraph("Booking Status: " + booking.getBookingStatus()));
            document.add(new Paragraph("User: " + booking.getBookedBy().getUserName()));
            document.add(new Paragraph("Email: " + booking.getBookedBy().getUserEmail()));

            document.add(new Paragraph("\n"));

            // Package Details
            TravelPackageEntity pkg = booking.getBookedPackage();
            Paragraph packageHeader = new Paragraph("PACKAGE DETAILS");
            packageHeader.getFont().setSize(14);
            packageHeader.getFont().setStyle(Font.BOLD);
            document.add(packageHeader);

            document.add(new Paragraph("Package: " + pkg.getPackageTitle()));
            document.add(new Paragraph("Description: " + (pkg.getPackageDescription() != null ? pkg.getPackageDescription() : "N/A")));
            document.add(new Paragraph("Source: " + pkg.getPackageSourceCity()));
            document.add(new Paragraph("Destination: " + pkg.getPackageDestinationCity()));
            document.add(new Paragraph("Duration: " + pkg.getPackageDurationDays() + " days"));
            document.add(new Paragraph("Start Date: " + pkg.getPackageStartDate()));
            document.add(new Paragraph("End Date: " + pkg.getPackageEndDate()));
            document.add(new Paragraph("Base Price: Rs. " + pkg.getPackageBasePrice()));

            document.add(new Paragraph("\n"));

            // Transport Details
            if (booking.getTransport() != null) {
                TransportModeEntity transport = booking.getTransport();
                Paragraph transportHeader = new Paragraph("TRANSPORT DETAILS");
                transportHeader.getFont().setSize(14);
                transportHeader.getFont().setStyle(Font.BOLD);
                document.add(transportHeader);

                document.add(new Paragraph("Type: " + transport.getTransportType()));
                document.add(new Paragraph("Provider: " + transport.getTransportProvider()));
                document.add(new Paragraph("Departure: " + transport.getDepartureCity() + " at " + transport.getDepartureTime()));
                document.add(new Paragraph("Arrival: " + transport.getArrivalCity() + " at " + transport.getArrivalTime()));
                document.add(new Paragraph("Seat Price: Rs. " + transport.getSeatPrice()));

                document.add(new Paragraph("\n"));
            }

            // Passengers
            if (passengers != null && !passengers.isEmpty()) {
                Paragraph passengerHeader = new Paragraph("PASSENGER DETAILS");
                passengerHeader.getFont().setSize(14);
                passengerHeader.getFont().setStyle(Font.BOLD);
                document.add(passengerHeader);

                PdfPTable table = new PdfPTable(5);
                table.addCell("Name");
                table.addCell("Age");
                table.addCell("DOB");
                table.addCell("Gender");
                table.addCell("Email");

                for (BookingPassengerEntity passenger : passengers) {
                    table.addCell(passenger.getPassengerName() != null ? passenger.getPassengerName() : "");
                    table.addCell(passenger.getPassengerAge() != null ? passenger.getPassengerAge().toString() : "");
                    table.addCell(passenger.getPassengerDob() != null ? passenger.getPassengerDob().toString() : "");
                    table.addCell(passenger.getPassengerGender() != null ? passenger.getPassengerGender() : "");
                    table.addCell(passenger.getPassengerEmail() != null ? passenger.getPassengerEmail() : "");
                }

                document.add(table);
                document.add(new Paragraph("\n"));
            }

            // Payment Summary
            Paragraph paymentHeader = new Paragraph("PAYMENT SUMMARY");
            paymentHeader.getFont().setSize(14);
            paymentHeader.getFont().setStyle(Font.BOLD);
            document.add(paymentHeader);

            document.add(new Paragraph("Total Amount: Rs. " + booking.getBookingTotalAmount()));
            document.add(new Paragraph("Payment Status: " + booking.getBookingStatus()));

            document.add(new Paragraph("\n\n"));

            // Footer
            Paragraph footer = new Paragraph("Generated on: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            footer.setAlignment(Element.ALIGN_CENTER);
            footer.getFont().setSize(10);
            document.add(footer);

            Paragraph thankYou = new Paragraph("Thank you for booking with us!");
            thankYou.setAlignment(Element.ALIGN_CENTER);
            thankYou.getFont().setSize(10);
            document.add(thankYou);

            document.close();
        } catch (DocumentException e) {
            throw new RuntimeException("Error generating PDF receipt", e);
        }

        return baos.toByteArray();
    }
}
