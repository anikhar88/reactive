package com.anxistars.flux.webfluxdemo.controller;

import com.anxistars.flux.webfluxdemo.dto.Response;
import com.anxistars.flux.webfluxdemo.service.MathService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("reactive/math")
public class ReactiveMathController {

    @Autowired
    private MathService mathService;

  /*  @GetMapping("/square/{input}")
    public Mono<Response> findSquare(@PathVariable int input) {
        return Mono.just(mathService.findSquare(input))
                ;
    } */

}
