import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from '../component/login/login.component';
import { ListSongsComponent } from '../component/list-songs/list-songs.component';
import { FormPlaylistComponent } from '../component/form-playlist/form-playlist.component';
import { FormUserComponent } from '../component/form-user/form-user.component';
import { AuthService } from '../guard/auth.service';
import { FormsModule } from '@angular/forms'; // Import FormsModule
import { HttpClientModule } from '@angular/common/http'; // Importa HttpClientModule

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    HttpClientModule,
    FormsModule
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
