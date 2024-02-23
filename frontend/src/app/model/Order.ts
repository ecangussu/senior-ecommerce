import { OrderProduct } from "./OrderProduct";

export class Order {

    id:number = 0;
    number:number = 0;
    customerName:string = '';
    orderProducts:OrderProduct[] = [];
    finalValue:number = 0;
    date:Date = new Date();

}