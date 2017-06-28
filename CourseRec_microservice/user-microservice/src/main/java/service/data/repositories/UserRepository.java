package service.data.repositories;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import service.data.domain.entity.User2;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import service.data.domain.entity.User;

import java.util.List;

/**
 * Created by wuton on 2017/6/24.
 */
public interface UserRepository extends CrudRepository<User,Long> {
    public List<User> findByUserid(@Param("userid")String userid );
}
