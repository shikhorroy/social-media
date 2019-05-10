package com.socialmedia.socialmedia.daos;

import com.socialmedia.socialmedia.models.SmAppConfig;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SmAppConfigDao extends CrudRepository<SmAppConfig, Integer> {

  List<SmAppConfig> findBySmConfigTypeId(String configType);
}
