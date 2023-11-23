import { Component } from '@angular/core';
import {Solution} from "./solution/solution.model";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  solutions: Solution[];
  //solution: Solution;
  constructor() {
    this.solutions = [];
  }
  getEquation(coefA: HTMLInputElement, coefB: HTMLInputElement, coefC: HTMLInputElement): boolean {
    console.log(`Solving equation: ${coefA.value} x^2 + ${coefB.value}x + ${coefC.value}`);
    this.solutions = [];
    this.solutions.push(new Solution(coefA.value, coefB.value, coefC.value));
    //this.solution = new Solution(coefA.value, coefB.value, coefC.value);
    coefA.value='';
    coefB.value='';
    coefC.value='';
    return false;
  }
}
