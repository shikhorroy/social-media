package com.socialmedia.socialmedia.services;

import com.socialmedia.socialmedia.daos.SmAppConfigDao;
import com.socialmedia.socialmedia.daos.SmUserDao;
import com.socialmedia.socialmedia.daos.SmUserDetailDao;
import com.socialmedia.socialmedia.models.SmAppConfig;
import com.socialmedia.socialmedia.models.SmPost;
import com.socialmedia.socialmedia.models.SmUser;
import com.socialmedia.socialmedia.models.SmUserDetail;
import com.socialmedia.socialmedia.roymvc.service.RService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;
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
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String currentPrincipalName = authentication.getName();
    Optional<SmUserDetail> smUserDetailOpt = smUserDetailDao.findByUserUsername(currentPrincipalName);
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

    List<SmPost> publicPostList = smPostService.getDao().findAllByUserUsernameOrderByIdDesc(currentPrincipalName);
    mv.addObject("publicPostList", publicPostList);

    mv.setViewName("user/Profile");
    return mv;
  }

  @Transactional
  public boolean saveUserDetail(SmUserDetail userDetail) {
    SmUser user = userDetail.getUser();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    user.setPassword(encoder.encode(user.getPassword()));
    user.setInactive(0);
    user.setDeleted(0);
    try {
      user = this.dao.save(user);
      userDetail.setUser(user);
      userDetail.setInactive(0);
      userDetail.setDeleted(0);
      this.smUserDetailDao.save(userDetail);
      return true;
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
    return false;
  }
}
