package com.socialmedia.socialmedia.services;

import com.socialmedia.socialmedia.daos.SmPostDao;
import com.socialmedia.socialmedia.models.SmPost;
import com.socialmedia.socialmedia.roymvc.service.RService;
import org.joda.time.LocalDate;
import org.springframework.stereotype.Service;

@Service
public class SmPostService extends RService<SmPostDao> {

  public boolean savePostData(SmPost post) {
    try {
      post.setPostedOn(LocalDate.now());
      post.setModifiedOn(LocalDate.now());
      this.dao.save(post);
      return true;
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
    return false;
  }

  public boolean updatePost(SmPost post) {
    try {
      post.setModifiedOn(LocalDate.now());
      this.dao.save(post);
      return true;
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
    return false;
  }
}
