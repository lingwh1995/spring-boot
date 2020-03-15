package com.dragonsoft.service;

import com.dragonsoft.entity.Spit;
import com.mongodb.client.result.DeleteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ronin
 */
@Service
@Transactional
public class SpitMongonTemplateService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Spit> findAll(){
        return mongoTemplate.findAll(Spit.class);
    }

    public Spit findById(String id){
        return mongoTemplate.findById(id,Spit.class);
    }

    public Spit save(Spit spit){
        return mongoTemplate.save(spit);
    }

    public DeleteResult remove(Spit spit){
        return mongoTemplate.remove(spit);
    }

    public Spit update(Spit spit){
        return mongoTemplate.save(spit);
    }
}
