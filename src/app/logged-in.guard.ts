import { CanActivateFn, Router } from '@angular/router';
import { AuthenticationService } from "./authentication.service";
import { inject } from '@angular/core';

export const loggedInGuard: CanActivateFn = (route, state) => {
  const authService = inject(AuthenticationService);
  const router = inject(Router);

  if (authService.isLoggedIn()) {
    return true;
  }

  authService.redirectUrl = state.url;
  router.navigate(['./login']).then(r => {});
  return false;
};
