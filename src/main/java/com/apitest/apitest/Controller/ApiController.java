package com.apitest.apitest.Controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apitest.apitest.Service.ApiService;

@RestController
@RequestMapping("/api")

public class ApiController {
    private final ApiService apiservice;
    
    public ApiController (ApiService apiservice){
        this.apiservice = apiservice;
    }

    @GetMapping("/post")
    public ResponseEntity <?> getPost(){
        return apiservice.fetchPost();
    }
   
}
