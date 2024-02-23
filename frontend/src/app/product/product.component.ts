import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Product } from '../model/Product';
import { ProductService } from '../service/product.service';
import { Order } from '../model/Order';

@Component({
  selector: 'app-product',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './product.component.html',
  styleUrl: './product.component.css'
})
export class ProductComponent {

  //VISUALIZAÇÃO DE PÁGINAS

  MainsPage:boolean = true;
  ProductsPage:boolean = false;
  OrdersPage:boolean = false;
  ReportsPage:boolean = false;

  showMainPage(){
    this.MainsPage = true;
    this.ProductsPage = false;
    this.OrdersPage = false;  
    this.ReportsPage = false;  
  }

  showProductPage(){
    this.ProductsPage = true;
    this.OrdersPage = false;
    this.MainsPage = false;
    this.ReportsPage = false;  
  }

  showOrderPage(){
    this.OrdersPage = true;
    this.ProductsPage = false;
    this.MainsPage = false;
    this.ReportsPage = false;  
  }

  showReportPage(){
    this.ReportsPage = true;  
    this.OrdersPage = false;
    this.ProductsPage = false;
    this.MainsPage = false;
  }

  //PRODUTO

  product = new Product();

  btnRegister:boolean = true;

  table:boolean = true;

  products:Product[] = [];

  constructor(private service:ProductService){}

  getAllProducts():void{
    this.service.getProduct().subscribe(retorno => this.products = retorno);
  }

  insertProduct():void{
    this.service.insertProduct(this.product).subscribe(retorno => {
      this.products.push(retorno);
      this.product = new Product();
      alert('Produto cadastrado com sucesso!')
    });
  }

  getProduct(position:number):void{
    this.product = this.products[position];
    this.btnRegister = false;
    this.table = false;
  }

  updateProduct():void{
    this.service.updateProduct(this.product).subscribe(retorno => {
      let position = this.products.findIndex(obj => {
        return obj.id == retorno.id
      });
      this.products[position] = retorno;
      this.product = new Product();
      this.btnRegister = true;
      this.table = true;
      alert('Dados do produto atualizados com sucesso!')
    });
  }

  deleteProduct():void{
    this.service.deleteProduct(this.product.id).subscribe(retorno => {
      let position = this.products.findIndex(obj => {
        return obj.id == this.product.id
      });
      this.products.splice(position, 1);
      this.product = new Product();
      this.btnRegister = true;
      this.table = true;
      alert('Produto deletado com sucesso!')
    });
  }

  cancelProduct():void{
    this.product = new Product();
    this.btnRegister = true;
    this.table = true;
  }

  ngOnInit(){
    this.getAllProducts();
  }

  //PEDIDO

  order = new Order();

  orders:Order[] = [];

  getAllOrders():void{
    this.service.getOrder().subscribe(retorno => this.orders = retorno);
  }

  //aaaa

}
