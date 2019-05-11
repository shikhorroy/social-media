package com.socialmedia.socialmedia.daos;

import com.socialmedia.socialmedia.models.SmUserDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SmUserDetailDao extends CrudRepository<SmUserDetail, Integer> {

  Optional<SmUserDetail> findByUserUsername(String roy);
}
