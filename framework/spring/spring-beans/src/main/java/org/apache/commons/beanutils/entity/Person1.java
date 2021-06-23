package org.apache.commons.beanutils.entity;

public class Person1 {
    private int age;

    private String name;

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

    @Override
    public String toString() {
        return "Person1 [age=" + age + ", name=" + name + "]";
    }

}
