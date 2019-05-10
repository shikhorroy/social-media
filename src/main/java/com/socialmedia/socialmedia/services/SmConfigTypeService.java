package com.socialmedia.socialmedia.services;

import com.socialmedia.socialmedia.daos.SmConfigTypeDao;
import com.socialmedia.socialmedia.roymvc.service.RService;
import org.springframework.stereotype.Service;

@Service
public class SmConfigTypeService extends RService<SmConfigTypeDao> {
  public Iterable list() {
    Iterable all = this.dao.findAll();
    return all;
  }
}
