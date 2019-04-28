import { Component, OnInit } from '@angular/core';
import {ApiService} from '../Shared/api.service';
import {Employee} from "../model/employee";

@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.css']
})
export class EmployeesComponent implements OnInit {
  emplyees: Employee[] = [];
  selectedemplyee: Employee;
  searchText: number;
  emplyeeHeader: string = "Employee List";
  noEmployee: string = "There are no Employees to display  :(";
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
        alert("An error has occurred while feching Employees;")
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
        alert("An error has occurred while feching Employees;")
      }
    );
  } else {
      this.getAllEmplyees();
    }
  }
  
  
  
  
}

