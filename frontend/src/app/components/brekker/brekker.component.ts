import { Component, OnInit } from '@angular/core';
import { Food } from 'src/app/shared/model/Food';
import { User } from 'src/app/shared/model/User';
import { UserFood } from 'src/app/shared/model/UserFood';
import { BrekkerService } from 'src/app/shared/services/brekker.service';
import { FoodsService } from 'src/app/shared/services/food.service';
import { UserService } from 'src/app/shared/services/user.service';
import { ActivatedRoute } from '@angular/router';
import { CreateUserFood } from 'src/app/shared/model/CreateUserFood';
import { Brekker } from 'src/app/shared/model/Brekker';
import { ErrorAlertService } from '../error-alert/error-alert.service';


@Component({
  selector: 'app-brekker',
  templateUrl: './brekker.component.html',
  styleUrls: ['./brekker.component.css']
})
export class BrekkerComponent implements OnInit {
  
  visibleItem:boolean = false;
  visibleRegister:boolean = false;

  allUsers: User[] = []
  user:User = {nome:"",cpf:""}
  newParticipant: CreateUserFood = {
    userId: 0,
    foodId: 0
  };
  selectUser= 'Selecionar'

  allFoods: Food[] = []
  selectFood = 'Alimento'
  breakfastId: number;
  brekker: Brekker;

  public mask = [/[0-9]/, /[0-9]/, /[0-9]/,'.', /[0-9]/, /[0-9]/, /[0-9]/, '.', /[0-9]/, /[0-9]/, /[0-9]/,'-', /[0-9]/,/[0-9]/];
  constructor(
    private userService: UserService,
    private foodService: FoodsService,
    private brekkerService: BrekkerService,
    private route: ActivatedRoute,
    private errorAlert: ErrorAlertService
  ){ }

  ngOnInit(): void {
   this.breakfastId = Number(this.route.snapshot.paramMap.get('id'));
   this.getBrekker();
   this.listUsers()
   this.listFoods()
  }

  toggleMenu(){
    this.visibleItem = !this.visibleItem
    this.visibleRegister = false
  }
  newRegister(){
    this.visibleItem = false
    this.visibleRegister = !this.visibleRegister
  }

  getBrekker() {
    this.brekkerService.getBrekkerById(this.breakfastId).subscribe(
      brekker => this.brekker = brekker
    );
  }

  listUsers(){
    this.userService.getAllUser().subscribe(
      (response)=>{
        this.allUsers = response
    })
  }

  listFoods(){
    this.foodService.getAllFoods(this.breakfastId).subscribe(
      (reponse)=>{
        this.allFoods = reponse
      }
    )
  }

  postUser(){
    this.user.cpf = this.user.cpf.replaceAll('.', '').replace('-', '');
    this.userService.createUser(this.user).subscribe(
      ()=>{
        this.listUsers()
        this.visibleRegister = false;
          this.user.nome=""
          this.user.cpf=""
      },
      (error) => {
        this.errorAlert.setErrorMessage(error.error);
      })
  }

  newItem(){
    this.brekkerService.insertParticipant(this.breakfastId, this.newParticipant).subscribe(
      () => {
        this.getBrekker()
        this.listFoods();
        this.selectUser="Selecionar"
        this.selectFood="Alimento"
        this.visibleItem=false;
      },
      (error) => {
        this.errorAlert.setErrorMessage(error.error);
      }
    );
  }


  selectedUser(user: User){
    this.selectUser=user.nome;
    this.newParticipant.userId = Number(user.id);
  }

  selectedFood(food: Food){
    this.selectFood = food.nome;
    this.newParticipant.foodId = Number(food.id);
  }
}

// private Long userId;
// private Long foodId;
