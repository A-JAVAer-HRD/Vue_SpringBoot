package com.huang.sys.service.impl;

import com.huang.sys.entity.Car;
import com.huang.sys.mapper.CarMapper;
import com.huang.sys.service.ICarService;
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
public class CarServiceImpl extends ServiceImpl<CarMapper, Car> implements ICarService {

}
