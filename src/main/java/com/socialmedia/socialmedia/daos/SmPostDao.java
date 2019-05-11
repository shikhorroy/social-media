package com.socialmedia.socialmedia.daos;

import com.socialmedia.socialmedia.models.SmPost;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SmPostDao extends CrudRepository<SmPost, Integer> {
  List<SmPost> findAllByPrivacyOrderByIdDesc(String privacy);

  List<SmPost> findAllByUserIdAndUserUserNameOrderByIdDesc(Integer useid, String username);
}
