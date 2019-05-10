package com.socialmedia.socialmedia.services;

import com.socialmedia.socialmedia.daos.HomeDao;
import com.socialmedia.socialmedia.daos.SmUserDetailDao;
import com.socialmedia.socialmedia.models.SmUserDetail;
import com.socialmedia.socialmedia.roymvc.service.RService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Service
public class HomeService extends RService<HomeDao> {

  @Autowired
  SmUserDetailDao smUserDetailDao;

  public Object prepareHomeData(HttpServletRequest request) {
    Optional<SmUserDetail> smUserDetailOpt = smUserDetailDao.findByUserIdAndUserUserName(1, "roy");
    if (smUserDetailOpt.isPresent()) {
      SmUserDetail smUserDetail = smUserDetailOpt.get();
      return smUserDetail;
    }
    return null;
  }
}
