import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { RoleDTO } from '../models/RoleDTO.model';

@Injectable({ providedIn: 'root' })
export class RoleService {
  private baseUrl = 'http://localhost:9090/api/roles'; // matches Spring Boot

  constructor(private httpClient: HttpClient) {}

  getAllRoles(): Observable<RoleDTO[]> {
    return this.httpClient.get<RoleDTO[]>(this.baseUrl); // GET /api/roles
  }

  getRoleById(id: number): Observable<RoleDTO> {
    return this.httpClient.get<RoleDTO>(`${this.baseUrl}/${id}`); // GET /api/roles/{id}
  }

  addRole(dto: RoleDTO): Observable<RoleDTO> {
    return this.httpClient.post<RoleDTO>(this.baseUrl, dto); // POST /api/roles
  }

  updateRole(dto: RoleDTO, id: number): Observable<RoleDTO> {
    return this.httpClient.put<RoleDTO>(`${this.baseUrl}/${id}`, dto); // PUT /api/roles/{id}
  }

  deleteRole(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${this.baseUrl}/${id}`); // DELETE /api/roles/{id}
  }
}
