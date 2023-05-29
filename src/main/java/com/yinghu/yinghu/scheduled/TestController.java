package com.yinghu.yinghu.scheduled;

import com.yinghu.yinghu.sqlTest.entity.Category;
import com.yinghu.yinghu.sqlTest.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author whz
 * @Date 2023/5/1 8:36
 * Version 1.0
 **/
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    CategoryService categoryService;


    @RequestMapping("/testLog")
    public String  testLog(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {


        List<Category> list = categoryService.list();

        System.out.println(list.toString());

        return list.toString();
    }

}
