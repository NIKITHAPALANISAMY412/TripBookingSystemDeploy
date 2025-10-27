import { Component, OnInit } from '@angular/core';
import { CommonModule, Location } from '@angular/common';
import { UserResponseDTO } from '../../models/UserResponseDTO.model';
import { UserService } from '../../services/user-service';

@Component({
  selector: 'app-myprofile',
  imports:[CommonModule],
  templateUrl: './myprofile.html',
  styleUrls: ['./myprofile.css'],
})
export class Myprofile implements OnInit {
  user?: UserResponseDTO;

  constructor(
    private userService: UserService,
    private location: Location
  ) {}

  ngOnInit(): void {
    const userId = Number(localStorage.getItem('userId'));
    console.log('Fetched userId:', userId);

    if (userId) {
      this.userService.getUserById(userId).subscribe({
        next: (data) => {
          console.log('User data:', data);
          this.user = data;
        },
        error: (err) => {
          console.error('Error fetching user:', err);
        },
      });
    } else {
      console.warn('No userId found in localStorage!');
    }
  }

  goBack(): void {
    this.location.back();
  }
}
