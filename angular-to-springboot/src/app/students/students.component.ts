import { Component, OnInit } from '@angular/core';
import {Student} from "./student.model";
import {StudentService} from "./student.service";
import {first} from "rxjs";

@Component({
  selector: 'app-students',
  templateUrl: './students.component.html',
  styleUrls: ['./students.component.css']
})
export class StudentsComponent implements OnInit {
  studentList?: Student[];
  newStudent?: Student;
  student?: Student;

  constructor(private studentService: StudentService) { }

  ngOnInit() { this.getStudents();   }

  getStudents(): void {
    this.studentService.getStudents()
      .subscribe(studentList => this.studentList = studentList);
  }

  add(firstname: string, lastname: string, email: string, telephone: string): void {
    firstname = firstname.trim();
    lastname = lastname.trim();
    email = email.trim();
    telephone = telephone.trim();
    this.studentService.addStudent({ firstname, lastname, email, telephone } as Student)
      .subscribe({
        next: (student: Student) => { this.studentList?.push(student); },
        error: () => {},
        complete: () => {
          if (this.studentList != undefined) {
            this.studentService.totalItems.next(this.studentList.length);
            console.log(this.studentList.length);
          }
        }
      });
  }

  delete(student: Student): void {
    this.studentList = this.studentList?.filter(c => c !== student);
    this.studentService.deleteStudent(student).subscribe(() => {
        // for automatic update of number of students in parent component
        if(this.studentList != undefined) {
          this.studentService.totalItems.next(this.studentList.length);
          console.log(this.studentList.length);
        }
      }
    );
  }

  deleteAll(): void {
    this.studentService.deleteStudents().subscribe(() => {
        if(this.studentList != undefined) {
          this.studentList.length = 0;
        }
      }
    );
  }

  update(firstname: string, lastname: string, email: string, telephone: string, chosenToUpdateStudent: Student):void {
    let id = chosenToUpdateStudent.id;
    firstname = firstname.trim();
    lastname = lastname.trim();
    email = email.trim();
    telephone = telephone.trim();
    console.log(id);
    if (id != undefined) {
      this.studentService.updateStudent({firstname, lastname, email, telephone} as Student, id)
        .subscribe({
          next: (student: Student) => {
            if (this.studentList != undefined) {
              let index = this.studentList?.indexOf(chosenToUpdateStudent);
              this.studentList[index] = student;
            }
          },
          error: () => {
          },
          complete: () => {
            if (this.studentList != undefined) {
              this.studentService.totalItems.next(this.studentList.length);
              console.log(this.studentList.length);
            }
          }
        })
    }
  }

  /*patch(chosenToUpdateStudent: Student, firstname?: string, lastname?: string, email?: string, telephone?: string):void{
    let id = chosenToUpdateStudent.id;
    console.log(id);
    if (id != undefined) {
      let updates = new Map<string, string>();
      if (firstname != undefined && firstname.length != 0) {
        console.log('Firstname: ' + firstname);
        updates.set("firstname", firstname);
      }
      if (lastname != undefined && lastname.length != 0) {
        console.log('Lastname: ' + lastname);
        updates.set("lastname", lastname);
      }
      if (email != undefined && email.length != 0) {
        console.log('Email: ' + email);
        updates.set("email", email);
      }
      if (telephone != undefined && telephone.length != 0) {
        console.log('Telephone: ' + telephone);
        updates.set("telephone", telephone);
      }

    }
  }*/

  patch(firstname: string, lastname: string, email: string, telephone: string, chosenToPatchedStudent: Student): void {
    let id = chosenToPatchedStudent.id;
    let index = this.studentList?.indexOf(chosenToPatchedStudent);

    if (id != undefined && this.studentList != undefined && index != undefined) {
      if (firstname.trim() !== "") {
        firstname = firstname.trim();
      } else {
        firstname = this.studentList[index].firstname;
      }
      if (lastname.trim() !== "") {
        lastname = lastname.trim();
      } else {
        lastname = this.studentList[index].lastname;
      }
      if (email.trim() !== "") {
        email = email.trim();
      } else {
        email = this.studentList[index].email;
      }
      if (telephone.trim() !== "") {
        telephone = telephone.trim();
      } else {
        telephone = this.studentList[index].telephone;
      }
      console.log(id);
    }

    if (id != undefined) {
      this.studentService.patchStudent({firstname, lastname, email, telephone} as Student, id)
        .subscribe({
            next: (student: Student) => {
              if (this.studentList != undefined) {
                let index = this.studentList?.indexOf(chosenToPatchedStudent);
                this.studentList[index] = student;
              }
            },
            error: () => {},
            complete: () => {
              if (this.studentList != undefined) {
                this.studentService.totalItems.next(this.studentList.length);
                console.log(this.studentList.length);
              }
            }
          }
        );
    }
  }

  updateAll(firstname: string, lastname: string, email: string, telephone: string): void {
    firstname = firstname.trim();
    lastname = lastname.trim();
    email = email.trim();
    telephone = telephone.trim();

    let studentListTest: Student[] = [];

    let studentListTestLength: number = 0;
    while (this.studentList != undefined && studentListTestLength != this.studentList?.length) {
      this.studentList[studentListTestLength].firstname = firstname;
      this.studentList[studentListTestLength].lastname = lastname;
      this.studentList[studentListTestLength].email = email;
      this.studentList[studentListTestLength].telephone = telephone;
      studentListTestLength++;
    }
    if (this.studentList != undefined) {
      studentListTest = this.studentList;
    }

    this.studentService.updateStudents(studentListTest)
      .subscribe({
          error: () => {},
          complete: () => {
            if (this.studentList != undefined) {
              this.studentService.totalItems.next(this.studentList.length);
              console.log(this.studentList.length);
            }
          }
        }
      );

  }

}

