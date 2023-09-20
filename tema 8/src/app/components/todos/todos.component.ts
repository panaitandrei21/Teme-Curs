import { Component, OnInit } from '@angular/core';
import { Todo } from '../todo/todo';
import { TodoService } from '../todo/todo.service';
import { FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-projects',
  templateUrl: './todos.component.html',
  styleUrls: ['./todos.component.css'],
})
export class TodosComponent implements OnInit {
  constructor(private todoService: TodoService) {}

  todoList: Todo[] = [];
  getAllTodos() {
    this.todoService
      .getAllTodos()
      .subscribe((elements) => (this.todoList = elements));
  }

  ngOnInit(): void {
    this.getAllTodos();
  }
}
