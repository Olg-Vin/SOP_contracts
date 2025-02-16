package org.vinio.controllers.GraphQL.inputs;

public class UserInputDTO {
    private String name;
    private String email;

    public UserInputDTO() {
    }

    public UserInputDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}