import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../model/User';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  baseurl = "https://thin-death-production.up.railway.app//user"
  constructor(private http:HttpClient) { }

  getAllUser(): Observable<User[]>{
      return this.http.get<User[]>(this.baseurl)
  }
  createUser(user:User):Observable<User>{
    return this.http.post<User>(this.baseurl,user)
  }
}
