import { Component } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { AuthService } from '../../services/auth-service';
import { Router } from '@angular/router';
import { UserAuthDto } from '../../models/UserAuthDTO.model';
import { Loginservice } from '../../services/loginservice';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './login.html',
  styleUrls: ['./login.css'],
})
export class Login {

  userName: string = '';
  userPassword: string = '';
  errorMessage: string = '';

  constructor(
    private router: Router,
    private loginService: Loginservice,
    private authService: AuthService
  ) {}

  handleLogin(form: NgForm) {
    if (form.valid) {

      const userInfo: UserAuthDto = {
        userName: this.userName,
        userPassword: this.userPassword,
      };

      this.loginService.login(userInfo).subscribe({
        next: (response) => {
      

          console.log('JWT Token received:', response)
          this.authService.storeToken(response.token);
          this.authService.storeUserInfo(response.user);
          this.authService.isLoggedIn = true;

         const userRoles = response.user.roles.map((role) => role);

         if(userRoles.includes('ADMIN')){
         this.router.navigate(['admindashboard']);
         }else if(userRoles.includes('USER')){
          this.router.navigate(['userdashboard']);
         }else{
          this.router.navigate(['/login']);
         }  
        },
        error: (err) => {
          console.error(err);
          this.errorMessage = 'Invalid username or password';
        }
      });
    }
  }

  goToSignup() {
    this.router.navigate(['/signup']);
  }
}
