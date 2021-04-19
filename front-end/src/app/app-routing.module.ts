import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {Routes, RouterModule} from '@angular/router';
import {LoginFormComponent} from './login-form/login-form.component';
import {RegistrationFormComponent} from './registration-form/registration-form.component';
import {CreateCharityComponent} from './create-charity/create-charity.component';
import {CharitiesComponent} from './charities/charities.component';
import {CharityDetailsComponent} from './charity-details/charity-details.component';
import {LoggedUserHeaderComponent} from './logged-user-header/logged-user-header.component';
import {EditCharityComponent} from './edit-charity/edit-charity.component';

const routes: Routes = [{
  path: '',
  redirectTo: '/charities',
  pathMatch: 'full'
}, {
  path: 'create-charity',
  component: CreateCharityComponent
}, {
  path: 'charities',
  component: CharitiesComponent
}, {
  path: 'login',
  component: LoginFormComponent,
  /*canActivate: [AuthGuard]*/
}, {
  path: 'registration',
  component: RegistrationFormComponent
}, {
  path: 'charity-details',
  component: CharityDetailsComponent
}, {
  path: 'login-header',
  component: LoginFormComponent
}, {
  path: 'charity-details/:id',
  component: CharityDetailsComponent
}, {
  path: 'edit-charity/:id',
  component: EditCharityComponent
}, {
  path: '**',
  redirectTo: '/charities',
  pathMatch: 'full'
}/*, {
  path: 'logged-user',
  component: LoggedUserHeaderComponent
}*/
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {onSameUrlNavigation: 'reload'})],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
