package com.Project.FirstProject.company;

import com.Project.FirstProject.job.Job;
import com.Project.FirstProject.review.Review;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;


    @OneToMany(mappedBy = "company")
    private List<Job> Jobs;

    @OneToMany(mappedBy = "company")
    private List<Review> Reviews;

    public List<Review> getReviews() {
        return Reviews;
    }

    public void setReviews(List<Review> reviews) {
        Reviews = reviews;
    }

    public void setJobs(List<Job> jobs) {
        Jobs = jobs;
    }

    public List<Job> getJobs() {
        return Jobs;
    }

    public Company(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Company() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Company(Long id, String name, String description, List<Job> jobs) {
        this.id = id;
        this.name = name;
        this.description = description;
        Jobs = jobs;
    }
}
