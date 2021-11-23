package com.anxistars.flux.webfluxdemo.controller;

import java.util.Arrays;
import java.util.List;

import com.anxistars.flux.webfluxdemo.dto.Response;
import com.anxistars.flux.webfluxdemo.service.MathService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("math")
public class MathController {

    @Autowired
    private MathService mathService;

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name) {
        return "Hello : " + name;
    }

    @GetMapping(value = "/square/{input}")
    public Response findSquare(@PathVariable int input) {
        return mathService.findSquare(input);
    }

    @GetMapping("table/{input}")
    public List<Response> findMultiplicationTable(@PathVariable int input) {
        return mathService.multiplicationTable(input);
    }

}
