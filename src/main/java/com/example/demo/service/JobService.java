package com.example.demo.service;

import com.example.demo.dto.JobDTO;
import com.example.demo.model.job.Job;
import com.example.demo.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    JobRepository jobRepository;

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }


    public Job created(JobDTO jobDTO) {
        Job job = new Job(jobDTO.title(), jobDTO.description(), jobDTO.requirements(), true);
        jobRepository.save(job);
        return job;
    }

    public Job update(JobDTO jobDTO) {
        Job jobOld = jobRepository.findById(jobDTO.id()).get();
        Job jobNew = new Job(jobDTO.id(), jobDTO.title(), jobDTO.description(), jobDTO.requirements(), true);
//        jobRepository.save(job);
        return jobNew;
    }

}




