import { Component, OnInit } from '@angular/core';
import { EmployeeService } from 'src/app/shared/employee.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  constructor(public service:EmployeeService) { }

  ngOnInit() {
    this.resetForm();
  }

  resetForm(form?: NgForm){
    if(form!=null){
      form.resetForm();
    }
    
    this.service.formData={
      id:null,
      fullName:'',
      mobile:null,
      empCode:'',
      position:'',
    }
  }

  onSubmit(form: NgForm){
    if (form.value.id == null){
      this.insertRecord(form);
    }
    else
    this.updateRecord(form);
    this.service.refreshList();
  }

  updateRecord(form: NgForm){
      this.service.putEmployee(form.value)
      .subscribe(res => {
        this.resetForm(form);
      });
      this.service.refreshList();
  }

  insertRecord(form: NgForm){
    this.service.postEmployee(form.value)
    .subscribe(res => {
      this.resetForm(form);
    });
    this.service.refreshList();
  }
}
