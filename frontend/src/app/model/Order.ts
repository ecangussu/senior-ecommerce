import { OrderProduct } from "./OrderProduct";

export class Order {

    id:number = 0;
    number:number = 0;
    customerName:string = '';
    total:number = 0;
    date:Date = new Date();
    orderProducts:OrderProduct[] = [];

}