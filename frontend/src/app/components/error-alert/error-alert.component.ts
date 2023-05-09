import { Component, OnInit } from '@angular/core';
import { ErrorAlertService } from './error-alert.service';

@Component({
  selector: 'app-error-alert',
  templateUrl: './error-alert.component.html',
  styleUrls: ['./error-alert.component.css']
})
export class ErrorAlertComponent implements OnInit {

    errorMessage: string = '';
    isMessageVisible: boolean = false;

    constructor(private errorAlertService: ErrorAlertService) { }

    ngOnInit(): void {
        this.errorAlertService.getObservable().subscribe(
            (errorMessage: string) => {
                this.errorMessage = errorMessage;
                this.showMessage();
            }
        )
    }

    showMessage(): void {
        this.isMessageVisible = true;
        setTimeout(
            () => {
                this.isMessageVisible = false;
            }, 3000
        );
    }

}