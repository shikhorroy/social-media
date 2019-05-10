package com.socialmedia.socialmedia.controllers;

import com.socialmedia.socialmedia.models.SmConfigType;
import com.socialmedia.socialmedia.roymvc.controller.RController;
import com.socialmedia.socialmedia.services.SmConfigTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/ConfigurationType")
public class SmConfigTypeController extends RController<SmConfigTypeService> {

  @ResponseBody
  @RequestMapping(value = "/List/", method = RequestMethod.GET)
  public Object list(HttpServletRequest request) {
    Iterable list = this.service.list();
    return list;
  }

  @ResponseBody
  @RequestMapping(value = "/Add/", method = RequestMethod.GET)
  public Object add(HttpServletRequest request) {
    SmConfigType smConfigType = new SmConfigType();
    smConfigType.setId("locations");
    smConfigType.setName("Locations");
    smConfigType.setDescription("Locations");
    smConfigType.setValue("Locations");
    smConfigType.setInactive(0);
    smConfigType.setDeleted(0);
//    smConfigTypeDao.save(smConfigType);
    this.service.getDao().save(smConfigType);

    return "success";
  }
}
