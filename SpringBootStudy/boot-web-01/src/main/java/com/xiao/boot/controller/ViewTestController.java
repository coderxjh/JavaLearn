package com.xiao.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author simba@onlying.cn
 * @date 2021/6/24 13:45
 */
@Controller
public class ViewTestController {

    @GetMapping("/atguigu")
    public String atguigu(Model model){
        //model中的数据会被放在请求域中request.setAttribute("a",aa);
        model.addAttribute("msg","你好，guigu");
        model.addAttribute("link","http://www.baidu.com");
        return "success";
    }
}