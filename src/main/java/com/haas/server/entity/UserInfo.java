package com.haas.server.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Aya M. Ashraf
 */
@Entity
@Table(name = "user_info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserInfo.findAll", query = "SELECT u FROM UserInfo u"),
    @NamedQuery(name = "UserInfo.findByUserId", query = "SELECT u FROM UserInfo u WHERE u.userId = :userId"),
    @NamedQuery(name = "UserInfo.findByEmail", query = "SELECT u FROM UserInfo u WHERE u.email = :email"),
    @NamedQuery(name = "UserInfo.findByFirstName", query = "SELECT u FROM UserInfo u WHERE u.firstName = :firstName"),
    @NamedQuery(name = "UserInfo.findByLastName", query = "SELECT u FROM UserInfo u WHERE u.lastName = :lastName"),
    @NamedQuery(name = "UserInfo.findByPhone", query = "SELECT u FROM UserInfo u WHERE u.phone = :phone"),
    @NamedQuery(name = "UserInfo.findByPassword", query = "SELECT u FROM UserInfo u WHERE u.password = :password"),
    @NamedQuery(name = "UserInfo.findByGoldenCoins", query = "SELECT u FROM UserInfo u WHERE u.goldenCoins = :goldenCoins"),
    @NamedQuery(name = "UserInfo.findBySilverCoins", query = "SELECT u FROM UserInfo u WHERE u.silverCoins = :silverCoins"),
    @NamedQuery(name = "UserInfo.findByGender", query = "SELECT u FROM UserInfo u WHERE u.gender = :gender"),
    @NamedQuery(name = "UserInfo.findByCountry", query = "SELECT u FROM UserInfo u WHERE u.country = :country")})
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id")
    private Integer userId;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "email",unique = true)
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "last_name")
    private String lastName;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "phone")
    private String phone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "golden_coins")
    private double goldenCoins;
    @Basic(optional = false)
    @NotNull
    @Column(name = "silver_coins")
    private double silverCoins;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gender")
    private int gender;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "country")
    private String country;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Collection<UserUsesDevice> userUsesDeviceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "borrowerUser")
    private Collection<UserTransferCoinsUser> userTransferCoinsUserCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lenderUser")
    private Collection<UserTransferCoinsUser> userTransferCoinsUserCollection1;

    public UserInfo() {
    }

    public UserInfo(Integer userId) {
        this.userId = userId;
    }

    public UserInfo(Integer userId, String email, String firstName, String lastName, String phone, String password, double goldenCoins, double silverCoins, int gender, String country) {
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
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getGoldenCoins() {
        return goldenCoins;
    }

    public void setGoldenCoins(double goldenCoins) {
        this.goldenCoins = goldenCoins;
    }

    public double getSilverCoins() {
        return silverCoins;
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

    @XmlTransient
    @JsonIgnore
    public Collection<UserUsesDevice> getUserUsesDeviceCollection() {
        return userUsesDeviceCollection;
    }

    public void setUserUsesDeviceCollection(Collection<UserUsesDevice> userUsesDeviceCollection) {
        this.userUsesDeviceCollection = userUsesDeviceCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<UserTransferCoinsUser> getUserTransferCoinsUserCollection() {
        return userTransferCoinsUserCollection;
    }

    public void setUserTransferCoinsUserCollection(Collection<UserTransferCoinsUser> userTransferCoinsUserCollection) {
        this.userTransferCoinsUserCollection = userTransferCoinsUserCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<UserTransferCoinsUser> getUserTransferCoinsUserCollection1() {
        return userTransferCoinsUserCollection1;
    }

    public void setUserTransferCoinsUserCollection1(Collection<UserTransferCoinsUser> userTransferCoinsUserCollection1) {
        this.userTransferCoinsUserCollection1 = userTransferCoinsUserCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserInfo)) {
            return false;
        }
        UserInfo other = (UserInfo) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.haas.server.entity.UserInfo[ userId=" + userId + " ]";
    }
    
}
