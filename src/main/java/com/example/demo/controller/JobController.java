package com.example.demo.controller;

import com.example.demo.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "job")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping(value = "/all")
    public ResponseEntity getAllJobs (){

        jobService.getAllJobs();


        return ResponseEntity.ok().build();
    }


}
