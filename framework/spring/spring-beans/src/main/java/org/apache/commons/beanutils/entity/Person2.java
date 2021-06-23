package org.apache.commons.beanutils.entity;

import java.time.LocalDate;

public class Person2 {
    private int age;

    private String name;

    private LocalDate birthday;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Person2 [age=" + age + ", name=" + name + ", birthday=" + birthday + "]";
    }

}
