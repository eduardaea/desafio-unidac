import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Food } from '../model/Food';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FoodsService{

  baseurl = "https://thin-death-production.up.railway.app/food"
  constructor(private http:HttpClient) { }

  getAllFoods(id: number): Observable<Food[]>{
    return this.http.get<Food[]>(`${this.baseurl}/${id}`)
  }
}
