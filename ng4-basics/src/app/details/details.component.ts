import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  // styleUrls: ['./details.component.css']
styles: [`
h4 {
  color:blue;
}
.after5 {
  color:white;

}
`
]
})
export class DetailsComponent implements OnInit {
   visible = true;
  username:string = "";

   // Number
   messageCount:number = 0;
   messageList = [];

  constructor() { }

  ngOnInit() {
  }

  // ---------- Event Handlers
 doButtonClick ( e) {
   this.messageCount++;
   console.debug('in button click');
   this.visible = !this.visible;
   let m = {
     time: Date.now(),
     count: this.messageCount

   };
   this.messageList.push(m);
  }

}
