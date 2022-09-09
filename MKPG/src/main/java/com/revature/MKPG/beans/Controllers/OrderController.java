package com.revature.MKPG.beans.Controllers;

import com.revature.MKPG.beans.Services.OrderService;
import com.revature.MKPG.entities.Order;
import com.revature.MKPG.exceptions.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {
    private OrderService service;

    @Autowired
    public OrderController(OrderService orderService) {
        this.service = orderService;
    }

    @GetMapping( "/{orderId}")
    @ResponseStatus(value = HttpStatus.OK)
    public Order getOrderById(@PathVariable Integer orderId) {
        Optional<Order> optionalOrder = service.getOrderById(orderId);

        Order order = null;

        if(optionalOrder.isPresent()) {
            order = optionalOrder.get();
        }else {
            throw new CustomerNotFoundException( "Order id " + orderId + " not found");
        }

        return order;
    }

    @GetMapping()
    @ResponseStatus(value = HttpStatus.OK)
    public List<Order> getAllOrders() {
        return service.getAllOrder();
    }

    @PostMapping()
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public Order createOrder(@Valid @RequestBody Order order) {
        service.createOrder(order);
        return order;
    }

    @PutMapping()
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public Order updateOrder(@RequestBody Order order) {
        service.updateOrder(order);
        return order;
    }

    @DeleteMapping("/{orderId}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteOrder(@PathVariable(name = "orderId") Integer id) {
        service.deleteById(id);
    }
}
