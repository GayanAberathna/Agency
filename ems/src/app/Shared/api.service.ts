import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Employee} from '../model/employee';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  private BASE_URL = 'http://localhost:8080/employee';
  private ALL_EMPLOYEE_URL = `${this.BASE_URL}/home`;
  private REGISTER_EMPLOYEE_URL = `${this.BASE_URL}/register`;
  private UPDATE_EMPLOYEE_URL = `${this.BASE_URL}/update`;
  private GET_EMPLOYEE_BY_ID_URL = `${this.BASE_URL}/getbyid`;
  private DELETE_EMPLOYEE_URL = `${this.BASE_URL}/delete`;


  constructor(private http: HttpClient) { }

  getAllEmplyees(): Observable<Employee[]> {
    return this.http.get<Employee[]>(this.ALL_EMPLOYEE_URL);
  }

  getEmployeeByID(employeeId: number): Observable<Employee> {
    return  this.http.get<Employee>(this.GET_EMPLOYEE_BY_ID_URL + '?id=' + employeeId);
  }

  updateEmployee(employee: Employee): Observable<Employee> {
    return this.http.post<Employee>(this.UPDATE_EMPLOYEE_URL, employee);
  }

  deleteEmployee(id: number): Observable<any> {
    return this.http.delete(this.DELETE_EMPLOYEE_URL + '?id=' + id);
  }

  postEmployee(employee: Employee): Observable<Employee> {
    return this.http.post<Employee>(this.REGISTER_EMPLOYEE_URL, employee);
  }
}
