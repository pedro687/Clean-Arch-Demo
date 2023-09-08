package com.example.demo.application.usecases;

import com.fasterxml.jackson.core.JsonProcessingException;

public abstract class UseCase<INPUT, OUTPUT> {
    public abstract OUTPUT execute(INPUT anInput) throws JsonProcessingException;
}
