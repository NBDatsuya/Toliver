package tgkt.toliver.dao;

import tgkt.toliver.entity.AuthorizeInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorizeInfoRepository
        extends CrudRepository<AuthorizeInfo, String> {

    @Override
    Optional<AuthorizeInfo> findById(String s);

    @Override
    Iterable<AuthorizeInfo> findAll();

    @Override
    long count();

    @Override
    void deleteById(String s);

    @Override
    void delete(AuthorizeInfo entity);

    @Override
    void deleteAll();
}
