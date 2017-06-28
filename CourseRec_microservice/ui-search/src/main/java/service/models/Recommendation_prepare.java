package service.models;

/**
 * Created by jinyuanyuan on 2017/6/27.
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by jinyuanyuan on 2017/6/27.
 */
@Entity
public class Recommendation_prepare {
    @Id
    @GeneratedValue
    private Long id;
    private String userId;
    private String courseId;
    private String courseName;
    private String course_url;
    private double reco_score;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourse_url() {
        return course_url;
    }

    public void setCourse_url(String course_url) {
        this.course_url = course_url;
    }

    public double getReco_score(){return reco_score;}

    public void setReco_score(double reco_score){this.reco_score = reco_score;}

    public Recommendation_prepare() {
    }




    public Recommendation_prepare(String userid,String courseId, String courseName,String course_url, double reco_score ){
        this.userId = userid;
        this.courseId = courseId;
        this.courseName = courseName;
        this.course_url = course_url;
        this.reco_score = reco_score;
    }
}

