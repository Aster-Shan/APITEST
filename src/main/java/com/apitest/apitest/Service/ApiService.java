package com.apitest.apitest.Service;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.apitest.apitest.Model.ApiModel;

@Service
public class ApiService {
    private final RestTemplate restTemplate;
    private static final String API_URL = "https://jsonplaceholder.typicode.com/posts/1";

    public ApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<?> fetchPost() {
        try {
            ApiModel apiModel = restTemplate.getForObject(API_URL, ApiModel.class);
            
            if (apiModel != null) {
                return ResponseEntity.ok(apiModel);
            } else {
                Map<String, String> errorResponse = new HashMap<>();
                errorResponse.put("error", "Data not found");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
            }
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Data not found");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }
}