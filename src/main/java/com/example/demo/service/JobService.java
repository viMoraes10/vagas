package com.example.demo.service;

import com.example.demo.model.Job.Job;
import com.example.demo.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    JobRepository jobRepository;

    public List<Job> getAllJobs() {

        List<Job> jobs = jobRepository.findAll();

        return jobs;
    }
}
