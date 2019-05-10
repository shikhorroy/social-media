package com.socialmedia.socialmedia.daos;

import com.socialmedia.socialmedia.models.SmUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmUserDao extends CrudRepository<SmUser, Integer> {
}
