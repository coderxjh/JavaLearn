package com.xiao.bootwebadmin.controller;

import com.xiao.bootwebadmin.bean.Car;
import com.xiao.bootwebadmin.bean.User;
import com.xiao.bootwebadmin.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

/**
 * @author simba@onlying.cn
 * @date 2021/6/24 15:06
 */
@Controller
public class IndexController {


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    CarService carService;

//    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @ResponseBody
    @GetMapping("/car")
    public Car getCar(@RequestParam("id") Long id) {
        return carService.getCarById(id);
    }

    @ResponseBody
    @PostMapping("/car")
    public Car saveCar(Car car){
        carService.saveCar(car);
        return car;
    }

    @ResponseBody
    @GetMapping("/sql")
    public String queryFromDB() {
        Long aLong = jdbcTemplate.queryForObject("select count(*) from tb_car", Long.class);
        return aLong.toString();
    }


    /**
     * 来登录页
     *
     * @return
     */
    @GetMapping(value = {"/", "/login"})
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model) {
        if (!StringUtils.isEmpty(user.getUserName()) && "123456".equals(user.getPassWord())) {
            //把登录成功的用户保存起来
            session.setAttribute("loginUser", user);
            //登录成功，重定向到main.html
            return "redirect:/main.html";
        } else {
            model.addAttribute("msg", "账号密码错误");
            return "login";
        }
    }

    /**
     * 去main页面
     *
     * @return
     */
    @GetMapping("/main.html")
    public String mainPage(HttpSession session, Model model) {
//        User loginUser = (User) session.getAttribute("loginUser");
//        if (loginUser != null) {
//            return "main";
//        } else {
//            //回到登录页面
//            model.addAttribute("msg", "请重新登录");
//            return "login";
//        }
//        String main = stringRedisTemplate.opsForValue().get("/main.html");
//        String sql = stringRedisTemplate.opsForValue().get("/sql");
//        model.addAttribute("mainCount",main);
//        model.addAttribute("sqlCount",sql);
        return "main";
    }
}