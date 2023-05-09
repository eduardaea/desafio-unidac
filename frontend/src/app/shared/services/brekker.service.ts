import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Brekker } from '../model/Brekker';
import { Observable } from 'rxjs';
import { CreateUserFood } from '../model/CreateUserFood';

@Injectable({
  providedIn: 'root'
})
export class BrekkerService {
  
  baseurl = "https://thin-death-production.up.railway.app/breakfast"
  constructor(private http:HttpClient) { }

  getAllBrekker():Observable<Brekker[]>{
     return this.http.get<Brekker[]>(this.baseurl);
  }
  getBrekkerById(id: number):Observable<Brekker> {
    return this.http.get<Brekker>(`${this.baseurl}/${id}`);
  } 
  postBrekker(brekker: Brekker):Observable<Brekker>{
    return this.http.post<Brekker>(this.baseurl,brekker);
  }
  deleteBrekker(id:number):Observable<Brekker>{
    return this.http.delete<Brekker>(`${this.baseurl}/${id}`);
  }
  updateBrekker(id:number, brekker:Brekker):Observable<Brekker>{
    return this.http.put<Brekker>(`${this.baseurl}/${id}`,brekker);
  }
  insertParticipant(id:number, userFood:CreateUserFood){
    return this.http.post<Brekker>(`${this.baseurl}/usuario-comida/${id}`,userFood);
  }
}
