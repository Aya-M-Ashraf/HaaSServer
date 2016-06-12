package com.haas.webview.bean;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Aya M. Ashraf
 */
public class LoginBean {

    @NotEmpty(message = "This field can't be null")
    @Email
    private String email;
    @NotEmpty(message = "This field can't be null")
    private String password;

    public LoginBean() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
