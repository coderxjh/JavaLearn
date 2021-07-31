package com.xiao.boot.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author simba@onlying.cn
 * @date 2021/6/18 14:38
 */
@RestController
public class ParameterTestController {


    @GetMapping("/car/{id}/owner/{username}")
    public Map<String, Object> getCar(@PathVariable("id") Integer id,
                                      @PathVariable("username") String username,
                                      @PathVariable Map<String, String> pv,
                                      @RequestHeader("User-Agent") String userAgent,
                                      @RequestHeader Map<String, String> headers,
                                      @RequestParam("age") Integer age,
                                      @RequestParam("inters") List<String> inters,
                                      @RequestParam Map<String, String> params,
                                      @CookieValue("Idea-4dc63f92") String ideacookie,
                                      @CookieValue("Idea-4dc63f92") Cookie cookie,
                                      HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
//        map.put("id", id);
//        map.put("name", username);
//        map.put("pv", pv);
//        map.put("userAgent", userAgent);
//        map.put("headers", headers);
        map.put("age", age);
        map.put("inters", inters);
        map.put("params", params);
        map.put("ideacookie", ideacookie);
        System.out.println(cookie.getName() + "-->" + cookie.getValue());
        Map<String, String[]> parameterMap = request.getParameterMap();
        System.out.println(parameterMap);
        return map;
    }

    @PostMapping("/save")
    public Map<String, Object> postMethod(@RequestBody String content) {
        Map<String, Object> map = new HashMap<>();
        map.put("content", content);
        return map;
    }

    //1、语法：   /cars/sell;low=34;brand=byd,audi,yd
    //2、SpringBoot默认是禁用了矩阵变量的功能
    //      手动开启:原理.对于路径的处理.UrlPathHelp进行解析.
    //              removeSemicolonContent(移除分号内容)支持矩阵变量
    //3.矩阵变量必须有url路径变量才能被解析
    @GetMapping("/cars/{path}")
    public Map<String, Object> carsSell(@MatrixVariable("low") Integer low,
                                        @MatrixVariable("brand") List<String> brand,
                                        @PathVariable("path") String path) {
        Map<String, Object> map = new HashMap<>();
        map.put("low", low);
        map.put("brand", brand);
        map.put("path", path);
        return map;
    }

    @GetMapping("/boss/{bossId}/{empId}")
    public Map<String, Object> boos(@MatrixVariable(name = "age", pathVar = "bossId") Integer boosAge,
                                    @MatrixVariable(name = "age", pathVar = "empId") Integer empAge,
                                    @PathVariable Map<String, String> pathMap) {
        Map<String, Object> map = new HashMap<>();
        map.put("boosAge", boosAge);
        map.put("empAge", empAge);
        map.put("path", pathMap);
        return map;
    }
}