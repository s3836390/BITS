package com.company;

public class Course {
    String id,name,numberOfCredit;
    Course(String id,String name,String numberOfCredit){
        this.id=id;
        this.name=name;
        this.numberOfCredit=numberOfCredit;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberOfCredit() {
        return numberOfCredit;
    }

    public void setNumberOfCredit(String numberOfCredit) {
        this.numberOfCredit = numberOfCredit;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", numberOfCredit='" + numberOfCredit + '\'' +
                '}';
    }
}
