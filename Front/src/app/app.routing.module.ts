import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {TodoListComponent} from "./todo/todo-list/todo-list.component";
import {TodoDetailsComponent} from "./todo/todo-details/todo-details.component";

const routes: Routes = [
  { path: 'todos', component: TodoListComponent },
  { path: "todos/:id", component: TodoDetailsComponent }

];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule { }
