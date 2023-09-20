import { Component } from '@angular/core';
import { TodoService } from './todo.service';
import { Todo } from './todo';
import { FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-project',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css'],
})
export class TodoComponent {
  todo: Todo = {
    id: 0,
    done: false,
    description: '',
    title: '',
  };

  title: string = '';
  id: number = 0;

  todoList: Todo[] = [];

  todoForm = this.formBuilder.group({
    completed: [false],
    url: [''],
    description: [''],
    title: [''],
  });

  constructor(
    private todoService: TodoService,
    private formBuilder: FormBuilder
  ) {}

  getAllTodos() {
    this.todoService
      .getAllTodos()
      .subscribe((elements) => (this.todoList = elements));
  }

  getOneTodoById() {
    this.todoService
      .getOneTodoById(this.id)
      .subscribe((element) => {
        this.id = 0;
        this.todo = element;
      });
  }

  addTodo() {
    this.todoService
      .addTodo(this.todoForm.value as Todo)
      .subscribe((element) => this.todoList.push(element));
  }

  updateTodo() {
    return this.todoService
      .updateTodoWithId(this.todoForm.value as Todo)
      .subscribe((element) => this.getAllTodos());
  }

  deleteTodo() {
    return this.todoService
      .deleteTodo(this.id)
      .subscribe((element) => {
        this.getAllTodos();
        this.id = 0;
      });
  }
}
