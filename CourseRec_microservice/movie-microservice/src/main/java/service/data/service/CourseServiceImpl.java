package service.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import service.data.domain.Course;
import service.data.repositories.CourseRepository;

import java.util.List;

/**
 * Created by hasee on 2017/6/27.
 */
@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private CourseRepository courseRepository;

    RowMapper<Course> rm = BeanPropertyRowMapper.newInstance(Course.class);
    @Override
    public List<Course> findCourse(String userid) {
//        return jdbcTemplate.queryForObject("select * from user where userid=?",new Object[]{userid},rm);
        return courseRepository.findByUserid(userid);
    }


    @Override
    public void save(Course course) {
        courseRepository.save(course);
    }

    @Override
    public Iterable<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        courseRepository.delete(id);
    }

    @Override
    public void deleteAll() {
        courseRepository.deleteAll();
    }
}
