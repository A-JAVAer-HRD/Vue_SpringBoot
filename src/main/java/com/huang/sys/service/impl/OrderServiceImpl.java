package com.huang.sys.service.impl;

import com.huang.sys.entity.Order;
import com.huang.sys.mapper.OrderMapper;
import com.huang.sys.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huangrd
 * @since 2023-07-01
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

}
