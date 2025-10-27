import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth-service';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-logout',
  imports: [RouterModule],
  templateUrl: './logout.html',
  styleUrl: './logout.css',
})
export class Logout implements OnInit {
  constructor(private authService: AuthService, private router: Router) {}

  ngOnInit(): void {
    // remove the token
    this.authService.deleteToken();
    // remove user Info
    this.authService.deleteUserInfo();
    // set isLoggedIn to false
    this.authService.isLoggedIn = false;
    // route to login
    this.router.navigate(['login']);
  }

}
