import { Component, Input, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Item} from "../../models/item.model";
import { ItemService } from '../../services/item.service';

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css']
})
export class ItemComponent implements OnInit {

  items: Item[] =[];
  nintendoForm: boolean = false;
  playstationForm: boolean = false;
  pcForm: boolean = false;
  xboxForm: boolean = false;

  form = new FormGroup({
    itemName: new FormControl('', [Validators.required]),
    description: new FormControl('', [Validators.required]),
    price: new FormControl('', [Validators.required]),
    discountedPrice: new FormControl(''),
    rating: new FormControl('', [Validators.required]),
    itemImage: new FormControl('', [Validators.required]),
  })

  constructor(private itemService: ItemService,) {

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
    save(){

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
