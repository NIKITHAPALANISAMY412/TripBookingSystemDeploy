import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserRequestDTO } from '../models/UserRequestDTO.model';
import { UserResponseDTO } from '../models/UserResponseDTO.model';

@Injectable({ providedIn: 'root' })
export class UserService {
  private baseUrl = 'http://localhost:9090/api/users'; // matches Spring Boot

  constructor(private httpClient: HttpClient) {}

  getAllUsers(): Observable<UserResponseDTO[]> {
    return this.httpClient.get<UserResponseDTO[]>(this.baseUrl); // GET /api/users
  }

  getUserById(id: number): Observable<UserResponseDTO> {
    return this.httpClient.get<UserResponseDTO>(`${this.baseUrl}/${id}`); // GET /api/users/{id}
  }

  addUser(dto: UserRequestDTO): Observable<UserResponseDTO> {
    return this.httpClient.post<UserResponseDTO>(this.baseUrl, dto); // POST /api/users
  }

  deleteUser(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${this.baseUrl}/${id}`); // DELETE /api/users/{id}
  }

  findByUserName(userName: string): Observable<UserResponseDTO> {
    return this.httpClient.get<UserResponseDTO>(`${this.baseUrl}/username/${userName}`); // GET /api/users/username/{userName}
  }
}
