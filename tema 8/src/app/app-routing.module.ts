import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddTodoComponent } from './components/add-todo/add-todo.component';
import { TodosComponent } from './components/todos/todos.component';
import { TodoComponent } from './components/todo/todo.component';
import { DeleteTodoComponent } from './components/delete-todo/delete-todo.component';
import { SearchTodoComponent } from './components/search-todo/search-todo.component';

const routes: Routes = [
  { path: 'add-todo', component: AddTodoComponent },
  { path: 'todos', component: TodosComponent },
  { path: 'delete', component: DeleteTodoComponent},
  { path: 'search', component: SearchTodoComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
