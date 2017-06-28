package service.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import service.data.domain.entity.User;
import service.data.repositories.UserRepository;
import service.data.repositories.UserRepository2;

/**
 * Created by wuton on 2017/6/24.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserRepository2 userRepository;

    RowMapper<User> rm = BeanPropertyRowMapper.newInstance(User.class);
    @Override
    public User findUser(String userid) {
        return jdbcTemplate.queryForObject("select * from user where userid=?",new Object[]{userid},rm);
    }

    @Override
    public void updatePassword(String userid,String password) {
        jdbcTemplate.update("UPDATE USER SET password=? WHERE userid=?",password,userid);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }

}
