/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class Employee {
    private int id;
    private String fullName;
    private String avatar;
    private Date birthday;
    private String gender;
    private String idCard;
    private String religion;
    private String ethicMinority;
    private String department;
    private String position;
    private float salary;
    private String email;
    private String address;
    private String phone;
    private String permission;

    public Employee(int id, String department) {
        this.id = id;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getEthicMinority() {
        return ethicMinority;
    }

    public void setEthicMinority(String ethicMinority) {
        this.ethicMinority = ethicMinority;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Employee(int id, String fullName, String avatar, Date birthday, String gender, String idCard, String religion, String ethicMinority, String department, String position, float salary, String email, String address, String phone, String permission) {
        this.id = id;
        this.fullName = fullName;
        this.avatar = avatar;
        this.birthday = birthday;
        this.gender = gender;
        this.idCard = idCard;
        this.religion = religion;
        this.ethicMinority = ethicMinority;
        this.department = department;
        this.position = position;
        this.salary = salary;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.permission = permission;
    }

    @Override
    public String toString() {
        return this.department;
    }
    
}
