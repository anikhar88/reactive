package com.anxistars.flux.webfluxdemo.controller;

import com.anxistars.flux.webfluxdemo.dto.Response;
import com.anxistars.flux.webfluxdemo.service.CalculatorService;
import com.anxistars.flux.webfluxdemo.service.MathService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
//@RequestMapping("reactive/math")
public class ReactiveCalculatorController {

    @Autowired
    private CalculatorService calculatorService;


}
