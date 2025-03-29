package com.madebywizard.ecommerce.customer.model;

// A DTO (data transfer object) for Customer
public class CustomerDTO {

    private Integer id;
    private String customerId;
    private String lastName;
    private String email;

    public CustomerDTO(Customer customer) {
        this.id = customer.getId();
        this.customerId = customer.getCustomerId();
        this.lastName = customer.getLastName();
        this.email = customer.getEmail();
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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
        return "CustomerDTO{" + "id=" + this.id +
                ", customerId='" + this.customerId + "'" +
                ", lastName='" + this.lastName + "'" +
                ", email='" + this.email + "'" +
                "}";
    }
}
