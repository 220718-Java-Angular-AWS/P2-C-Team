import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import { ItemComponent } from 'src/app/components/item/item.component';
import { Item } from 'src/app/models/item.model';
import { ItemService } from '../../services/item.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  items: Item[] = [];
  nintendoForm: boolean = false;
  playstationForm: boolean = false;
  pcForm: boolean = false;
  xboxForm: boolean = false;


  constructor(private itemService: ItemService) {
      this.itemService.getAllItems().subscribe({
        next: data => {
          console.log(data)

        },
        error: data => console.log(data)
      });
   }


  ngOnInit(): void {
    this.itemService.items$.subscribe({
      next: data => this.items = data
    })
  }

  onClickItem(active: String){
    if(active === 'home'){
      this.nintendoForm = false;
      this.playstationForm = false;
      this.pcForm = false;
      this.xboxForm = false;
    }
  }

  addNintendoForm(){
    this.nintendoForm = true;
  }
  addPlaystationForm(){
    this.playstationForm = true;
  }
  addPCForm(){
    this.pcForm = true;
  }
  addXBoxForm(){
    this.xboxForm = true;
  }

}
