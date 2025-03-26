package com.madebywizard.ecommerce.user.model;

import java.util.Objects;

// A DTO (data transfer object) for User
public class UserDTO {

    private Integer id;
    private String userId;
    private String lastName;
    private String email;

    public UserDTO(User user) {
        this.id = user.getId();
        this.userId = user.getUserId();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

// these can be omitted
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (!(o instanceof UserDTO)) {
//            return false;
//        }
//        UserDTO userDTO = (UserDTO) o;
//        return Objects.equals(this.id, userDTO.id) &&
//                Objects.equals(this.userId, userDTO.userId) &&
//                Objects.equals(this.lastName, userDTO.lastName) &&
//                Objects.equals(this.email, userDTO.email);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(this.id, this.userId, this.lastName, this.email);
//    }

    // can be used for debugging purposes
    @Override
    public String toString() {
        return "UserDTO{" + "id=" + this.id +
                ", userId='" + this.userId + "'" +
                ", lastName='" + this.lastName + "'" +
                ", email='" + this.email + "'" +
                "}";
    }
}
