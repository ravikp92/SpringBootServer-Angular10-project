import { EmployeesService } from './../employees.service';
import { Component, OnInit } from '@angular/core';
import { Employees } from '../employees';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit {

 
  employee:Employees=new Employees();
  id: number;
  constructor(private employeeService : EmployeesService,
    private route:ActivatedRoute,private router:Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.employeeService.getEmployeeById(this.id).subscribe(data => {
      this.employee = data;
    },error => console.error(error));
  }

  onSubmit(){
    this.employeeService.updateEmployee(this.id,this.employee).subscribe(data=>
      {
        this.goToEmployeeList();
      },
      error=> console.log(error)
      );
  }
  goToEmployeeList(){
    this.router.navigate(['/listOfemployees']);
}
}
