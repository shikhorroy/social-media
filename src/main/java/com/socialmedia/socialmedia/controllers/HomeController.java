package com.socialmedia.socialmedia.controllers;

import com.socialmedia.socialmedia.daos.SmAppConfigDao;
import com.socialmedia.socialmedia.models.SmAppConfig;
import com.socialmedia.socialmedia.roymvc.controller.RController;
import com.socialmedia.socialmedia.services.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "")
public class HomeController extends RController<HomeService> {

  @Autowired
  SmAppConfigDao smAppConfigDao;

  @RequestMapping(value = "/Home/", method = RequestMethod.GET)
  public Object home(HttpServletRequest request) {
    ModelAndView mv = new ModelAndView();
    Object obj = this.service.prepareHomeData(request);
    if (obj != null) {
      mv.addObject("smUserDetail", obj);
    }

    List<SmAppConfig> locationList = smAppConfigDao.findBySmConfigTypeId("locations");
    if (locationList.size() > 0) mv.addObject("locationList", locationList);

    mv.setViewName("Home");
    return mv;
  }
}
