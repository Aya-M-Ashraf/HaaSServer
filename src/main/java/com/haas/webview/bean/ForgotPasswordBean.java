package com.haas.webview.bean;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Aya M. Ashraf
 */
public class ForgotPasswordBean {

    @Email
    @NotEmpty
    private String email;
    @NotEmpty
    @Pattern(regexp = "(^$|[0-9]{11})", message = "This is not a valid phone number")
    @Size(min = 11, max = 11)
    private String phone;

    public ForgotPasswordBean() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
