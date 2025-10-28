import { Component, OnInit } from '@angular/core';
import { CommonModule, Location } from '@angular/common';
import { UserResponseDTO } from '../../models/UserResponseDTO.model';
import { UserService } from '../../services/user-service';
import { AuthService } from '../../services/auth-service';

@Component({
  selector: 'app-myprofile',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './myprofile.html',
  styleUrls: ['./myprofile.css'],
})
export class Myprofile implements OnInit {
  user?: UserResponseDTO;
  message = '';

  constructor(
    private userService: UserService,
    private authService: AuthService,
    private location: Location
  ) {}

  ngOnInit(): void {
    const userId = this.authService.retrieveUserId(); // ✅ Correctly fetch from stored user info
    console.log('Fetched userId:', userId);

    if (userId && !isNaN(userId)) {
      this.userService.getUserById(userId).subscribe({
        next: (data) => {
          console.log('User data:', data);
          this.user = data;
        },
        error: (err) => {
          console.error('Error fetching user:', err);
          this.message = 'Error fetching user profile.';
        },
      });
    } else {
      console.warn('No userId found in localStorage!');
      this.message = 'No user information found. Please log in again.';
    }
  }

  goBack(): void {
    this.location.back();
  }
}
