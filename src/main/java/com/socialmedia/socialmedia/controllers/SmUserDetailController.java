package com.socialmedia.socialmedia.controllers;

import com.socialmedia.socialmedia.roymvc.controller.RController;
import com.socialmedia.socialmedia.services.SmUserDetailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/UserDetail")
public class SmUserDetailController extends RController<SmUserDetailService> {
}
