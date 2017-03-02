package com.grc.gateway.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author 郭若辰
 * @create 2017-03-02 16:24
 */
@Controller
public class PageController {

    /*
    打开主页
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showIndex() {
        return "html/index.html";
    }

    /*
    打开其他页面
     */
    @RequestMapping(value = "/{page}", method =RequestMethod.GET)
    public String showPage(@PathVariable String page){
        return "html/"+page+".html";
    }
}
