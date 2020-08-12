package com.example.formulatrix.models;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.Objects;

@XmlRootElement
public class Register {

    
    private String firstname;
    
    private String lastname;
    
    private String email;
    
    private String password;
    
    private String phoneNumber;
    
    private String address;


    public Register() {
    }

    public Register(String firstname, String lastname, String email, String password, String phoneNumber, String address) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    @XmlElement
    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @XmlElement
    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @XmlElement
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlElement
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlElement
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @XmlElement
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Register firstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public Register lastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public Register email(String email) {
        this.email = email;
        return this;
    }

    public Register password(String password) {
        this.password = password;
        return this;
    }

    public Register phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Register address(String address) {
        this.address = address;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Register)) {
            return false;
        }
        Register register = (Register) o;
        return Objects.equals(firstname, register.firstname) && Objects.equals(lastname, register.lastname) && Objects.equals(email, register.email) && Objects.equals(password, register.password) && Objects.equals(phoneNumber, register.phoneNumber) && Objects.equals(address, register.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, email, password, phoneNumber, address);
    }

    @Override
    public String toString() {
        return "{" +
            " firstname='" + getFirstname() + "'" +
            ", lastname='" + getLastname() + "'" +
            ", email='" + getEmail() + "'" +
            ", password='" + getPassword() + "'" +
            ", phoneNumber='" + getPhoneNumber() + "'" +
            ", address='" + getAddress() + "'" +
            "}";
    }


}