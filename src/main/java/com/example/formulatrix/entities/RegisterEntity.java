package com.example.formulatrix.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;

import java.util.Objects;

@Table(name = "register")
@Entity
public class RegisterEntity {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "firstname", length = 50, nullable = false)
    private String firstname;

    @Column(name = "lastname", length = 50, nullable = false)
    private String lastname;

    @Column(name = "email", length = 50, nullable = false)
    private String email;
  
    @Column(name = "password", length = 255, nullable = false)
    private String password;
   
    @Column(name = "phone_number", length = 21)
    private String phoneNumber;
  
    @Column(name = "address", length = 255)
    private String address;

    
    @OneToOne(mappedBy = "itemContent", cascade = CascadeType.ALL)
    private ContentEntity content;


    public RegisterEntity() {
    }

    public RegisterEntity(String firstname, String lastname, String email, String password, String phoneNumber, String address, ContentEntity content) {
  
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.content = content;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ContentEntity getContent() {
        return this.content;
    }

    public void setContent(ContentEntity content) {
        this.content = content;
    }

    public RegisterEntity id(Integer id) {
        this.id = id;
        return this;
    }

    public RegisterEntity firstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public RegisterEntity lastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public RegisterEntity email(String email) {
        this.email = email;
        return this;
    }

    public RegisterEntity password(String password) {
        this.password = password;
        return this;
    }

    public RegisterEntity phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public RegisterEntity address(String address) {
        this.address = address;
        return this;
    }

    public RegisterEntity content(ContentEntity content) {
        this.content = content;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof RegisterEntity)) {
            return false;
        }
        RegisterEntity registerEntity = (RegisterEntity) o;
        return Objects.equals(id, registerEntity.id) && Objects.equals(firstname, registerEntity.firstname) && Objects.equals(lastname, registerEntity.lastname) && Objects.equals(email, registerEntity.email) && Objects.equals(password, registerEntity.password) && Objects.equals(phoneNumber, registerEntity.phoneNumber) && Objects.equals(address, registerEntity.address) && Objects.equals(content, registerEntity.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, email, password, phoneNumber, address, content);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", firstname='" + getFirstname() + "'" +
            ", lastname='" + getLastname() + "'" +
            ", email='" + getEmail() + "'" +
            ", password='" + getPassword() + "'" +
            ", phoneNumber='" + getPhoneNumber() + "'" +
            ", address='" + getAddress() + "'" +
            "}";
    }
    
}