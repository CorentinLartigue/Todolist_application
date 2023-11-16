import {Component, Input} from '@angular/core';
import {Todo} from "../../model/Todo";
import {Router} from "@angular/router";

@Component({
  selector: 'app-todo-block',
  templateUrl: './todo-block.component.html',
  styleUrls: ['./todo-block.component.css']
})
export class TodoBlockComponent {

  @Input() todo!: Todo;
  constructor(private router: Router) {}

  openTodo(id: Number) {
    this.router.navigate(['/todos/'+id])
  }
}
