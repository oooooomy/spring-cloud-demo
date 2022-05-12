package org.example.goods.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.common.api.Result;
import org.example.goods.model.entity.Goods;
import org.example.goods.service.GoodsService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Gao Yuan Ming
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Resource
    private GoodsService goodsService;

    @GetMapping("/findById")
    public Result<Goods> findById(@RequestParam Integer id) {
        return Result.ok(goodsService.findById(id));
    }

    @GetMapping("/findDeleted")
    @PreAuthorize("hasAuthority(T(org.example.goods.constant.GoodsAuthority).GOODS_FIND)")
    public Result<Page<Goods>> findDeleted(@RequestParam Long current, @RequestParam Long size) {
        return Result.ok(goodsService.listDeleted(current, size));
    }

    @GetMapping("/findNotDeleted")
    public Result<Page<Goods>> findNotDeleted(@RequestParam Long current, @RequestParam Long size) {
        return Result.ok(goodsService.listNotDeleted(current, size));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority(T(org.example.goods.constant.GoodsAuthority).GOODS_REMOVE)")
    public Result<?> remove(@PathVariable Integer id) throws Exception {
        goodsService.remove(id);
        return Result.ok();
    }

    @PostMapping("")
    @PreAuthorize("hasAuthority(T(org.example.goods.constant.GoodsAuthority).GOODS_SAVE)")
    public Result<?> save(@RequestBody Goods goods) {
        goodsService.save(goods);
        return Result.ok();
    }

    @PutMapping("")
    @PreAuthorize("hasAuthority(T(org.example.goods.constant.GoodsAuthority).GOODS_UPDATE)")
    public Result<?> update(@RequestBody Goods goods) {
        goodsService.update(goods);
        return Result.ok();
    }

}
