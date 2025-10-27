import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { BookingPassengerDTO } from '../models/BookingPassengerDTO.model';

@Injectable({ providedIn: 'root' })
export class BookingPassengerService {
  private baseUrl = 'http://localhost:9090/api/booking-passengers';

  constructor(private httpClient: HttpClient) {}

  // Get all passengers
  getAllPassengers(): Observable<BookingPassengerDTO[]> {
    return this.httpClient.get<BookingPassengerDTO[]>(`${this.baseUrl}`);
  }

  // Get passenger by ID
  getPassengerById(id: number): Observable<BookingPassengerDTO> {
    return this.httpClient.get<BookingPassengerDTO>(`${this.baseUrl}/${id}`);
  }

  // Add new passenger
  addPassenger(dto: BookingPassengerDTO): Observable<BookingPassengerDTO> {
    return this.httpClient.post<BookingPassengerDTO>(`${this.baseUrl}`, dto);
  }

  // Update passenger
  updatePassenger(dto: BookingPassengerDTO, id: number): Observable<BookingPassengerDTO> {
    return this.httpClient.put<BookingPassengerDTO>(`${this.baseUrl}/${id}`, dto);
  }

  // Delete passenger
  deletePassenger(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${this.baseUrl}/${id}`);
  }
}
