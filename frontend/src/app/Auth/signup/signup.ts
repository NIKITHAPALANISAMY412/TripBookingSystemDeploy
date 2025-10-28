import { Component, OnInit } from '@angular/core';
import { CommonModule, Location } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { UserRequestDTO } from '../../models/UserRequestDTO.model';
import { UserResponseDTO } from '../../models/UserResponseDTO.model';
import { RoleDTO } from '../../models/RoleDTO.model';
import { AuthService } from '../../services/auth-service';
import { UserService } from '../../services/user-service';

@Component({
  selector: 'app-signup',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './signup.html',
  styleUrls: ['./signup.css'],
})
export class Signup implements OnInit {
  user: UserRequestDTO = {
    userName: '',
    userEmail: '',
    userPassword: '',
    roleIds: [],
  };

  roles: RoleDTO[] = [];
  selectedRoleId: number | null = null;
  message = '';

  constructor(
    private userService: UserService,
    private authService: AuthService,
    private router: Router,
    private location: Location
  ) {
    const userId = this.authService.retrieveUserId();
    if (userId) {
      this.router.navigate(['/userdashboard']);
    }
  }

  ngOnInit(): void {
    // Instead of calling backend, manually assign the role
    this.roles = [{ id: 2, roleName: 'USER' }];
    this.selectedRoleId = 2; // Preselect the USER role
  }

  register(): void {
    if (!this.user.userName || !this.user.userEmail || !this.user.userPassword) {
      this.message = 'Please fill all fields.';
      return;
    }

    // Assign the fixed USER role
    this.user.roleIds = [2];

    this.userService.addUser(this.user).subscribe({
      next: (res: UserResponseDTO) => {
        this.message = 'Signup successful! Redirecting to login...';
        setTimeout(() => this.router.navigate(['/login']), 1500);
      },
      error: (err) => {
        console.error(err);
        this.message = 'Error during signup. Please try again.';
      },
    });
  }

  goBack(): void {
    this.location.back();
  }
}
