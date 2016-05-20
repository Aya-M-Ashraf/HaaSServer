package com.haas.server.entity;

import com.haas.server.entity.key.UserTransferCoinsUserPK;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Aya M. Ashraf
 */
@Entity
@Table(name = "user_transfer_coins_user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserTransferCoinsUser.findAll", query = "SELECT u FROM UserTransferCoinsUser u"),
    @NamedQuery(name = "UserTransferCoinsUser.findByBorrowerUserId", query = "SELECT u FROM UserTransferCoinsUser u WHERE u.userTransferCoinsUserPK.borrowerUserId = :borrowerUserId"),
    @NamedQuery(name = "UserTransferCoinsUser.findByLenderUserId", query = "SELECT u FROM UserTransferCoinsUser u WHERE u.userTransferCoinsUserPK.lenderUserId = :lenderUserId"),
    @NamedQuery(name = "UserTransferCoinsUser.findByTransactionTimestamp", query = "SELECT u FROM UserTransferCoinsUser u WHERE u.userTransferCoinsUserPK.transactionTimestamp = :transactionTimestamp"),
    @NamedQuery(name = "UserTransferCoinsUser.findByCoinsAmount", query = "SELECT u FROM UserTransferCoinsUser u WHERE u.coinsAmount = :coinsAmount")})
public class UserTransferCoinsUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserTransferCoinsUserPK userTransferCoinsUserPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "coins_amount")
    private double coinsAmount;
    @JoinColumn(name = "borrower_user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User borrowerUser;
    @JoinColumn(name = "lender_user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User lenderUser;

    public UserTransferCoinsUser() {
    }

    public UserTransferCoinsUser(UserTransferCoinsUserPK userTransferCoinsUserPK) {
        this.userTransferCoinsUserPK = userTransferCoinsUserPK;
    }

    public UserTransferCoinsUser(UserTransferCoinsUserPK userTransferCoinsUserPK, double coinsAmount) {
        this.userTransferCoinsUserPK = userTransferCoinsUserPK;
        this.coinsAmount = coinsAmount;
    }

    public UserTransferCoinsUser(int borrowerUserId, int lenderUserId, Date transactionTimestamp) {
        this.userTransferCoinsUserPK = new UserTransferCoinsUserPK(borrowerUserId, lenderUserId, transactionTimestamp);
    }

    public UserTransferCoinsUserPK getUserTransferCoinsUserPK() {
        return userTransferCoinsUserPK;
    }

    public void setUserTransferCoinsUserPK(UserTransferCoinsUserPK userTransferCoinsUserPK) {
        this.userTransferCoinsUserPK = userTransferCoinsUserPK;
    }

    public double getCoinsAmount() {
        return coinsAmount;
    }

    public void setCoinsAmount(double coinsAmount) {
        this.coinsAmount = coinsAmount;
    }

    public User getBorrowerUser() {
        return borrowerUser;
    }

    public void setBorrowerUser(User user) {
        this.borrowerUser = user;
    }

    public User getLenderUser() {
        return lenderUser;
    }

    public void setLenderUser(User lenderUser) {
        this.lenderUser = lenderUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userTransferCoinsUserPK != null ? userTransferCoinsUserPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserTransferCoinsUser)) {
            return false;
        }
        UserTransferCoinsUser other = (UserTransferCoinsUser) object;
        if ((this.userTransferCoinsUserPK == null && other.userTransferCoinsUserPK != null) || (this.userTransferCoinsUserPK != null && !this.userTransferCoinsUserPK.equals(other.userTransferCoinsUserPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitiy.UserTransferCoinsUser[ userTransferCoinsUserPK=" + userTransferCoinsUserPK + " ]";
    }

}
