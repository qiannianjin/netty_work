package com.yinghu.yinghu.sqlTest.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yinghu.yinghu.common.ApiController;
import com.yinghu.yinghu.common.Result;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yinghu.yinghu.sqlTest.entity.Category;
import com.yinghu.yinghu.sqlTest.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 分类(Category)表控制层
 *
 * @author makejava
 * @since 2023-05-01 10:20:07
 */
@RestController
@RequestMapping("category")
public class CategoryController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private CategoryService categoryService;

    /**
     * 分页查询所有数据
     *
     * @param page     分页对象
     * @param category 查询实体
     * @return 所有数据
     */
    @GetMapping
    public Result selectAll(Page<Category> page, Category category) {
        return Result.success(this.categoryService.page(page, new QueryWrapper<>(category)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public Result selectOne(@PathVariable Serializable id) {
        return Result.success(this.categoryService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param category 实体对象
     * @return 新增结果
     */
    @PostMapping
    public Result insert(@RequestBody Category category) {
        return Result.success(this.categoryService.save(category));
    }

    /**
     * 修改数据
     *
     * @param category 实体对象
     * @return 修改结果
     */
    @PutMapping
    public Result update(@RequestBody Category category) {
        return Result.success(this.categoryService.updateById(category));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public Result delete(@RequestParam("idList") List<Long> idList) {
        return Result.success(this.categoryService.removeByIds(idList));
    }
}

