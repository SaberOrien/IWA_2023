export class Solution {
  results: string = "";
  a: number;
  b: number;
  c: number;
  constructor(coefA: string, coefB: string, coefC: string) {
    if(isNaN(parseFloat(coefA)) || isNaN(parseFloat(coefB)) || isNaN(parseFloat(coefC))){
      this.results = "Incorrect input";
    }
    else{
      this.a = parseFloat(coefA);
      this.b = parseFloat(coefB);
      this.c = parseFloat(coefC);
      this.results = this.solveEquation();
    }
  }
  solveEquation(): string {
    let delta = Math.pow(this.b, 2) - 4 * this.a * this.c;
    if (delta < 0) {
      return "Equation has no real solutions";
    } else if (delta == 0) {
      let x0 = -this.b / (2 * this.a);
      return "Equation has one real solution: " + x0;
    } else {
      let x1 = (-this.b - Math.sqrt(delta)) / (2 * this.a);
      let x2 = (-this.b + Math.sqrt((delta)) / 2 * this.a);
      return "Equation has two real solutions: x1 = " + x1 + " and x2 = " + x2;
    }
  }
}
