package com.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Invitation {
    private int invitationId;

    private int senderUid;
    private int receiverUid;

    //invitation state
    //0: not resolve
    //1: agree
    //2: refuse
    private int state;

    private String senderName;
    private String senderEmail;

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public Invitation() {
    }

    public Invitation(int senderUid, int receiverUid, int state) {
        this.senderUid = senderUid;
        this.receiverUid = receiverUid;
        this.state = state;
    }

    @Id
    @Column(name = "invitationId")
    public int getInvitationId() {
        return invitationId;
    }

    public void setInvitationId(int invitationId) {
        this.invitationId = invitationId;
    }

    @Basic
    @Column(name = "senderUid")
    public int getSenderUid() {
        return senderUid;
    }

    public void setSenderUid(int senderUid) {
        this.senderUid = senderUid;
    }

    @Basic
    @Column(name = "receiverUid")
    public int getReceiverUid() {
        return receiverUid;
    }

    public void setReceiverUid(int receiverUid) {
        this.receiverUid = receiverUid;
    }

    @Basic
    @Column(name = "state")
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invitation that = (Invitation) o;
        return invitationId == that.invitationId &&
                senderUid == that.senderUid &&
                receiverUid == that.receiverUid &&
                state == that.state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(invitationId, senderUid, receiverUid, state);
    }
}
