import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ItineraryPlanDTO } from '../models/ItineraryPlanDTO.model';

@Injectable({ providedIn: 'root' })
export class ItineraryPlanService {
  private baseUrl = 'http://localhost:9090/api/itinerary-plans'; // matches Spring Boot

  constructor(private httpClient: HttpClient) {}

  getAllItineraryPlans(): Observable<ItineraryPlanDTO[]> {
    return this.httpClient.get<ItineraryPlanDTO[]>(this.baseUrl); // GET /api/itinerary-plans
  }

  getItineraryPlanById(id: number): Observable<ItineraryPlanDTO> {
    return this.httpClient.get<ItineraryPlanDTO>(`${this.baseUrl}/${id}`); // GET /api/itinerary-plans/{id}
  }

  addItineraryPlan(dto: ItineraryPlanDTO): Observable<ItineraryPlanDTO> {
    return this.httpClient.post<ItineraryPlanDTO>(this.baseUrl, dto); // POST /api/itinerary-plans
  }

  updateItineraryPlan(dto: ItineraryPlanDTO, id: number): Observable<ItineraryPlanDTO> {
    return this.httpClient.put<ItineraryPlanDTO>(`${this.baseUrl}/${id}`, dto); // PUT /api/itinerary-plans/{id}
  }

  deleteItineraryPlan(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${this.baseUrl}/${id}`); // DELETE /api/itinerary-plans/{id}
  }

  getItineraryByPackage(packageId: number): Observable<ItineraryPlanDTO[]> {
    return this.httpClient.get<ItineraryPlanDTO[]>(`${this.baseUrl}/package/${packageId}`);
  }
}
