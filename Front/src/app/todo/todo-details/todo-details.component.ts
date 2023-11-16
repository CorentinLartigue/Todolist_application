import {Component, Input} from '@angular/core';
import {Todo} from "../../model/Todo";
import {TodoService} from "../../services/todo.service";
import {Statut} from "../../model/Statut";
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-todo-details',
  templateUrl: './todo-details.component.html',
  styleUrls: ['./todo-details.component.css']
})
export class TodoDetailsComponent {

  todo!: Todo;
  mode: String = "Edit"
  statuts = Object.values(Statut)

  constructor(
    private todoService: TodoService,
    private router: Router,
    private route: ActivatedRoute ) {
    const id_todo: Number = Number(this.route.snapshot.paramMap.get("id"))
    this.todoService.getTodoById(id_todo).subscribe(todo => this.todo = todo)
    for (let statut of this.statuts) {
      console.log(statut)
    }

  }

  changeMode() {
    if (this.mode==="Edit") {
      this.mode = "Annuler"
    } else {
      this.mode = "Edit"
    }
  }

  updateTodo() {
    console.log("update")
    this.todoService.update(this.todo).subscribe(()=>this.changeMode());

  }

  deleteTodo() {
    console.log("delete")
    if(confirm("Vous allez supprimer votre todo, êtes-vous sûr de votre choix?")) {
      this.todoService.delete(this.todo).subscribe(() => {
        console.log('Todo supprimer avec succès');
        this.router.navigate(['/todos']);
      });
    }
  }



}
