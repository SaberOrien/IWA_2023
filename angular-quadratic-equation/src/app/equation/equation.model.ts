export class Equation {
  coefA: number;
  coefB: number;
  coefC: number;
  result: string = "0";
  constructor(coefA: string, coefB: string, coefC: string, result: string) {
    //console.log(`Was here`);
    this.result = result;
    if(isNaN(parseFloat(coefA)) || isNaN(parseFloat(coefB)) || isNaN(parseFloat(coefC))){
      this.result = "Incorrect input.";
    }
    else{
      this.coefA = parseFloat(coefA);
      this.coefB = parseFloat(coefB);
      this.coefC = parseFloat(coefC);
      this.result = this.solveEquation();
    }
  }

  solveEquation(): string{
    let delta = Math.pow(this.coefB, 2) - 4 * this.coefA * this.coefC;
    if (delta < 0) {
      return "Equation has no real solutions";
    } else if (delta == 0) {
      let x0 = -this.coefB / (2 * this.coefA);
      return "Equation has one real solution: " + x0;
    } else {
      let x1 = (-this.coefB - Math.sqrt(delta)) / (2 * this.coefA);
      let x2 = (-this.coefB + Math.sqrt((delta)) / 2 * this.coefA);
      return "Equation has two real solutions: x1 = " + x1 + " and x2 = " + x2;
    }
  }
}
