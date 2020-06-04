import { Component, OnInit } from '@angular/core';
import { TaskClientService } from '../service/task-client.service';
import { Task } from '../task.model';
import { DateFormatPipe } from '../DateFormatPipe';

@Component({
  selector: 'app-tasks-add',
  templateUrl: './tasks-add.component.html',
  styleUrls: ['./tasks-add.component.css']
})
export class TasksAddComponent implements OnInit {
  addTaskValue: string = null;

  constructor(private service:TaskClientService, private _dateFormatPipe:DateFormatPipe) { }

  ngOnInit() {
  }

  onTaskAdd(event){
    let test = new Date();
    
    console.info(this.addDays(test,2));
    let today = this._dateFormatPipe.transform(this.addDays(new Date, 3));
    let task :Task = new Task(event.target.value, false, today);
    console.log(task);
    
    this.service.addTask(task).subscribe((newTask : Task)=>{
      //Clear the input
      this.addTaskValue = ' ';

      this.service.onTaskAdded.emit(newTask);
    });

  }

  addDays(date : Date, days:number):Date{
    date.setDate(date.getDate()+days);
    return date;
  }

  getTodayAsString() : string{
    let today = new Date();
    let dd:any = today.getDate();
    let mm:any = today.getMonth();
    let YYYY:any = today.getFullYear;

    if(dd < 10){
      dd = '0'+dd;
    }
    if(mm < 10){
      mm = '0'+mm;
    }
    return mm+'/'+dd+'/'+YYYY;
  }

}
