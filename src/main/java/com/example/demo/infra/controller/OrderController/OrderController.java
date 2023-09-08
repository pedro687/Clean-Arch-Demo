package com.example.demo.infra.controller.OrderController;

import com.example.demo.application.usecases.CreateOrderUseCase;
import com.example.demo.application.usecases.GetOrdersByUserUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final CreateOrderUseCase createOrderUseCase;
    private final GetOrdersByUserUseCase getOrdersByUserUseCase;

    public OrderController(CreateOrderUseCase createOrderUseCase, GetOrdersByUserUseCase getOrdersByUserUseCase) {
        this.createOrderUseCase = createOrderUseCase;
        this.getOrdersByUserUseCase = getOrdersByUserUseCase;
    }

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody OrderCreateInputRequest orderCreateInputRequest) {

        try {
            var response = createOrderUseCase.execute(orderCreateInputRequest);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @GetMapping(value = "/{username}")
    public ResponseEntity<?> getOrdersByUser(@PathVariable String username) {
        try {
            System.out.println(username);
            var response = getOrdersByUserUseCase.execute(username);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
