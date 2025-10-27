import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { BookingDTO } from '../models/BookingDTO.model';

@Injectable({ providedIn: 'root' })
export class BookingService {
  private baseUrl = 'http://localhost:9090/api/bookings'; // ✅ plural 'bookings'

  constructor(private httpClient: HttpClient) {}

  // ✅ GET /api/bookings  → get all bookings (admin)
  getAllBookings(): Observable<BookingDTO[]> {
    return this.httpClient.get<BookingDTO[]>(`${this.baseUrl}`);
  }

  // ✅ GET /api/bookings/{id} → get booking by id
  getBookingById(id: number): Observable<BookingDTO> {
    return this.httpClient.get<BookingDTO>(`${this.baseUrl}/${id}`);
  }

  // ✅ GET /api/bookings/user/{userId} → get bookings by user id
  getBookingsByUserId(userId: number): Observable<BookingDTO[]> {
    return this.httpClient.get<BookingDTO[]>(`${this.baseUrl}/user/${userId}`);
  }

  // ✅ GET /api/bookings/user/{userId}/status/{status}
  getBookingsByUserIdAndStatus(userId: number, status: string): Observable<BookingDTO[]> {
    return this.httpClient.get<BookingDTO[]>(`${this.baseUrl}/user/${userId}/status/${status}`);
  }

  // ✅ GET /api/bookings/package/{packageId} → get bookings by package id
  getBookingsByPackageId(packageId: number): Observable<BookingDTO[]> {
    return this.httpClient.get<BookingDTO[]>(`${this.baseUrl}/package/${packageId}`);
  }

  // ✅ POST /api/bookings  → add new booking
  addBooking(dto: BookingDTO): Observable<BookingDTO> {
    return this.httpClient.post<BookingDTO>(`${this.baseUrl}`, dto);
  }

  // ✅ POST /api/bookings/process-payment?userId=&packageId=&transportId=&totalAmount=
  processBookingPayment(
    userId: number,
    packageId: number,
    transportId: number | null,
    totalAmount: number
  ): Observable<BookingDTO> {
    const params = new URLSearchParams();
    params.append('userId', userId.toString());
    params.append('packageId', packageId.toString());
    if (transportId !== null) params.append('transportId', transportId.toString());
    params.append('totalAmount', totalAmount.toString());
    return this.httpClient.post<BookingDTO>(
      `${this.baseUrl}/process-payment?${params.toString()}`,
      {}
    );
  }

  // ✅ PUT /api/bookings/{id}/cancel → cancel booking
  cancelBooking(id: number): Observable<BookingDTO> {
    return this.httpClient.put<BookingDTO>(`${this.baseUrl}/${id}/cancel`, {});
  }

  // ✅ PUT /api/bookings/{id} → update existing booking
  updateBooking(dto: BookingDTO, id: number): Observable<BookingDTO> {
    return this.httpClient.put<BookingDTO>(`${this.baseUrl}/${id}`, dto);
  }

  // ✅ DELETE /api/bookings/{id}
  deleteBooking(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${this.baseUrl}/${id}`);
  }
}
