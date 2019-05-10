package com.socialmedia.socialmedia.daos;

import com.socialmedia.socialmedia.models.SmPost;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmPostDao extends CrudRepository<SmPost, Integer> {
}
