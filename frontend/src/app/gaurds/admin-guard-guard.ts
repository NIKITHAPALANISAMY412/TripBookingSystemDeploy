import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { AuthService } from '../services/auth-service';

export const adminGuardGuard: CanActivateFn = (route, state) => {
 
   const authService: AuthService = inject(AuthService);
  const router: Router = inject(Router);

  if(authService.hasRole('ADMIN')){
    return true;
  }
  else{
    return router.navigate(['login']);
  }
};
