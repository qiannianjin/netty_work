package com.yinghu.yinghu.sqlTest.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yinghu.yinghu.sqlTest.dao.CategoryDao;
import com.yinghu.yinghu.sqlTest.entity.Category;
import com.yinghu.yinghu.sqlTest.service.CategoryService;
import org.springframework.stereotype.Service;

/**
 * 分类(Category)表服务实现类
 *
 * @author makejava
 * @since 2023-05-01 10:20:07
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, Category> implements CategoryService {

}

