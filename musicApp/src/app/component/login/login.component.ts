import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../guard/auth.service'

import { FormsModule } from '@angular/forms';
import { TokenInterceptor } from '../../guard/token.interceptor'; // Importa TokenInterceptor
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http'; // Importa HttpClientModule y HTTP_INTERCEPTORS
@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule, HttpClientModule
      ],
  providers: [AuthService,
    { provide: HTTP_INTERCEPTORS, useClass: TokenInterceptor, multi: true } // Añade el interceptor aquí
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  username: string = '';
  password: string = '';

  constructor(private authService: AuthService, private router: Router) {}


  login(): void {
    console.log('Login', this.username, this.password);
    
    this.authService.login(this.username, this.password).subscribe({
      next: (response) => {
        localStorage.setItem('token', response.token);
        this.router.navigate(['/list-playlist']);  
      },
      error: (error) => {
        console.error('Error de login', error);
      }
    });
  }


  navigateToRegister() {
    this.router.navigate(['/form-user']);
  }
}
