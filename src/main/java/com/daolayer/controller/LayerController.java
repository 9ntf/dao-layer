package com.daolayer.controller;

import com.daolayer.service.LayerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LayerController {
    private final LayerService service;

    public LayerController(LayerService service) {
        this.service = service;
    }

    @GetMapping("/products/fetch-product")
    public String getFetchProduct(@RequestParam("name") String name) {
    return service.getFetchProduct(name);
    }
}
