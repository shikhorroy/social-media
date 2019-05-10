package com.socialmedia.socialmedia.roymvc.controller;

import com.socialmedia.socialmedia.roymvc.service.RService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class RController<T extends RService> {

  @Autowired
  protected T service;

  public T getService() {
    return service;
  }
}
