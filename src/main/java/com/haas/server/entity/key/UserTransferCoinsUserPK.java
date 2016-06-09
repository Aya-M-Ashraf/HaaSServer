package com.haas.server.entity.key;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Aya M. Ashraf
 */
@Embeddable
public class UserTransferCoinsUserPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "borrower_user_id")
    private int borrowerUserId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "lender_user_id")
    private int lenderUserId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "transaction_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionTimestamp;

    public UserTransferCoinsUserPK() {
    }

    public UserTransferCoinsUserPK(int borrowerUserId, int lenderUserId, Date transactionTimestamp) {
        this.borrowerUserId = borrowerUserId;
        this.lenderUserId = lenderUserId;
        this.transactionTimestamp = transactionTimestamp;
    }

    public int getBorrowerUserId() {
        return borrowerUserId;
    }

    public void setBorrowerUserId(int borrowerUserId) {
        this.borrowerUserId = borrowerUserId;
    }

    public int getLenderUserId() {
        return lenderUserId;
    }

    public void setLenderUserId(int lenderUserId) {
        this.lenderUserId = lenderUserId;
    }

    public Date getTransactionTimestamp() {
        return transactionTimestamp;
    }

    public void setTransactionTimestamp(Date transactionTimestamp) {
        this.transactionTimestamp = transactionTimestamp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) borrowerUserId;
        hash += (int) lenderUserId;
        hash += (transactionTimestamp != null ? transactionTimestamp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserTransferCoinsUserPK)) {
            return false;
        }
        UserTransferCoinsUserPK other = (UserTransferCoinsUserPK) object;
        if (this.borrowerUserId != other.borrowerUserId) {
            return false;
        }
        if (this.lenderUserId != other.lenderUserId) {
            return false;
        }
        if ((this.transactionTimestamp == null && other.transactionTimestamp != null) || (this.transactionTimestamp != null && !this.transactionTimestamp.equals(other.transactionTimestamp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.haas.server.entity.UserTransferCoinsUserPK[ borrowerUserId=" + borrowerUserId + ", lenderUserId=" + lenderUserId + ", transactionTimestamp=" + transactionTimestamp + " ]";
    }
    
}
