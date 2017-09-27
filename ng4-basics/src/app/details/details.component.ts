import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  // styleUrls: ['./details.component.css']
styles: [`
h4 {
  color:blue;
}
`
]
})
export class DetailsComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
