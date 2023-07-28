package com.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeByDept {
    public static void main(String[] args) {
        Employee e1= new Employee(1, "bharat", "soni", "DEV");
        Employee e2= new Employee(2, "ram", "soni", "Account");
        Employee e3= new Employee(3, "ravi", "soni", "QA");
        Employee e4= new Employee(4, "raj", "soni", "DEV");
        Employee e5= new Employee(5, "ramesh", "soni", "DEV");
        Employee e6= new Employee(6, "ajay", "soni", "QA");

        List<Employee> employeeList=new ArrayList<>();
        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        employeeList.add(e4);
        employeeList.add(e5);
        employeeList.add(e6);

        Map<String, List<Employee>> map = employeeList.stream().collect(Collectors.groupingBy(Employee::getDept));
        System.out.println(map);
    }
    static class Employee{
        private long empId;
        private String fName;
        private String lName;
        private String dept;

        public Employee() {
        }

        public Employee(long empId, String fName, String lName, String dept) {
            this.empId = empId;
            this.fName = fName;
            this.lName = lName;
            this.dept = dept;
        }

        public long getEmpId() {
            return empId;
        }

        public void setEmpId(long empId) {
            this.empId = empId;
        }

        public String getfName() {
            return fName;
        }

        public void setfName(String fName) {
            this.fName = fName;
        }

        public String getlName() {
            return lName;
        }

        public void setlName(String lName) {
            this.lName = lName;
        }

        public String getDept() {
            return dept;
        }

        public void setDept(String dept) {
            this.dept = dept;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "empId=" + empId +
                    ", fName='" + fName + '\'' +
                    ", lName='" + lName + '\'' +
                    ", dept='" + dept + '\'' +
                    '}';
        }
    }
}
