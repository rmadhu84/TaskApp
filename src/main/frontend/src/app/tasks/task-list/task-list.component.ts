import { Component, OnInit } from '@angular/core';
import { Task } from '../task.model';
import { TaskClientService } from '../service/task-client.service';
import { Subscription } from 'rxjs';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.css']
})
export class TaskListComponent implements OnInit {

  /* 
   //Using the Default way to subscribing of observable.
   //When you do not subscribe to an observable, you need to use async pipe in the *ngFor 
   //	to subscribe to the observable. Doing this is much cleaner way to subscribe, as this takes 
   //	care of unsubscribtion when the component is destroyed.
 	
   //
   //subscription : Subscription;
   */
  tasks: Task[];
  subscription: Subscription;
  //tasks: Observable<Task[]>; //use this when invoking getAllTasks without subscribe.

  constructor(private service: TaskClientService) { }

  ngOnInit() {

		/* Adding elements to an array
		this.tasks.push(new Task(1, "Task 1", true,"01/17/2020"));
		this.tasks.push(new Task(2, "Task 2", false,"01/12/2020"));
		this.tasks.push(new Task(3, "Task 3", false,"01/15/2020"));
		this.tasks.push(new Task(4, "Task 4", true, "01/20/2020"));*/

    // this.tasks = this.service.getAllTasks();

    /* Using the Default way to subscribing of observable.*/
    this.subscription = this.service.getTasks().subscribe((response) => { this.tasks = response }, (error) => console.log(error));

    this.subscription = this.service.onTaskAdded.subscribe((task:Task)=>{
      this.tasks.push(task);
    })

  }

  ngOnDestroy() {
		console.log("Unsubscribing!!")
		this.subscription.unsubscribe();
	}

  getDueDateLabel(task: Task) {
    return task.completed ? 'badge-success' : 'badge-primary';
  }

  onTaskChange(event, task: Task) {
    console.log(event.target.checked);
    //subscribe() is required while writing data back to db.
    this.subscription = this.service.saveTask(task, event.target.checked).subscribe((error) => console.log(error));
  }
}
