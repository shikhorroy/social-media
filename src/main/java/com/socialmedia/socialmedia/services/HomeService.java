package com.socialmedia.socialmedia.services;

import com.socialmedia.socialmedia.daos.HomeDao;
import com.socialmedia.socialmedia.daos.SmAppConfigDao;
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
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String currentPrincipalName = authentication.getName();
    Optional<SmUserDetail> smUserDetailOpt = smUserDetailDao.findByUserUsername("roy");
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
    else mv.addObject("smUserDetail", new SmUserDetail());
    return mv;
  }

  @Autowired
  SmUserService smUserService;

  public boolean checkLogin(SmUser user) {
    Optional<SmUser> userOpt = smUserService.getDao().findByUsername(user.getUsername());
    if (userOpt.isPresent()) {
      SmUser smUser = userOpt.get();
      if (smUser.getPassword() == null) return false;
      BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
      if (encoder.matches(user.getPassword(), smUser.getPassword())) return true;
    }
    return false;
  }
}
