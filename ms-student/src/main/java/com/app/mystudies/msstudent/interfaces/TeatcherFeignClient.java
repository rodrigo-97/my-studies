package com.app.mystudies.msstudent.interfaces;

import java.util.List;

import com.app.mystudies.msstudent.models.Teatcher;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(value = "ms-teatcher", url = "http://localhost:8081/api/v1", path = "/teatchers")
public interface TeatcherFeignClient {
    
    @GetMapping
    public ResponseEntity<List<Teatcher>> getAll();
}
