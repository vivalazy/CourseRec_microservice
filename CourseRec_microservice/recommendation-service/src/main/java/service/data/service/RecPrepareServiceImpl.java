package service.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import service.data.domain.entity.Recommendation_prepare;
import service.data.repositories.RecPrepareRepository;

import java.util.List;

/**
 * Created by jinyuanyuan on 2017/6/27.
 */
@Service
public class RecPrepareServiceImpl  implements RecPrepareService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private RecPrepareRepository RecoRepository;

    RowMapper<Recommendation_prepare> rm = BeanPropertyRowMapper.newInstance(Recommendation_prepare.class);

    @Override
    public List<Recommendation_prepare> findRecommendation(String userid) {
//        return jdbcTemplate.queryForObject("select * from recommendation where userId=?",new Object[]{userid},rm);
        return RecoRepository.findByUserId(userid);
    }


    @Override
    public void save(Recommendation_prepare user) {
        RecoRepository.save(user);
    }

    @Override
    public Iterable<Recommendation_prepare> findAll() {
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
