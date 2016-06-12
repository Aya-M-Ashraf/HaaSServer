package com.haas.webview.bean;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


/**
 *
 * @author Aya M. Ashraf
 */
public class TransferringOperationBean {

    private String coinsType;
    @Min(value = 1, message = "This value can't be 0")
    @NotNull
    private double coinsCount;
    @Email
    private String senderMail;
    @NotEmpty(message = "This field can't be null")
    @Email
    private String receiverMail;

    public TransferringOperationBean() {
    }

    public TransferringOperationBean(String coinsType, double coinsCount, String senderEmail, String receiverMail) {
        this.coinsType = coinsType;
        this.coinsCount = coinsCount;
        this.senderMail = senderEmail;
        this.receiverMail = receiverMail;
    }

    public String getCoinsType() {
        return coinsType;
    }

    public void setCoinsType(String coinsType) {
        this.coinsType = coinsType;
    }

    public double getCoinsCount() {
        return coinsCount;
    }

    public void setCoinsCount(double coinsCount) {
        this.coinsCount = coinsCount;
    }

    public String getSenderMail() {
        return senderMail;
    }

    public void setSenderMail(String senderEmail) {
        this.senderMail = senderEmail;
    }

    public String getReceiverMail() {
        return receiverMail;
    }

    public void setReceiverMail(String receiverMail) {
        this.receiverMail = receiverMail;
    }

}
