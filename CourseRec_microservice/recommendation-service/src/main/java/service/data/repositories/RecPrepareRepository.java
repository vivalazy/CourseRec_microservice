package service.data.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import service.data.domain.entity.Recommendation_prepare;

import java.util.List;

/**
 * Created by jinyuanyuan on 2017/6/27.
 */
public interface RecPrepareRepository  extends CrudRepository<Recommendation_prepare,Long> {
    public List<Recommendation_prepare> findByUserId(@Param("userid")String userId );

}
