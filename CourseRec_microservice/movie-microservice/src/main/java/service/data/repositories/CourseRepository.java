package service.data.repositories;
import org.springframework.data.repository.query.Param;
import service.data.domain.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by hasee on 2017/6/27.
 */
public interface CourseRepository extends CrudRepository<Course,Long> {
    public List<Course> findByUserid(@Param("userid")String userid );
}
