package service.data.service;

import service.data.domain.Course;

import java.util.List;

/**
 * Created by hasee on 2017/6/27.
 */
public interface CourseService {
    List<Course> findCourse(String userid);

   // void updatePassword(String userid,String password);

    void save(Course course);

    Iterable<Course> findAll();

    void delete(Long id);

    void deleteAll();
}
