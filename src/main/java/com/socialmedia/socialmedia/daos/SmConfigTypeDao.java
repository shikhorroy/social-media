package com.socialmedia.socialmedia.daos;

import com.socialmedia.socialmedia.models.SmConfigType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmConfigTypeDao extends CrudRepository<SmConfigType, String> {
}
