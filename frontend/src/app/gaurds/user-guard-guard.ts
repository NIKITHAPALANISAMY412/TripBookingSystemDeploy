import { CanActivateFn, Router } from '@angular/router';
import { AuthService } from '../services/auth-service';
import { inject } from '@angular/core';

export const userGuardGuard: CanActivateFn = (route, state) => {
  const authService: AuthService = inject(AuthService);
  const router: Router = inject(Router);
  
  if(authService.hasRole('USER')){
    return true;
  }
  else{
    return router.navigate(['login']);
  }
};
