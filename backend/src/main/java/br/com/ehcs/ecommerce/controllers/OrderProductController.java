package br.com.ehcs.ecommerce.controllers;

import br.com.ehcs.ecommerce.entities.OrderProduct;
import br.com.ehcs.ecommerce.services.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Controller
@RequestMapping(value = "/order-product")
@CrossOrigin(origins = "*")
public class OrderProductController {

    @Autowired
    private OrderProductService orderProductService;

    @PostMapping
    public ResponseEntity<OrderProduct> insert(@RequestBody OrderProduct orderProduct) {
        orderProduct = orderProductService.insert(orderProduct);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(orderProduct.getId()).toUri();
        return ResponseEntity.created(uri).body(orderProduct);
    }

}
