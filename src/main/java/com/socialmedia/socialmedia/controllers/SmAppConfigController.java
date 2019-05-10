package com.socialmedia.socialmedia.controllers;

import com.socialmedia.socialmedia.roymvc.controller.RController;
import com.socialmedia.socialmedia.services.SmAppCconfigService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/AppConfiguration")
public class SmAppConfigController extends RController<SmAppCconfigService> {

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
  @RequestMapping(value = "/List/{configType}/", method = RequestMethod.GET)
  public Object listByConfigType(HttpServletRequest request, @PathVariable String configType) {
    return this.service.listByConfigType(configType);
  }
}
