package com.example.thilaiwcd.entity;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Employee {
    private int id;
    private String fullName;
    private String birthday;
    private String address;
    private String position;
    private String department;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", birthday='" + birthday + '\'' +
                ", address='" + address + '\'' +
                ", position='" + position + '\'' +
                ", department='" + department + '\'' +
                '}';
    }

    public Employee() {
        this.fullName = "";
        this.birthday = "";
        this.address = "";
        this.position = "";
        this.department = "";
    }

    public Employee(int id, String fullName, String birthday, String address, String position, String department) {
        this.id = id;
        this.fullName = fullName;
        this.birthday = birthday;
        this.address = address;
        this.position = position;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    private HashMap<String, String> errors = new HashMap<>();

    public boolean isValid() {
        checkValid();
        return errors.size() == 0;
    }

    private void checkValid() {
        if (fullName == null || fullName.length() == 0) {
            errors.put("fullName", "Enter fullname");
        }
        if (birthday == null || birthday.length() == 0) {
            errors.put("birthday", "Enter birthday.");
        }
        if (address == null || address.length() == 0) {
            errors.put("address", "Enter address.");
        }
        if (position == null || position.length() == 0) {
            errors.put("position", "Enter position.");
        }
        if (department == null || department.length() == 0) {
            errors.put("department", "Enter department.");
        }
    }

    public HashMap<String, String> getErrors() {
        return errors;
    }

    public void setErrors(HashMap<String, String> errors) {
        this.errors = errors;
    }
    public static final class EmployeeBuilder {
        private int id;
        private String fullName;
        private String birthday;
        private String address;
        private String position;
        private String department;
        private HashMap<String, String> errors = new HashMap<>();

        private EmployeeBuilder() {
        }

        public static EmployeeBuilder aEmployee() {
            return new EmployeeBuilder();
        }

        public EmployeeBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public EmployeeBuilder withFullName(String fullName) {
            this.fullName = fullName;
            return this;
        }
        public EmployeeBuilder withBirthday(String birthday) {
            this.birthday = birthday;
            return this;
        }
        public EmployeeBuilder withAddress(String address) {
            this.address = address;
            return this;
        }
        public EmployeeBuilder withPosition(String position) {
            this.position = position;
            return this;
        }
        public EmployeeBuilder withDepartment(String department) {
            this.department = department;
            return this;
        }

        public Employee build() {
            Employee employee = new Employee();
            employee.setId(id);
            employee.setFullName(fullName);
            employee.setBirthday(birthday);
            employee.setAddress(address);
            employee.setPosition(position);
            employee.setDepartment(department);
            employee.setErrors(errors);
            return employee;
        }
    }

}