package com.socialmedia.socialmedia.daos;

import com.socialmedia.socialmedia.models.SmUserDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmUserDetailDao extends CrudRepository<SmUserDetail, Integer> {
}
