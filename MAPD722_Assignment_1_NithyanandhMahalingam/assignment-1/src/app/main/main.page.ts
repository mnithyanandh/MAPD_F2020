import { Component, OnInit, NgModule } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-main',
  templateUrl: './main.page.html',
  styleUrls: ['./main.page.scss'],
})
export class MainPage implements OnInit {
  public main: string;
  public calculate_title = 'Calculate Your Pay:';
  public PayRate: number = 0;
  public RPay: number = 0;
  public OTPay: number = 0;
  public TPay: number = 0;
  public Tax = '0.000';
  public Hours: number = 0;

  constructor(private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    this.main = this.activatedRoute.snapshot.paramMap.get('id');
  }

  calculate() {
    var reg_pay: number = 0;
    var overtime_pay: number = 0;
    var total_pay: number = 0;
    var tax: number = 0.0;

    if(this.Hours <= 40)
    {
      reg_pay = this.Hours * this.PayRate;
      total_pay = this.Hours * this.PayRate;
    }
    else
    {
      reg_pay = this.PayRate * 40;
      overtime_pay = (this.Hours - 40) * (this.PayRate * 1.5);
    }

    total_pay = reg_pay + overtime_pay;
    tax = (total_pay * 0.18);

    this.RPay = reg_pay;
    this.OTPay = overtime_pay;
    this.TPay = total_pay;
    this.Tax = tax.toFixed(3);

  }

  reset(){
    this.PayRate = 0;
    this.Hours = 0;
    this.RPay = 0;
    this.OTPay = 0;
    this.TPay = 0;
    this.Tax = '0.000';
  }

}
