import { Component, OnInit } from '@angular/core';
import {ApiService} from '../Shared/api.service';
import {Employee} from '../model/employee';
import {formatDate} from '@angular/common';
@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.css']
})
export class EmployeesComponent implements OnInit {
  emplyees: Employee[] = [];
  selectedemplyee: Employee;
  searchText: number;
  emplyeeHeader = 'Employee List';
  noEmployee = 'There are no Employees to display  :(';
  constructor(private apiService: ApiService) { }

  ngOnInit() {
    this.getAllEmplyees();
  }

  public getAllEmplyees() {
    this.apiService.getAllEmplyees().subscribe(
      res => {
        this.emplyees = res;
      },
      err => {
        alert('An error has occurred while feching Employees;');
      }
    );
  }

  public getEmployeeByID() {
    if (this.searchText) {
    this.apiService.getEmployeeByID(this.searchText).subscribe(
      res => {
        this.emplyees = [];
        this.selectedemplyee = res;
        this.emplyees.push(this.selectedemplyee);
      },
      err => {
        alert('An error has occurred while feching Employees;');
      }
    );
  } else {
      this.getAllEmplyees();
    }
  }

  public updateEmployee(updatedEmployee: Employee) {
    this.apiService.updateEmployee(updatedEmployee).subscribe(
      res => {
        alert('successfully updated the Employee');
      },
      err => {alert('An error has occurred while updating the Employee'); }
    );
  }

  deleteEmployee(employee: Employee) {
    if (confirm('Are you sure you want to delete Employee?')) {
      this.apiService.deleteEmployee(employee.id).subscribe(
        res => {
          const indexOfEmployee = this.emplyees.indexOf(employee);
          this.emplyees.splice(indexOfEmployee, 1);
          alert('Successfully deleted Employee');
        },
        err => {
          alert('Could not delete Employee');
        }
      );
    }
  }
  // just for testing
  createEmployee() {
    const newEmployee: Employee = {
      id: null,
      firstName: 'test 1',
      lastName: 'test 2',
      address: 'testing address',
      birthDay: new Date('30-34-1994')
    };

    this.apiService.postEmployee(newEmployee).subscribe(
      res => {
        alert('Employee added successfully');
      },
      err => {alert('An error has occurred while saving the employee'); }
    );

  }
}

