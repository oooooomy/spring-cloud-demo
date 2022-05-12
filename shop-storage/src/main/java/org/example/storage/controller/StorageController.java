package org.example.storage.controller;

import org.example.common.api.Result;
import org.example.storage.model.entity.Storage;
import org.example.storage.service.StorageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Gao Yuan Ming
 */
@RestController
@RequestMapping("/storage")
public class StorageController {

    @Resource
    private StorageService storageService;

    @PostMapping("")
    public Result<?> insert(@RequestBody Storage storage) {
        storageService.insert(storage);
        return Result.ok();
    }

    @GetMapping("/deduct")
    public Result<?> deduct(@RequestParam Integer goodId, @RequestParam Integer count) throws Exception {
        storageService.deduct(goodId, count);
        return Result.ok();
    }

    @GetMapping("/add")
    public Result<?> add(@RequestParam Integer goodId, @RequestParam Integer count) throws Exception {
        storageService.add(goodId, count);
        return Result.ok();
    }

}
