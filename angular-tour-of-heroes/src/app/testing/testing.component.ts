import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-testing',
  templateUrl: './testing.component.html',
  styleUrls: ['./testing.component.css']
})
export class TestingComponent implements OnInit{
  clickMessage = '';
  wasClicked = 0;
  showHover = 0;
  showInput = 0;
  submitted = 0;
  apologyMessage = '';
  tempName = '';
  tempId = 0;
  submitmsg = '';
  names: string[] = ["Avalina", "Eleanor", "Wentworth", "Wolfgang", "Magnus"];

  onClickMe(){
    this.clickMessage='Stop clicking on me!';
    this.wasClicked++;
  }
  apology(){
    this.apologyMessage='Stop taking orders from a button';
  }

  onShowHover(){
    this.showHover++;
  }

  onInput(){
    this.showInput++;
  }

  onMouseEnter(hoverName: HTMLElement){
    hoverName.style.color="red";
  }

  onMouseOut(hoverName: HTMLElement){
    hoverName.style.color="black";
  }

  ngOnInit(): void {
  }

  getName(val:string){
    this.tempName = val;
  }

  getId(val: number){
    this.tempId = val;
  }

  submit(){
    this.submitted++;
    this.submitmsg = 'You submitted person ' + this.tempName + ' with request id ' + this.tempId;
    this.names.push(this.tempName);
  }

}
