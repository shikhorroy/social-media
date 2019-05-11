package com.socialmedia.socialmedia.services;

import com.socialmedia.socialmedia.daos.SmAppConfigDao;
import com.socialmedia.socialmedia.daos.SmUserDao;
import com.socialmedia.socialmedia.daos.SmUserDetailDao;
import com.socialmedia.socialmedia.models.SmAppConfig;
import com.socialmedia.socialmedia.models.SmPost;
import com.socialmedia.socialmedia.models.SmUserDetail;
import com.socialmedia.socialmedia.roymvc.service.RService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Service
public class SmUserService extends RService<SmUserDao> {

  @Autowired
  SmUserDetailDao smUserDetailDao;

  @Autowired
  SmAppConfigDao smAppConfigDao;

  @Autowired
  SmPostService smPostService;

  public ModelAndView prepareProfileData() {
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
    }
    else mv.addObject("smUserDetail", new SmUserDetail());

    List<SmPost> publicPostList = smPostService.getDao().findAllByUserIdAndUserUserNameOrderByIdDesc(1, "roy");
    mv.addObject("publicPostList", publicPostList);

    mv.setViewName("user/Profile");
    return mv;
  }
}
