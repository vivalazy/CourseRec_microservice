package service.data.repositories;

import org.springframework.data.repository.CrudRepository;
import service.data.domain.entity.User;

/**
 * Created by wuton on 2017/6/24.
 */
public interface UserRepository2 extends CrudRepository<User,Long> {
}
