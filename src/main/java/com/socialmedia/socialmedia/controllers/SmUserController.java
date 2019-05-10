package com.socialmedia.socialmedia.controllers;

import com.socialmedia.socialmedia.roymvc.controller.RController;
import com.socialmedia.socialmedia.services.SmUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
