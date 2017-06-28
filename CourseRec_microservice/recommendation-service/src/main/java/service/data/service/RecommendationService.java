package service.data.service;

import service.data.domain.entity.Recommendation;

import java.util.List;

/**
 * Created by jinyuanyuan on 2017/6/27.
 */
public interface RecommendationService {
    List<Recommendation> findRecommendation(String userid);

//    void updatePassword(String userid, String password);

    void save(Recommendation reco);

    Iterable<Recommendation> findAll();

    void delete(Long id);

    void deleteAll();
}
