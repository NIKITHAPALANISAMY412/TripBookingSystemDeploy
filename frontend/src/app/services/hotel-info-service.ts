import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { HotelInfoDTO } from '../models/HotelInfoDTO.model';

@Injectable({ providedIn: 'root' })
export class HotelInfoService {
  private baseUrl = 'http://localhost:9090/api/hotels'; // matches Spring Boot

  constructor(private httpClient: HttpClient) {}

  getAllHotels(): Observable<HotelInfoDTO[]> {
    return this.httpClient.get<HotelInfoDTO[]>(this.baseUrl); // GET /api/hotels
  }

  getHotelById(id: number): Observable<HotelInfoDTO> {
    return this.httpClient.get<HotelInfoDTO>(`${this.baseUrl}/${id}`); // GET /api/hotels/{id}
  }

  addHotel(dto: HotelInfoDTO): Observable<HotelInfoDTO> {
    return this.httpClient.post<HotelInfoDTO>(this.baseUrl, dto); // POST /api/hotels
  }

  updateHotel(dto: HotelInfoDTO, id: number): Observable<HotelInfoDTO> {
    return this.httpClient.put<HotelInfoDTO>(`${this.baseUrl}/${id}`, dto); // PUT /api/hotels/{id}
  }

  deleteHotel(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${this.baseUrl}/${id}`); // DELETE /api/hotels/{id}
  }

  getHotelsByPackage(packageId: number): Observable<HotelInfoDTO[]> {
  return this.httpClient.get<HotelInfoDTO[]>(`${this.baseUrl}/package/${packageId}`);
}

}
