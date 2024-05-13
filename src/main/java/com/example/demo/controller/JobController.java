package com.example.demo.controller;

import com.example.demo.dto.JobDTO;
import com.example.demo.model.Jobs;
import com.example.demo.service.JobService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "job")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping(value = "/all")
    public ResponseEntity<?> getAllJobs (){
        try{
            return ResponseEntity.ok(jobService.getAllJobs());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Request failed: " + e.getMessage());
        }
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> postJob(@RequestBody @Valid JobDTO JobDTO){
        try{
            return ResponseEntity.ok(jobService.created(JobDTO));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Request failed: " + e.getMessage());
        }
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody @Valid JobDTO JobDTO){
        try{
            var jobs = jobService.update(id, JobDTO);
            if (jobs == null) return ResponseEntity.badRequest().body("Id not found");

            return ResponseEntity.ok(jobs);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Request failed: " + e.getMessage());
        }
    }
}
