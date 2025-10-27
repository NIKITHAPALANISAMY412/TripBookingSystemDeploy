import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { UserResponseDTO } from '../../../models/UserResponseDTO.model';
import { UserService } from '../../../services/user-service';


@Component({
  selector: 'app-get-all-users',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './get-all-users.html',
  styleUrls: ['./get-all-users.css']
})
export class GetAllUsers implements OnInit {
  users: UserResponseDTO[] = [];
  isLoading = true;

  constructor(private userService: UserService, private router: Router) {}

  ngOnInit(): void {
    this.loadAllUsers();
  }

  loadAllUsers(): void {
    this.userService.getAllUsers().subscribe({
      next: (data) => {
        this.users = data;
        this.isLoading = false;
      },
      error: (err) => {
        console.error('Error fetching users:', err);
        this.isLoading = false;
      }
    });
  }

  deleteUser(userId: number): void {
    if (confirm('Are you sure you want to delete this user?')) {
      this.userService.deleteUser(userId).subscribe({
        next: () => {
          this.users = this.users.filter(u => u.userId !== userId);
        },
        error: (err) => console.error('Error deleting user:', err)
      });
    }
  }

  backToAdmin(): void {
    this.router.navigate(['/admindashboard']);
  }
}
