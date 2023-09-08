package com.example.demo.infra.controller.UserController;

import com.example.demo.application.usecases.CreateUserUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class CreateUserController {
    private final CreateUserUseCase createUserUseCase;

    public CreateUserController(CreateUserUseCase createUserUseCase) {
        this.createUserUseCase = createUserUseCase;
    }

    @PostMapping
    public ResponseEntity<?> create(
            @RequestBody CreateUserRequest createUserRequest
    ) {
        try {
            createUserUseCase.execute(createUserRequest);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
