import { Component } from '@angular/core';
import { TodoService } from '../todo/todo.service'; // Adjust the path as necessary
import { Todo } from '../todo/todo'; // Adjust the path as necessary

@Component({
  selector: 'app-search-todo',
  templateUrl: './search-todo.component.html',
  styleUrls: ['./search-todo.component.css']
})
export class SearchTodoComponent {

  searchId: number = 0;
  foundTodo: Todo | undefined;

  constructor(private todoService: TodoService) { }

  onSearch(): void {
    this.todoService.getOneTodoById(this.searchId).subscribe(
      todo => {
        this.foundTodo = todo;
      },
      error => {
        console.error('Error searching for todo!', error);
      }
    );
  }
}
