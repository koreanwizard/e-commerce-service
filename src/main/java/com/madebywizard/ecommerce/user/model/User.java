package com.madebywizard.ecommerce.user.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "sex")
    private char sex;


    // converts JSON date to java.sql.Date
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    // nullable = false -> spring boot and hibernate enforce that birthDate cannot be null in the db.
    @Column(name = "birthDate", nullable = false)
    private LocalDate birthDate;

    @Column(name = "userId")
    private String userId;

    @Column(name = "userPswd")
    private String userPswd;  // password should be encrypted but just store as string for an educational purpose


    User() {}

    User(String name, char sex, LocalDate birthDate, String userId, String userPswd) {
        this.name = name;
        this.sex = sex;
        this.birthDate = birthDate;
        this.userId = userId;
        this.userPswd = userPswd;
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public char getSex() {
        return this.sex;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getUserPswd() {
        return this.userPswd;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserPswd(String userPswd) {
        this.userPswd = userPswd;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(this.id, user.id) &&
                Objects.equals(this.name, user.name) &&
                Objects.equals(this.sex, user.sex) &&
                Objects.equals(this.birthDate, user.birthDate) &&
                Objects.equals(this.userId, user.userId) &&
                Objects.equals(this.userPswd, user.userPswd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.sex, this.birthDate, this.userId, this.userPswd);
    }

    @Override
    public String toString() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = getBirthDate().format(formatter);

        return "User{" + "id=" + this.id +
                ", name='" + this.name + "'" +
                ", sex=" + this.sex +
                ", birthDate='" + formattedDate + "'" +
                ", userId='" + this.userId + "'" +
                ", userPswd='" + this.userPswd + "'" +
                "}";
    }
}
