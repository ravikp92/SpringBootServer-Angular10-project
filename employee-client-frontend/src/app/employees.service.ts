import { Employees } from './employees';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeesService {

  private baseUrl="http://localhost:8081/api/v1/employees";

  constructor(private httpClient: HttpClient) { }

  getEmployeeList(): Observable<Employees[]>{
    return this.httpClient.get<Employees[]>(this.baseUrl);
  }

  createEmployee(employee:Employees):Observable<Object>{
    return this.httpClient.post(this.baseUrl,employee);
  }

  
  getEmployeeById(id:number):Observable<Employees>{
    return this.httpClient.get<Employees>(`${this.baseUrl}/${id}`);
  }

  updateEmployee(id:number,employee:Employees):Observable<Object>{
    return this.httpClient.put(`${this.baseUrl}/${id}`,employee);
  }
  deleteEmployee(id:number):Observable<Object>{
    return this.httpClient.delete(`${this.baseUrl}/${id}`);
  }

}
