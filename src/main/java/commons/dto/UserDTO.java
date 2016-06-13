package commons.dto;
// Generated May 9, 2016 10:35:03 PM by Hibernate Tools 4.3.1

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Author Shall
 */
public class UserDTO implements java.io.Serializable {

    private Integer userId;
    @NotEmpty(message = "This field can't be null")
    @Email
    private String email;
    @NotEmpty(message = "This field can't be null")
    private String firstName;
    @NotEmpty(message = "This field can't be null")
    private String lastName;
    @NotEmpty
    @Pattern(regexp = "(^$|[0-9]{11})", message = "This is not a valid phone number")
    @Size(min = 11, max = 11)
    private String phone;
    @NotEmpty(message = "This field can't be null")
    private String password;
    private double goldenCoins;
    private double silverCoins;
    @NotNull(message = "This field can't be null")
    private Integer gender;
    @NotEmpty(message = "This field can't be null")
    private String country;

    public UserDTO() {
    }

    public UserDTO(Integer userId, String email, String firstName, String lastName, String phone, String password, double goldenCoins, double silverCoins, Integer gender, String country) {
        this.userId = userId;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.password = password;
        this.goldenCoins = goldenCoins;
        this.silverCoins = silverCoins;
        this.gender = gender;
        this.country = country;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getGoldenCoins() {
        return this.goldenCoins;
    }

    public void setGoldenCoins(double goldenCoins) {
        this.goldenCoins = goldenCoins;
    }

    public double getSilverCoins() {
        return this.silverCoins;
    }

    public void setSilverCoins(double silverCoins) {
        this.silverCoins = silverCoins;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
