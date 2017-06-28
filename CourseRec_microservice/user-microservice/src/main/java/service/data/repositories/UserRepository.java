package service.data.repositories;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import service.data.domain.entity.User2;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends GraphRepository<User2> {

    @Override
    @CacheEvict(value = "cache", key = "#p0.id")
    <U extends User2> U save(U entity);

    @Override
    @CacheEvict(value = "cache", key = "#p0", beforeInvocation = true)
    void delete(Long aLong);

    @Override
    @CacheEvict(value = "cache", key = "#p0.id", beforeInvocation = true)
    void delete(User2 entity);

    @Override
    @Cacheable(value = "cache", key = "#p0")
    User2 findOne(Long aLong);

    List<User2> findByZipcode(@Param("4") String zipcode);

    List<User2> findByOccupation(@Param("teacher") String teacher);

    User2 findById(@Param("id") int id);

}
