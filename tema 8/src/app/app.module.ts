import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { TodoComponent } from './components/todo/todo.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { TodosComponent } from './components/todos/todos.component';
import { AddTodoComponent } from './components/add-todo/add-todo.component';
import { AppRoutingModule } from './app-routing.module';
import { RouterLink } from '@angular/router';
import { DeleteTodoComponent } from './components/delete-todo/delete-todo.component';
import { SearchTodoComponent } from './components/search-todo/search-todo.component';

@NgModule({
  declarations: [
    AppComponent,
    TodoComponent,
    TodosComponent,
    AddTodoComponent,
    DeleteTodoComponent,
    SearchTodoComponent
    
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    AppRoutingModule,
    RouterLink,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
