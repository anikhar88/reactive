package com.anxistars.flux.webfluxdemo.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.anxistars.flux.webfluxdemo.dto.Response;

import org.springframework.stereotype.Service;

@Service
public class MathService {

    public Response findSquare(int input) {
        return new Response(input * input);
    }

    public List<Response> multiplicationTable(int input) {
        return IntStream.rangeClosed(1, 10)
        .peek(i -> SleepUtlity.sleep(1))
        .peek(i -> System.out.println("Math-Service processing : " + i))
        .mapToObj(i -> new Response(i*input))
        .collect(Collectors.toList());
   }

    
}
