package service.data.service;

import service.data.domain.entity.User;
import java.util.List;
/**
 * Created by wuton on 2017/6/24.
 */
public interface UserService {
    List<User> findByUserid(String userid);

    void updatePassword(String userid,String password);

    void save(User user);

    Iterable<User> findAll();

    void delete(Long id);
}
