import { Injectable , inject } from '@angular/core';
import { HttpClient ,HttpParams} from '@angular/common/http';
import { Observable } from 'rxjs';
import { CanActivateFn, Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService{
  private tokenKey = 'token';
  private apiUrl = 'http://localhost:8080/api/quipux-playlist';
  private router = inject(Router);

  constructor(private http: HttpClient) {
   }

   private isLocalStorageAvailable(): boolean {
    try {
      const testKey = 'test';
      localStorage.setItem(testKey, testKey);
      localStorage.removeItem(testKey);
      return true;
    } catch (e) {
      return false;
    }
  }

  getToken(): string | null {
    if (this.isLocalStorageAvailable()) {
      return localStorage.getItem(this.tokenKey);
    }
    return null;
  }

  setToken(token: string): void {
    if (this.isLocalStorageAvailable()) {
      localStorage.setItem(this.tokenKey, token);
    }
  }

  removeToken(): void {
    if (this.isLocalStorageAvailable()) {
      localStorage.removeItem(this.tokenKey);
    }
  }

  isAuthenticated(): boolean {
    return this.getToken() !== null;
  }

  canActivate(): boolean {
    if (this.isAuthenticated()) {
      return true;
    } else {
      this.router.navigate(['/login']);
      return false;
    }
  }

  login(username: string, password: string): Observable<any> {
    console.log('Login', username , password);
    const params = new HttpParams()
    .set('username', username)
    .set('password', password);
    return this.http.get<any>(`${this.apiUrl}/auth/login`, { params });
  }

  
};

export const authGuard: CanActivateFn = () => {
  const authService = inject(AuthService);
  const router = inject(Router);

  if (authService.isAuthenticated()) {
    return true;
  } else {
    router.navigate(['/login']);
    return false;
  }
};