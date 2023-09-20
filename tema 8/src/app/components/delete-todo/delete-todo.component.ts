import { Component } from '@angular/core';
import { TodoService } from '../todo/todo.service'; // Adjust the import path accordingly

@Component({
  selector: 'app-delete-todo',
  templateUrl: './delete-todo.component.html',
  styleUrls: ['./delete-todo.component.css']
})
export class DeleteTodoComponent {

  constructor(private todoService: TodoService) { }

  onDelete(idString: string): void {
    const id = Number(idString);
    if (!isNaN(id)) {
      this.todoService.deleteTodo(id).subscribe(
        response => {
          console.log('Todo deleted successfully!', response);
          // Handle additional logic here, if needed.
        },
        error => {
          console.error('Error deleting todo!', error);
        }
      );
    } else {
      console.error('Invalid ID provided!');
    }
  }
}