import { EmployeesService } from './../employees.service';
import { Employees } from './../employees';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-employees-list',
  templateUrl: './employees-list.component.html',
  styleUrls: ['./employees-list.component.css']
})
export class EmployeesListComponent implements OnInit {

  employees : Employees[];

  constructor(private employeeService: EmployeesService,
    private router: Router) { }

  ngOnInit(): void {
    this.getEmployees();

  }
  private getEmployees(){
    this.employeeService.getEmployeeList().subscribe(data =>{
      this.employees=data;
    });
  }

   updateEmployee(id : number){
      this.router.navigate(['update-employee',id]);
  }

  deleteEmployee(id:number){
     this.employeeService.deleteEmployee(id).subscribe(data =>{
       console.log(data);
      this.getEmployees();
    });
  }

  employeeDetails(id:number){
    this.router.navigate(['employee-details',id]);
  }


}
