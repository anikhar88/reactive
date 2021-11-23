package com.anxistars.flux.webfluxdemo.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.anxistars.flux.webfluxdemo.dto.Response;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public Response findSquare(int input) {
        return new Response(input * input);
    }

    
}
