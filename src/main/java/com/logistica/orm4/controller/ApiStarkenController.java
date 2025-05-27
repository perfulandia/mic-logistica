package com.logistica.orm4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.logistica.orm4.model.ApiStarken;
import com.logistica.orm4.service.ApiStarkenService;

@RestController
@RequestMapping("/api/starkenApi")
public class ApiStarkenController {

    @Autowired
    private ApiStarkenService apiStarkenService;

    @GetMapping
    public ResponseEntity<List<ApiStarken>> getApi() { 
        List<ApiStarken> apis = apiStarkenService.findAll();

        if (!apis.isEmpty()) {
            return new ResponseEntity<>(apis, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<ApiStarken> crearEnvios(@RequestBody ApiStarken apis) {

        if (apis != null && !apiStarkenService.existsByApiKey(apis.getApiKey())) {

            return new ResponseEntity<>(apiStarkenService.save(apis), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
}
