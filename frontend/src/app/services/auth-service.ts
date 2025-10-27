import { Injectable } from '@angular/core';
import { UserResponseDTO } from '../models/UserResponseDTO.model';

interface DecodedToken {
  userId: number;
  name?: string;
  email?: string;
  role?: string;
  exp?: number;
}

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  isLoggedIn: boolean = false;

  storeToken(token: string): void {
    localStorage.setItem('jwtToken', token);
  }

  deleteToken(): void {
    localStorage.removeItem('jwtToken');
  }

  retrieveToken(): string | null {
    return localStorage.getItem('jwtToken');
  }

  storeUserInfo(user: UserResponseDTO): void {
    localStorage.setItem('userInfo', JSON.stringify(user));
  }

  deleteUserInfo(): void {
    localStorage.removeItem('userInfo');
  }

  retrieveUserInfo(): UserResponseDTO | null {
    let fetchedUserString = localStorage.getItem('userInfo');
    if (fetchedUserString != null) {
      return JSON.parse(fetchedUserString) as UserResponseDTO;
    }
    return null;
  }

  retrieveRole(): string[] | undefined {
    let user = this.retrieveUserInfo();
    return user?.roles;
  }

  hasRole(roleName: string): boolean {
    const roles = this.retrieveRole();
    return (
      roles?.some(
        (role: string) =>
          role.toLowerCase() === roleName.toLowerCase()
      ) ?? false
    );
  }

  isAdmin(): boolean {
    return this.hasRole('ADMIN');
  }

  ISUser(): boolean {
    return this.hasRole('USER');
  }

  retrieveUserId(): number {
    let fetchedUserString = localStorage.getItem('userInfo');
    if (fetchedUserString != null) {
      return JSON.parse(fetchedUserString).userId;
    }
    return NaN;
  }
}
