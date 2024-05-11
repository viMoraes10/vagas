package com.example.demo.repository;

import com.example.demo.model.Job.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository  extends JpaRepository<Job, Long> {

}
