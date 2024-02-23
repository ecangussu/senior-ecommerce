import { Order } from "./Order";
import { Product } from "./Product";

export class OrderProduct {

    order:Order = new Order();
    product:Product = new Product();
    price:number = 0;
    subTotal:number = 0;
    quantity:number = 0;
    
}