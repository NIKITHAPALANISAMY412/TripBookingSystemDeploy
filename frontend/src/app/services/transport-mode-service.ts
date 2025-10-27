import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TransportModeDTO } from '../models/TransportModeDTO.model';
@Injectable({ providedIn: 'root' })
export class TransportModeService {
  private baseUrl = 'http://localhost:9090/api/transport-modes'; // matches Spring Boot

  constructor(private httpClient: HttpClient) {}

  getAllTransportModes(): Observable<TransportModeDTO[]> {
    return this.httpClient.get<TransportModeDTO[]>(this.baseUrl); // GET /api/transport-modes
  }

  getTransportModeById(id: number): Observable<TransportModeDTO> {
    return this.httpClient.get<TransportModeDTO>(`${this.baseUrl}/${id}`); // GET /api/transport-modes/{id}
  }

  getTransportsByPackageId(packageId: number): Observable<TransportModeDTO[]> {
    return this.httpClient.get<TransportModeDTO[]>(`${this.baseUrl}/package/${packageId}`); // GET /api/transport-modes/package/{packageId}
  }

  getAvailableTransportsByPackageId(packageId: number): Observable<TransportModeDTO[]> {
    return this.httpClient.get<TransportModeDTO[]>(`${this.baseUrl}/package/${packageId}/available`); // GET /api/transport-modes/package/{packageId}/available
  }

  addTransportMode(dto: TransportModeDTO): Observable<TransportModeDTO> {
    return this.httpClient.post<TransportModeDTO>(this.baseUrl, dto); // POST /api/transport-modes
  }

  updateTransportMode(dto: TransportModeDTO, id: number): Observable<TransportModeDTO> {
    return this.httpClient.put<TransportModeDTO>(`${this.baseUrl}/${id}`, dto); // PUT /api/transport-modes/{id}
  }

  deleteTransportMode(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${this.baseUrl}/${id}`); // DELETE /api/transport-modes/{id}
  }
}
