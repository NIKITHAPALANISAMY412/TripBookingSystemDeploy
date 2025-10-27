import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserAuthDto } from '../models/UserAuthDTO.model';
import { TokenResponse } from '../models/TokenDTO.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class Loginservice {

  private baseUrl = 'http://localhost:9090/api/auth/login';
  constructor(private http: HttpClient) {}
  
    login(userAuth: UserAuthDto): Observable<TokenResponse> {
    return this.http.post<TokenResponse>(this.baseUrl, userAuth);
  }
}
