package com.bsu.edu.restapi.DTO;

public class LoginDTO {
    private String login;
    private String password;
    private String device_id;

    public LoginDTO() {}

    public LoginDTO(String login, String password, String device_id) {
        this.login = login;
        this.password = password;
        this.device_id = device_id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }
}
