package com.jcg.jsonParser;

public class Job {

    private String site;

    public String getSite() {
        return site;
    }

    @Override
    public String toString() {
        return "Job{" +
                "site='" + site + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

}
