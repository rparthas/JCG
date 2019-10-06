package com.jcg.jsonParser;

import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String id;
    private String firstname;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    private List<Language> languages;
    private Job job;

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", languages=" + languages.stream().map(language -> language.toString()).collect(Collectors.toList()) +
                ", job=" + job +
                '}';
    }
}
