import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {catchError, Observable, of} from "rxjs";
import {Todo} from "../model/Todo";

@Injectable({
  providedIn: 'root'
})
export class TodoService {

  private url = 'http://localhost:8080/todos'
  private httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) { }

  getTodos(): Observable<Todo[]> {
    return this.http.get<Todo[]>(this.url);
  }

  getTodoById(id: Number): Observable<Todo> {
    return this.http.get<Todo>(this.url+"/"+id);
  }

  update(todo: Todo): Observable<any> {
    let updateUrl = this.url + "/" + todo.id
    return this.http.put(updateUrl, todo, this.httpOptions).pipe(catchError(this.handleError<any>('updateTodo')))
  }

  delete(todo: Todo): Observable<any> {
    let deleteUrl = this.url + "/" + todo.id
    return this.http.delete(deleteUrl, this.httpOptions).pipe(catchError(this.handleError<any>('deleteTodo')))
  }


  create(todo: Todo): Observable<any> {
    let createUrl = this.url + "/" + todo.id
    return this.http.post(createUrl, todo, this.httpOptions).pipe(catchError(this.handleError<any>('createTodo')))
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      this.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

  /** Log a HeroService message with the MessageService */
  private log(message: string) {
    console.log(message);
  }
}
