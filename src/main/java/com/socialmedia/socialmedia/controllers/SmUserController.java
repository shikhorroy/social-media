package com.socialmedia.socialmedia.controllers;

import com.socialmedia.socialmedia.models.SmUser;
import com.socialmedia.socialmedia.roymvc.controller.RController;
import com.socialmedia.socialmedia.services.SmUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/User")
public class SmUserController extends RController<SmUserService> {

  @ResponseBody
  @RequestMapping(value = "/List/", method = RequestMethod.GET)
  public Object list(HttpServletRequest request) {
    return this.service.getDao().findAll();
  }

  @ResponseBody
  @RequestMapping(value = "/Edit/{id}/", method = RequestMethod.GET)
  public Object edit(HttpServletRequest request, @PathVariable Integer id) {
    return this.service.getDao().findById(id);
  }

  @ResponseBody
  @RequestMapping(value = "/Registration/List/", method = RequestMethod.GET)
  public Object registrationList(HttpServletRequest request) {
    return null;
  }

  @RequestMapping(value = "/Registration/Add/", method = RequestMethod.GET)
  public ModelAndView registrationAdd(HttpServletRequest request) {
    ModelAndView mv = new ModelAndView("registration/Add", "smUser", new SmUser());
    return mv;
  }

  @ResponseBody
  @RequestMapping(value = "/Registration/Add/", method = RequestMethod.POST)
  public Object registrationAddSave(HttpServletRequest request, @ModelAttribute("smUser") SmUser user) {
    return user;
  }

  @ResponseBody
  @RequestMapping(value = "/Registration/Edit/{id}/", method = RequestMethod.GET)
  public Object registrationEdit(HttpServletRequest request, @PathVariable String id) {
    return null;
  }
}
