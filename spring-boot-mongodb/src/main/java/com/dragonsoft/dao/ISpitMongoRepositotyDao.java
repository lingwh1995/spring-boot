package com.dragonsoft.dao;

import com.dragonsoft.entity.Spit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ronin
 */
@Repository
public interface ISpitMongoRepositotyDao extends MongoRepository<Spit,String>{
}
