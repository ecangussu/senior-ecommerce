import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../model/Product';
import { Order } from '../model/Order';
import { OrderProduct } from '../model/OrderProduct';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  //PRODUTO

  private urlProduct:string = 'http://localhost:8080/products';
  private urlOrder:string = 'http://localhost:8080/orders';
  private urlOrderProduct:string = 'http://localhost:8080/order-product'

  constructor(private http:HttpClient) { }

  getProduct():Observable<Product[]>{
    return this.http.get<Product[]>(this.urlProduct);
  }

  insertProduct(obj:Product):Observable<Product>{
    return this.http.post<Product>(this.urlProduct, obj);
  }

  updateProduct(obj:Product):Observable<Product>{
    return this.http.put<Product>(this.urlProduct + '/' + obj.id, obj);
  }

  deleteProduct(id:number):Observable<void>{
    return this.http.delete<void>(this.urlProduct + '/' + id);
  }

  //PEDIDO

  getOrder():Observable<Order[]>{
    return this.http.get<Order[]>(this.urlOrder);
  }

  //PRODUTOS PEDIDO

  getOrderProduct():Observable<OrderProduct[]>{
    return this.http.get<OrderProduct[]>(this.urlOrderProduct);
  }

}
