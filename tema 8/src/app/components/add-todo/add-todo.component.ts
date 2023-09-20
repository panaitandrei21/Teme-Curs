import { Component } from '@angular/core';
import { Todo } from '../todo/todo';
import { TodoService } from '../todo/todo.service';
import { FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-add-project',
  templateUrl: './add-todo.component.html',
  styleUrls: ['./add-todo.component.css'],
})
export class AddTodoComponent {
  constructor(
    private todoService: TodoService,
    private formBuilder: FormBuilder
  ) {}

  todoForm = this.formBuilder.group({
    id: [0],
    completed: [ false ],
    description: [''],
    title: [''],
  });
  addTodo() {
    this.todoService
      .addTodo(this.todoForm.value as Todo)
      .subscribe((element) => console.log('Todo added successfully'));
  }
}
