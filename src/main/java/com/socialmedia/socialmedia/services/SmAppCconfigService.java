package com.socialmedia.socialmedia.services;

import com.socialmedia.socialmedia.daos.SmAppConfigDao;
import com.socialmedia.socialmedia.models.SmAppConfig;
import com.socialmedia.socialmedia.roymvc.service.RService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmAppCconfigService extends RService<SmAppConfigDao> {
  public List<SmAppConfig> listByConfigType(String configType) {
    List<SmAppConfig> list = this.dao.findBySmConfigTypeId(configType);
    return list;
  }
}
