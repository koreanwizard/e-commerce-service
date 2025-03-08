package com.madebywizard.ecommerce.user.model;

import java.util.Objects;

public class UserDTO {

    private Integer id;
    private String firstName;
    private String lastName;
    private String userId;

    public UserDTO(User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.userId = user.getUserId();
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

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UserDTO)) {
            return false;
        }
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(this.id, userDTO.id) &&
                Objects.equals(this.firstName, userDTO.firstName) &&
                Objects.equals(this.lastName, userDTO.lastName) &&
                Objects.equals(this.userId, userDTO.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.firstName, this.lastName, this.userId);
    }

    @Override
    public String toString() {
        return "UserDTO{" + "id=" + this.id +
                ", firstName='" + this.firstName + "'" +
                ", lastName='" + this.lastName + "'" +
                ", userId='" + this.userId + "'" + "}";
    }
}
