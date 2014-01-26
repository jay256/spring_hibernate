package com.sprsec.model;

import java.text.SimpleDateFormat;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue
    @Column(name = "cid")
    private Integer cid;
    @Column(name = "commented_on")
    private Integer commented_on;
    @Column(name = "commented_by")
    private Integer commented_by;
    @Column(name="comment")
    private String comment;
    @Column(name = "time")
    private String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
    
    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getCommented_on() {
        return commented_on;
    }

    public void setCommented_on(Integer commented_on) {
        this.commented_on = commented_on;
    }

    public Integer getCommented_by() {
        return commented_by;
    }

    public void setCommented_by(Integer commented_by) {
        this.commented_by = commented_by;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
