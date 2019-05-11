package com.socialmedia.socialmedia.controllers;

import com.socialmedia.socialmedia.daos.SmAppConfigDao;
import com.socialmedia.socialmedia.daos.SmUserDetailDao;
import com.socialmedia.socialmedia.models.SmAppConfig;
import com.socialmedia.socialmedia.models.SmPost;
import com.socialmedia.socialmedia.models.SmUserDetail;
import com.socialmedia.socialmedia.roymvc.controller.RController;
import com.socialmedia.socialmedia.services.SmPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/Post")
public class SmPostController extends RController<SmPostService> {

  @ResponseBody
  @RequestMapping(value = "/List/", method = RequestMethod.GET)
  public Object list(HttpServletRequest request) {
    return this.service.getDao().findAll();
  }


  @Autowired
  SmUserDetailDao smUserDetailDao;

  @Autowired
  SmAppConfigDao smAppConfigDao;
  
  @RequestMapping(value = "/Edit/{id}/", method = RequestMethod.GET)
  public Object edit(HttpServletRequest request, @PathVariable Integer id) {
    ModelAndView mv = new ModelAndView();
    Optional<SmPost> smPostOpt = this.service.getDao().findById(id);
    if (smPostOpt.isPresent()) {
      mv.addObject("smPost", smPostOpt.get());
    }
    else mv.addObject("smPost", new SmPost());

    Optional<SmUserDetail> smUserDetailOpt = smUserDetailDao.findByUserIdAndUserUserName(1, "roy");
    if (smUserDetailOpt.isPresent()) {
      SmUserDetail smUserDetail = smUserDetailOpt.get();

      if (smUserDetail != null) {
        mv.addObject("smUserDetail", smUserDetail);
      }

      List<SmAppConfig> locationList = smAppConfigDao.findBySmConfigTypeId("locations");
      if (locationList.size() > 0) mv.addObject("locationList", locationList);
    }
    else mv.addObject("smUserDetail", new SmUserDetail());

    mv.setViewName("post/Edit");
    return mv;
  }
}
