import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../guard/auth.service'

import { FormsModule } from '@angular/forms'; // Import FormsModule
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule, HttpClientModule
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
        this.router.navigate(['/list-songs']);  
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
