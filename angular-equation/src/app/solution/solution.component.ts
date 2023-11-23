import {Component, HostBinding, Input, OnInit} from '@angular/core';
import {Solution} from "./solution.model";

@Component({
  selector: 'app-solution',
  templateUrl: './solution.component.html',
  styleUrls: ['./solution.component.css']
})
export class SolutionComponent implements OnInit{
  @HostBinding('attr.class') cssClass = 'row';
  @Input() solution: Solution;
  constructor(){
  }

  ngOnInit() {
  }
}
