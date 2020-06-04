import { Injectable, EventEmitter } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Task } from '../task.model';



@Injectable({
  providedIn: 'root'
})
export class TaskClientService {

  onTaskAdded = new EventEmitter();
  
  constructor(private TaskClient: HttpClient) { }

  getTasks(): Observable<any> {
    return this.TaskClient.get('/api/tasks/getAllTasks/');
  }

  saveTask(task: Task, checked: boolean) {
    task.completed = checked;
    return this.TaskClient.post('/api/tasks/save', task);
  }

  addTask(task: Task) {
    return this.TaskClient.post('/api/tasks/save', task);
  }
}
