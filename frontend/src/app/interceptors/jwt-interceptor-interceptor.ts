import { HttpInterceptorFn } from '@angular/common/http';
import { AuthService } from '../services/auth-service';
import { inject } from '@angular/core';

export const jwtInterceptorInterceptor: HttpInterceptorFn = (req, next) => {


   const authService: AuthService = inject(AuthService);
   let token = authService.retrieveToken();

   if(token != null){
    let authReq = req.clone({
      setHeaders:{Authorization: `Bearer ${token}` },
    });
    return next(authReq);
   }
   return next(req);
};
