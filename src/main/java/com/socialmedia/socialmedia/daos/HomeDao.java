package com.socialmedia.socialmedia.daos;

import com.socialmedia.socialmedia.models.SmAppConfig;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeDao extends CrudRepository<SmAppConfig, Integer> {
}
