package com.socialmedia.socialmedia.services;

import com.socialmedia.socialmedia.daos.HomeDao;
import com.socialmedia.socialmedia.daos.SmAppConfigDao;
import com.socialmedia.socialmedia.daos.SmUserDetailDao;
import com.socialmedia.socialmedia.models.SmAppConfig;
import com.socialmedia.socialmedia.models.SmPost;
import com.socialmedia.socialmedia.models.SmUserDetail;
import com.socialmedia.socialmedia.roymvc.service.RService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Service
public class HomeService extends RService<HomeDao> {

  @Autowired
  SmUserDetailDao smUserDetailDao;

  @Autowired
  SmAppConfigDao smAppConfigDao;

  public Object prepareHomeData(HttpServletRequest request) {
    ModelAndView mv = new ModelAndView();
    Optional<SmUserDetail> smUserDetailOpt = smUserDetailDao.findByUserIdAndUserUserName(1, "roy");
    if (smUserDetailOpt.isPresent()) {
      SmUserDetail smUserDetail = smUserDetailOpt.get();

      if (smUserDetail != null) {
        mv.addObject("smUserDetail", smUserDetail);
      }

      List<SmAppConfig> locationList = smAppConfigDao.findBySmConfigTypeId("locations");
      if (locationList.size() > 0) mv.addObject("locationList", locationList);

      mv.addObject("smPost", new SmPost());

      mv.setViewName("Home");
    }
    return mv;
  }
}
