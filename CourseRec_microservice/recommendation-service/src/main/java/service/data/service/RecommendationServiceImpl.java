package service.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import service.data.domain.entity.Recommendation;
import service.data.repositories.RecommendationRepository;

import java.util.List;

/**
 * Created by jinyuanyuan on 2017/6/27.
 */
@Service
public class RecommendationServiceImpl implements RecommendationService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private RecommendationRepository RecoRepository;

    RowMapper<Recommendation> rm = BeanPropertyRowMapper.newInstance(Recommendation.class);

    @Override
    public List<Recommendation> findRecommendation(String userid) {
//        return jdbcTemplate.queryForObject("select * from recommendation where userId=?",new Object[]{userid},rm);
        return RecoRepository.findByUserId(userid);
    }


    @Override
    public void save(Recommendation user) {
        RecoRepository.save(user);
    }

    @Override
    public Iterable<Recommendation> findAll() {
        return RecoRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        RecoRepository.delete(id);
    }

    @Override
    public void deleteAll() {
        RecoRepository.deleteAll();
    }

}

