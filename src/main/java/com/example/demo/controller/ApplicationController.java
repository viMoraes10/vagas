package com.example.demo.controller;

import com.example.demo.dto.ApplicationDTO;
import com.example.demo.dto.JobDTO;
import com.example.demo.service.ApplicationService;
import com.example.demo.service.JobService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value ="application")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @GetMapping(value = "/{userId}/all")
    public ResponseEntity<?> getAllWithUserId(@PathVariable Long userId){
        try{
            return ResponseEntity.ok(applicationService.getAllWithUserId(userId));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Request failed: " + e.getMessage());
        }
    }

    @GetMapping(value = "/{jobId}/all")
    public ResponseEntity<?> getAllWithJobId(@PathVariable Long jobId){
        try{
            return applicationService.getAllWithJobId(jobId);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Request failed: " + e.getMessage());
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> get(){
        try{
            return ResponseEntity.ok(applicationService.getAll());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Request failed: " + e.getMessage());
        }
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> post(@RequestBody @Valid ApplicationDTO applicationDTO){
        try{
            return applicationService.created(applicationDTO);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Request failed: " + e.getMessage());
        }
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> updateStatus(@PathVariable Long id,
                                          @RequestBody @Valid String newStatus){
        try{
            return ResponseEntity.ok(applicationService.putStatus(id, newStatus));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Request failed: " + e.getMessage());
        }
    }

}
