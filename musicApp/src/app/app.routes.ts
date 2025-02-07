import { Routes } from '@angular/router';
import { LoginComponent } from './component/login/login.component';
import { ListSongsComponent } from './component/list-songs/list-songs.component';
import { FormPlaylistComponent } from './component/form-playlist/form-playlist.component';
import { FormUserComponent } from './component/form-user/form-user.component';
import { authGuard } from './guard/auth.service';
import { ListPlaylistComponent } from './component/list-playlist/list-playlist.component';


export const routes: Routes = [
    { path: 'login', component: LoginComponent },
  { path: 'form-user', component: FormUserComponent },
  {
    path: 'list-songs', 
    component: ListSongsComponent,
    canActivate: [],
    data: { title: 'List Songs' }
  },
  {
    path: 'list-playlist', 
    component: ListPlaylistComponent,
    canActivate: [authGuard]
  },
  {
    path: 'form-playlist',
    component: FormPlaylistComponent,
    canActivate: [authGuard]
  },
  { path: '**', redirectTo: '/login', pathMatch: 'full' }
];
