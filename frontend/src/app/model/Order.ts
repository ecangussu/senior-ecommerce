import { OrderProduct } from "./OrderProduct";

export class Order {

    id:number = 0;
    number:string = '';
    customerName:string = '';
    cpf:string = '';
    email:string = '';
    total:number = 0;
    date:Date = new Date();
    orderProducts:OrderProduct[] = [];

}