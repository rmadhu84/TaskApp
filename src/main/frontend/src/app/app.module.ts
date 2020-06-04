import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TasksComponent } from './tasks/tasks.component';
import { TasksAddComponent } from './tasks/tasks-add/tasks-add.component';
import { TaskListComponent } from './tasks/task-list/task-list.component';
import { HttpClientModule } from '@angular/common/http'
import { TaskClientService } from './tasks/service/task-client.service';
import { DateFormatPipe } from './tasks/DateFormatPipe';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    TasksComponent,
    TasksAddComponent,
    TaskListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [TaskClientService,DateFormatPipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
