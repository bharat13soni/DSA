package com.practice;

public class Employee {

    private final Integer id;
    private final String name;

    public Employee(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int hashCode() {
        int res = 13;
        int prime = 51;
        res = res * prime + ((this.id != null) ? this.id.hashCode() : 0);
//        if (this.name != null)
//            res = res * prime + this.name.hashCode();
        return res;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Employee))
            return false;
        Employee other = (Employee) obj;
        if (this.id == null) {
            return other.id == null;
        } else return this.id.equals(other.id);
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

}
