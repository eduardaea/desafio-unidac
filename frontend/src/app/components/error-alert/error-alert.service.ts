import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ErrorAlertService {
    subject: Subject<string> = new Subject<string>();

    getObservable(): Observable<string> {
        return this.subject.asObservable();
    }

    setErrorMessage(errorMessage: string): void {
        this.subject.next(errorMessage);
    }
}