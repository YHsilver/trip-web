package com.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Comments {
    private int cid;
    private String username;
    private int imageId;
    private String comment;
    private int hot;
    private Timestamp time;

    public Comments() {
    }

    public Comments(String username, int imageId, String comment) {
        this.username = username;
        this.imageId = imageId;
        this.comment = comment;
    }

    @Id
    @Column(name = "cid")
    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "imageId")
    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    @Basic
    @Column(name = "comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Basic
    @Column(name = "hot")
    public int getHot() {
        return hot;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }

    @Basic
    @Column(name = "time")
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comments comments = (Comments) o;
        return cid == comments.cid &&
                imageId == comments.imageId &&
                Objects.equals(username, comments.username) &&
                Objects.equals(comment, comments.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cid, username, imageId, comment);
    }
}
