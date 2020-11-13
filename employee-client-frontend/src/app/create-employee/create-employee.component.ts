
import { EmployeesService } from './../employees.service';
import { Component, OnInit } from '@angular/core';
import { Employees } from '../employees';
import { Router } from '@angular/router';


@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {

  employee:Employees=new Employees();
  constructor(private employeeService:EmployeesService
    ,private router: Router) { }

  ngOnInit(): void {
  }

  saveEmployee(){
    this.employeeService.createEmployee(this.employee).subscribe(data => 
      {
        console.log(data);
        this.goToEmployeeList();
      },
      error => console.log(error)) ;
  }

  goToEmployeeList(){
      this.router.navigate(['/listOfemployees']);
  }

  onSubmit(){
    console.log(this.employee);
    this.saveEmployee();
  }

}
