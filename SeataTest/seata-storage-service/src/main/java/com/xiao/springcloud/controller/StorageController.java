package com.xiao.springcloud.controller;

import com.xiao.springcloud.entity.CommonResult;
import com.xiao.springcloud.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author xjh
 * @create 2021-08-08 21:30
 */
@RestController
@RequestMapping("/storage")
public class StorageController {

    @Autowired
    private StorageService storageService;

    @PostMapping("/decrease")
    public CommonResult decrease(@RequestParam("productId") Long procuctId, @RequestParam("count") Integer count) {
        storageService.decrease(procuctId, count);
        return new CommonResult(200,"扣减库存成功");
    }
}
