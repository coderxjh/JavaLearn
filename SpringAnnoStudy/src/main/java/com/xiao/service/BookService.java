package com.xiao.service;

import com.xiao.dao.BookDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author simba@onlying.cn
 * @date 2021/5/30 14:48
 */
@Service
public class BookService {

    //    @Qualifier("bookDao")
//    @Autowired
    @Resource(name = "bookDao2")
    private BookDao bookDao;

    @Override
    public String toString() {
        return "BookService{" +
                "bookDao=" + bookDao +
                '}';
    }
}
