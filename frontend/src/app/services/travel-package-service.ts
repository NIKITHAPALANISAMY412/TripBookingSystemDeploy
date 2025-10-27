import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TravelPackageDTO } from '../models/TravelPackageDTO.model';

@Injectable({ providedIn: 'root' })
export class TravelPackageService {
  private baseUrl = 'http://localhost:9090/api/travel-packages'; // matches Spring Boot

  constructor(private httpClient: HttpClient) {}

  getAllPackages(): Observable<TravelPackageDTO[]> {
    return this.httpClient.get<TravelPackageDTO[]>(this.baseUrl); // GET /api/travel-packages
  }

  getAllActivePackages(): Observable<TravelPackageDTO[]> {
    return this.httpClient.get<TravelPackageDTO[]>(`${this.baseUrl}/active`); // GET /api/travel-packages/active
  }

  getPackageById(id: number): Observable<TravelPackageDTO> {
    return this.httpClient.get<TravelPackageDTO>(`${this.baseUrl}/${id}`); // GET /api/travel-packages/{id}
  }

  searchPackages(
    source: string,
    destination: string,
    fromDate: string,
    toDate: string
  ): Observable<TravelPackageDTO[]> {
    return this.httpClient.get<TravelPackageDTO[]>(
      `${this.baseUrl}/search?source=${source}&destination=${destination}&fromDate=${fromDate}&toDate=${toDate}`
    ); // GET /api/travel-packages/search
  }

  addPackage(dto: TravelPackageDTO): Observable<TravelPackageDTO> {
    return this.httpClient.post<TravelPackageDTO>(this.baseUrl, dto); // POST /api/travel-packages
  }

  updatePackage(dto: TravelPackageDTO, id: number): Observable<TravelPackageDTO> {
    return this.httpClient.put<TravelPackageDTO>(`${this.baseUrl}/${id}`, dto); // PUT /api/travel-packages/{id}
  }

  deletePackage(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${this.baseUrl}/${id}`); // DELETE /api/travel-packages/{id}
  }
}
