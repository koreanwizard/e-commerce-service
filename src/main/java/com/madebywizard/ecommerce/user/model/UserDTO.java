package com.madebywizard.ecommerce.user.model;

import java.util.Objects;

public class UserDTO {

    private Integer id;
    private String name;
    private String userId;

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.userId = user.getUserId();
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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
                Objects.equals(this.name, userDTO.name) &&
                Objects.equals(this.userId, userDTO.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.userId);
    }

    @Override
    public String toString() {
        return "UserDTO{" + "id=" + this.id +
                ", name='" + this.name + "'" +
                ", userId='" + this.userId + "'" + "}";
    }
}
