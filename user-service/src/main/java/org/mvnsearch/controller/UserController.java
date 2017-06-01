package org.mvnsearch.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * user controller
 *
 * @author linux_china
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @RequestMapping("/show")
    public String show() {
        return "jacky";
    }
}
