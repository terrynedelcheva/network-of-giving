import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import { Ng2SearchPipeModule } from 'ng2-search-filter';

import {AppComponent} from './app.component';
import {ClarityModule} from '@clr/angular';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {LoginFormComponent} from './login-form/login-form.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RegistrationFormComponent} from './registration-form/registration-form.component';
import {AppRoutingModule} from './app-routing.module';
import { CreateCharityComponent } from './create-charity/create-charity.component';
import { HttpClientModule } from '@angular/common/http';
import { CharitiesComponent } from './charities/charities.component';
import { CharityDetailsComponent } from './charity-details/charity-details.component';
import { LoggedUserHeaderComponent } from './logged-user-header/logged-user-header.component';
import { EditCharityComponent } from './edit-charity/edit-charity.component';
import { UserProfileComponent } from './user-profile/user-profile.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginFormComponent,
    RegistrationFormComponent,
    CreateCharityComponent,
    CharitiesComponent,
    CharityDetailsComponent,
    LoggedUserHeaderComponent,
    EditCharityComponent,
    UserProfileComponent
  ],
  imports: [
    BrowserModule,
    ClarityModule,
    BrowserAnimationsModule,
    FormsModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    Ng2SearchPipeModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
