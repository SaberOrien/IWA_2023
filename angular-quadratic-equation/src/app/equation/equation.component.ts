import {Component, HostBinding, Input, OnInit} from '@angular/core';
import {Equation} from "./equation.model";

@Component({
  selector: 'app-equation',
  templateUrl: './equation.component.html',
  styleUrls: ['./equation.component.css']
})
export class EquationComponent implements OnInit{
  @HostBinding('attr.class') cssClass='row';
  @Input() equation: Equation;
  constructor() {
    //console.log(`Equation component constructor`)
    //this.equation = new Equation("1", "16", "4");
  }
  ngOnInit() {
  }
}
