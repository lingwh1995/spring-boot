package com.dragonsoft.service;

import com.dragonsoft.dao.ISpitMongoRepositotyDao;
import com.dragonsoft.entity.Spit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ronin
 */
@Service
@Transactional
public class SpitMongoRepositotyService {

    @Autowired
    private ISpitMongoRepositotyDao spitDao;

    public List<Spit> findAll(){
        return spitDao.findAll();
    }

    public Spit findById(String id){
        return spitDao.findById(id).get();
    }

    public Spit save(Spit spit){
        return spitDao.save(spit);
    }

    public void deleteById(String spitId){
        spitDao.deleteById(spitId);
    }

    public Spit update(Spit spit){
        return spitDao.save(spit);
    }
}
