package com.xiao.controller;

import com.xiao.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author simba@onlying.cn
 * @date 2021/5/30 14:48
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;
}
