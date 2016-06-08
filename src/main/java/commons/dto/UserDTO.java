package commons.dto;
// Generated May 9, 2016 10:35:03 PM by Hibernate Tools 4.3.1

/**
 * Author Shall
 */
public class UserDTO implements java.io.Serializable {

    private Integer userId;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private String password;
    private double goldenCoins;
    private double silverCoins;
    private int gender;
    private String country;

    public UserDTO() {
    }

    public UserDTO(Integer userId, String email, String firstName, String lastName, String phone, String password, double goldenCoins, double silverCoins, int gender, String country) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.password = password;
        this.goldenCoins = goldenCoins;
        this.silverCoins = silverCoins;
        this.gender = gender;
        this.country = country;
        this.userId = userId;
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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
