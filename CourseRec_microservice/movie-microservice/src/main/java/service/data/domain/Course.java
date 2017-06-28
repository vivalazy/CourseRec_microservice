package service.data.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by hasee on 2017/6/27.
 */
@Entity
public class Course {
    @Id
    @GeneratedValue
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    private String userid;
    private String courseid;
    private String coursename;
    private String score;
    private String timestamp;
    public Course()
    { }

    public Course(String userid, String courseid, String coursename, String score, String timestamp) {
        this.userid = userid;
        this.courseid = courseid;
        this.coursename = coursename;
        this.score = score;
        this.timestamp = timestamp;
    }
}
