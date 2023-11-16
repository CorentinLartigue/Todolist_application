import { Component } from '@angular/core';
import {TodoService} from "../../services/todo.service";
import {Todo} from "../../model/Todo";
import {Statut} from "../../model/Statut";

@Component({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.css']
})
export class TodoListComponent {

  todos: Todo[]
  todo: Todo = {} as Todo
  modeCreation: String = "Create"
  statuts = Object.values(Statut)
  date = new Date().toISOString().split("T")[0]

  constructor( private todoService: TodoService) {
    this.todos = []
    todoService.getTodos()
      .subscribe(todos => this.todos = todos)
    for (let statut of this.statuts) {
      console.log(statut)
    }
  }


  changeModeCreate() {
    if (this.modeCreation==="Create") {
      this.modeCreation = "Annuler"
    } else {
      this.modeCreation = "Create"
    }
  }

  createTodo() {
    console.log("create")
    this.todoService.create(this.todo).subscribe(()=>this.changeModeCreate());
  }


}
