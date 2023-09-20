import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Todo } from './todo';

@Injectable({
  providedIn: 'root'
})
export class TodoService {
  private readonly BASE_URL = 'http://localhost:4000/todo';

  constructor(private readonly client: HttpClient) {}

  getAllTodos(): Observable<Todo[]> {
    return this.client.get<Todo[]>(this.BASE_URL);
  }

  getOneTodoById(id: number): Observable<Todo> {
    const endpoint = `${this.BASE_URL}/${id}`;
    return this.client.get<Todo>(endpoint);
  }

  addTodo(todo: Todo): Observable<Todo> {
    return this.client.post<Todo>(this.BASE_URL, todo);
  }

  updateTodoWithId(todo: Todo): Observable<Todo> {
    const endpoint = `${this.BASE_URL}/${todo.id}`;
    return this.client.put<Todo>(endpoint, todo);
  }

  deleteTodo(id: number): Observable<Todo> {
    const endpoint = `${this.BASE_URL}/${id}`;
    return this.client.delete<Todo>(endpoint);
  }
}
