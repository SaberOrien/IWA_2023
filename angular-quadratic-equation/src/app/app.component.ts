import { Component } from '@angular/core';
import {Equation} from "./equation/equation.model";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  equation: Equation;
  solveEquation(coefA: HTMLInputElement, coefB: HTMLInputElement, coefC: HTMLInputElement): boolean{
    console.log(`Solving ${coefA.value}x2 + ${coefB.value}x + ${coefC.value}`);
    this.equation = new Equation(coefA.value, coefB.value, coefC.value, "");
    coefA.value = '';
    coefB.value = '';
    coefC.value = '';
    return false;
  }
}
