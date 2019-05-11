package com.socialmedia.socialmedia.daos;

import com.socialmedia.socialmedia.models.SmUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SmUserDao extends CrudRepository<SmUser, Integer> {
  Optional<SmUser> findByIdAndUsername(int i, String roy);

  Optional<SmUser> findByUsername(String userName);
}
