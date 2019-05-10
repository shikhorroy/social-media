package com.socialmedia.socialmedia.controllers;

import com.socialmedia.socialmedia.models.SmUserDetail;
import com.socialmedia.socialmedia.roymvc.controller.RController;
import com.socialmedia.socialmedia.services.HomeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "")
public class HomeController extends RController<HomeService> {

  @RequestMapping(value = "/Home/", method = RequestMethod.GET)
  public Object home(HttpServletRequest request) {
    ModelAndView mv = new ModelAndView();
    Object obj = this.service.prepareHomeData(request);
    if (obj != null) {
      mv.addObject("smUserDetail", obj);
    }
    mv.setViewName("Home");
    return mv;
  }
}
