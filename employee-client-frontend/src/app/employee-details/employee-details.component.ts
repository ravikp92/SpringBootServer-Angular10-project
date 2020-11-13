import { EmployeesService } from './../employees.service';
import { ActivatedRoute } from '@angular/router';
import { Employees } from './../employees';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.css']
})
export class EmployeeDetailsComponent implements OnInit {

  id:number;
  employee:Employees;
  constructor(private route:ActivatedRoute,private employeeService:EmployeesService) { }

  ngOnInit(): void {
    this.id=this.route.snapshot.params['id'];

    this.employee=new Employees();
    this.employeeService.getEmployeeById(this.id).subscribe(data => {
      this.employee=data;
    })

  }

}
