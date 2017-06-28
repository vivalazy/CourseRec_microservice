package service.data.service;

import service.data.domain.entity.Recommendation_prepare;

import java.util.List;

/**
 * Created by jinyuanyuan on 2017/6/27.
 */
public interface RecPrepareService {
    List<Recommendation_prepare> findRecommendation(String userid);

//    void updatePassword(String userid, String password);

    void save(Recommendation_prepare reco);

    Iterable<Recommendation_prepare> findAll();

    void delete(Long id);

    void deleteAll();
}
