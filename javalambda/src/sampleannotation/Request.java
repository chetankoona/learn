package sampleannotation;

import java.util.Date;

public class Request implements BaseTable {
    @Column(name = "name",nullable = true)
    private String name;
    @Column(name = "age", defaultValue = "0")
    private Integer age;
    @Column(name = "dob", defaultValue = "0000-00-00")
    private Date dob;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Request(String name, Integer age, Date dob) {
        this.name = name;
        this.age = age;
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Request{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", dob=" + dob +
                '}';
    }

    public Request() {
    }
}
