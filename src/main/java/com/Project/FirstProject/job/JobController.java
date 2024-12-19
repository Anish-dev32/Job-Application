package com.Project.FirstProject.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {
    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<Job>> findAll(){
        return ResponseEntity.ok(jobService.findAll());
    }

    @GetMapping("/{Id}")
    public ResponseEntity<Job> findJobById(@PathVariable Long Id){
        Job job = jobService.findJobById(Id);
        if(job != null)
            return new ResponseEntity<>(job, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>("Job added!", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id){
        boolean deleted = jobService.deleteJobById(id);
        if(deleted) return new ResponseEntity<>("Job Deleted!", HttpStatus.OK);
        return new ResponseEntity<>("Job Not Found!", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> UpdateJobById(@PathVariable Long id, @RequestBody Job job){
        boolean updated = jobService.UpdateJobById(id, job);
        if(updated) return new ResponseEntity<>("Job Updated!", HttpStatus.OK);
        return new ResponseEntity<>("Job Not Found!", HttpStatus.NOT_FOUND);
    }
}
