package com.huang.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huang.sys.entity.User;
import com.huang.sys.service.IUserService;
import com.huang.sys.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author huangrd
 * @since 2023-06-20
 */
@Controller
@RequestMapping("/user")
//@CrossOrigin 跨域处理
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/all")
    @ResponseBody
    public Result<List<User>> getAllUser() {
        List<User> list = userService.list();
        return Result.success(list, "查询成功");
    }

    @PostMapping("/login")
    @ResponseBody
    public Result<Map<String, Object>> login(@RequestBody User user) {
        Map<String, Object> data = userService.login(user);
        if (data != null) {
            return Result.success(data);
        }
        return Result.fail(20002, "用户名密码错误");
    }

    @GetMapping("/info")
    @ResponseBody
    public Result<Map<String, Object>> getUserInfo(@RequestParam("token") String token) {
        Map<String, Object> data = userService.getUserInfo(token);
        if (data != null) {
            return Result.success(data);
        }
        return Result.fail(20003, "信息为空");
    }

    @PostMapping("/logout")
    @ResponseBody
    public Result<?> logout(@RequestHeader("X-Token") String token) {
        userService.logout(token);
        return Result.success();
    }

    @GetMapping("/list")
    @ResponseBody
    public Result<Map<String, Object>> getUserList(@RequestParam(value = "username", required = false) String username,
                                                  @RequestParam(value = "phone", required = false) String phone,
                                                  @RequestParam(value = "pageNo") Long pageNo,
                                                  @RequestParam(value = "pageSize") Long pageSize) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(StringUtils.hasLength(username), User::getUsername, username);
        wrapper.eq(StringUtils.hasLength(phone), User::getPhone, phone);
        wrapper.orderByDesc(User::getId);

        Page<User> page = new Page<>(pageNo, pageSize);
        userService.page(page, wrapper);

        Map<String, Object> data = new HashMap<>();
        data.put("total", page.getTotal());
        data.put("rows", page.getRecords());

        return Result.success(data);
    }

    @PostMapping
    @ResponseBody
    public Result<?> addUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user);
        return Result.success("新增用户成功");
    }

    @PutMapping
    @ResponseBody
    public Result<?> updateUser(@RequestBody User user) {
        user.setPassword(null);
        userService.updateById(user);
        return Result.success("修改用户成功");
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Result<User> getUserBuId(@PathVariable("id") Integer id) {
        User user = userService.getById(id);
        return Result.success(user);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public Result<?> deleteUserBuId(@PathVariable("id") Integer id) {
        userService.removeById(id);
        return Result.success("删除用户成功");
    }

}
