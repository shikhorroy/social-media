package com.socialmedia.socialmedia.roymvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

public abstract class RService<T extends CrudRepository> {

  @Autowired
  protected T dao;

  public T getDao() {
    return this.dao;
  }
}
