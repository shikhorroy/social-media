package com.socialmedia.socialmedia.controllers;

import com.socialmedia.socialmedia.daos.SmAppConfigDao;
import com.socialmedia.socialmedia.models.SmPost;
import com.socialmedia.socialmedia.roymvc.controller.RController;
import com.socialmedia.socialmedia.services.HomeService;
import com.socialmedia.socialmedia.services.SmPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    ModelAndView mv = (ModelAndView) this.service.prepareHomeData(request);
    List<SmPost> publicPostList = smPostService.getDao().findAllByPrivacyOrderByIdDesc("PUBLIC");
    mv.addObject("publicPostList", publicPostList);
    return mv;
  }

  @Autowired
  SmPostService smPostService;

  @RequestMapping(value = "/Home/", method = RequestMethod.POST)
  public Object post(HttpServletRequest request, @ModelAttribute("smPost") SmPost post) {
    boolean isSuccessful = smPostService.savePostData(post);
    ModelAndView mv = (ModelAndView) this.service.prepareHomeData(request);
    List<SmPost> publicPostList = smPostService.getDao().findAllByPrivacyOrderByIdDesc("PUBLIC");
    mv.addObject("publicPostList", publicPostList);
    return mv;
  }
}
