package com.dragonsoft.dao;

import com.dragonsoft.domain.User;
import org.apache.ibatis.annotations.Select;

/**
 * @author ronin
 */
public interface UserDao {

    @Select("SELECT ID,USERNAME,PASSWORD FROM T_USER WHERE ID =#{id}")
    User getUserById(String id);
}
