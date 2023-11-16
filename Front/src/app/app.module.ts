import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { TodoDetailsComponent } from './todo/todo-details/todo-details.component';
import {HttpClientModule} from "@angular/common/http";
import { TodoListComponent } from './todo/todo-list/todo-list.component';
import { TodoBlockComponent } from './todo/todo-block/todo-block.component';
import { AppRoutingModule } from './app.routing.module';
import {FormsModule} from "@angular/forms";
import {RouterLink, RouterOutlet} from "@angular/router";

@NgModule({
  declarations: [
    AppComponent,
    TodoDetailsComponent,
    TodoListComponent,
    TodoBlockComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    RouterLink,
    RouterOutlet
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
