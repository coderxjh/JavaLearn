package com.xiao.security.controller;

import com.xiao.security.entity.Users;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xjh
 * @create 2022-03-10 8:43
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("index")
    public String index() {
        return "hello index";
    }

    @GetMapping("update")
    //@Secured({"ROLE_sale", "ROLE_manager"})
    //@PreAuthorize("hasAnyAuthority('admins')")
    //@PostAuthorize("hasAnyAuthority('admins')")

    public String update() {
        System.out.println("update....");
        return "hello update";
    }

    @RequestMapping("getAll")
    @PreAuthorize("hasRole('ROLE_sale')")
    @PostFilter("filterObject.username == 'admin1'")
    public List<Users> getAllUser() {
        List<Users> list = new ArrayList<>();
        list.add(new Users(11, "admin1", "6666"));
        list.add(new Users(21, "admin2", "888"));
        System.out.println(list);
        return list;
    }
}