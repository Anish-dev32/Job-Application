package com.Project.FirstProject.job;

import java.util.List;

public interface JobService {
    List<Job> findAll();

    void createJob(Job job);

    Job findJobById(Long id);

    boolean deleteJobById(Long id);

    boolean UpdateJobById(Long id, Job job);
}
