import { Component, OnInit } from '@angular/core';
import { CommonModule, Location } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { UserRequestDTO } from '../../models/UserRequestDTO.model';
import { UserResponseDTO } from '../../models/UserResponseDTO.model';
import { RoleDTO } from '../../models/RoleDTO.model';
import { AuthService } from '../../services/auth-service';
import { UserService } from '../../services/user-service';
import { RoleService } from '../../services/role-service';

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
    private roleService: RoleService,
    private authService: AuthService,
    private router: Router, private location: Location
  ) {
    const userId = this.authService.retrieveUserId();
    if (userId) {
      this.router.navigate(['/userdashboard']);
    }
  }

  ngOnInit(): void {
    this.loadRoles();
  }

  loadRoles(): void {
    this.roleService.getAllRoles().subscribe({
      next: (res: RoleDTO[]) => {
        this.roles = res;
      },
      error: (err) => {
        console.error('Error fetching roles:', err);
        this.message = 'Unable to load roles. Please try again later.';
      },
    });
  }

  register(): void {
    if (
      !this.user.userName ||
      !this.user.userEmail ||
      !this.user.userPassword ||
      !this.selectedRoleId
    ) {
      this.message = 'Please fill all fields.';
      return;
    }

    // Assign selected role to roleIds array
    this.user.roleIds = [this.selectedRoleId];

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
