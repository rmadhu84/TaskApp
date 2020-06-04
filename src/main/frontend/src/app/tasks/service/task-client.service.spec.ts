import { TestBed } from '@angular/core/testing';

import { TaskClientService } from './task-client.service';

describe('TaskClientService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: TaskClientService = TestBed.get(TaskClientService);
    expect(service).toBeTruthy();
  });
});
