package service.data.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import service.data.domain.entity.Recommendation;

import java.util.List;

/**
 * Created by jinyuanyuan on 2017/6/27.
 */
public interface RecommendationRepository  extends CrudRepository<Recommendation,Long> {
    public List<Recommendation> findByUserId(@Param("userid")String userId );

}

