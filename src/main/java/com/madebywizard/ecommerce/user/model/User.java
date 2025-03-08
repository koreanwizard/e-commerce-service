package com.madebywizard.ecommerce.user.model;


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

    // @NotNull(message = "first name is required") ensure that this field cannot be null
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    // @Pattern(regexp = 'M|F", message = "sex must be 'M' or 'F'") ensure that the input 'sex' should match the customized regular expression.
    @Column(name = "sex")
    private char sex;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_password")
    private String userPassword;  // password should be encrypted but just store it as string for an educational purpose


    User() {}

    User(String firstName, String lastName, char sex, LocalDate birthDate, String userId, String userPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.birthDate = birthDate;
        this.userId = userId;
        this.userPassword = userPassword;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getSex() {
        return this.sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return this.userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
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
                Objects.equals(this.firstName, user.firstName) &&
                Objects.equals(this.lastName, user.lastName) &&
                Objects.equals(this.sex, user.sex) &&
                Objects.equals(this.birthDate, user.birthDate) &&
                Objects.equals(this.userId, user.userId) &&
                Objects.equals(this.userPassword, user.userPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.firstName, this.lastName, this.sex, this.birthDate, this.userId, this.userPassword);
    }

    @Override
    public String toString() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = getBirthDate().format(formatter);

        return "User{" + "id=" + this.id +
                ", firstName='" + this.firstName + "'" +
                ", lastName='" + this.lastName + "'" +
                ", sex=" + this.sex +
                ", birthDate='" + formattedDate + "'" +
                ", userId='" + this.userId + "'" +
                ", userPswd='" + this.userPassword + "'" +
                "}";
    }
}
