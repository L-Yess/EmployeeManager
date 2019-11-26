import { Injectable } from '@angular/core';
import { Employee } from './employee.model';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  formData: Employee;
  list: Employee[];
  readonly rootURL="http://localhost:8080/employees";
  constructor(private http:HttpClient) { }

  postEmployee(formData: Employee){
    return this.http.post(this.rootURL, formData);
  }

  putEmployee(formData: Employee){
    return this.http.put(this.rootURL+"/"+formData.id, formData);
  }

  deleteEmployee(id:number){
    return this.http.delete(this.rootURL+"/"+id);
  }

  refreshList(){
    this.http.get(this.rootURL)
    .toPromise()
    .then( res => {
      this.list=res as Employee[];
    })
  }
}
