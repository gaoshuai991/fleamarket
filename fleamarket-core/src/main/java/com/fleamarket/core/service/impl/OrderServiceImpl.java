package com.fleamarket.core.service.impl;

import com.fleamarket.core.IMapper;
import com.fleamarket.core.mapper.OrderMapper;
import com.fleamarket.core.mapper.TreasureMapper;
import com.fleamarket.core.model.Order;
import com.fleamarket.core.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jackiegao on 2018/4/10.
 */
@Service
public class OrderServiceImpl extends BaseService<Order> implements OrderService {
	private final TreasureMapper tMapper;
	private final OrderMapper mapper;
	public Boolean addOrder(Order order){
		return mapper.addOrder(order);
	}
	@Autowired
	public OrderServiceImpl(OrderMapper mapper,TreasureMapper tMapper) {
		this.mapper = mapper;
		this.tMapper=tMapper;
	}
	@Override
	protected IMapper<Order> getMapper() {
		return mapper;
	}

	//通过用户ID获取订单信息和订单图片
	@Override
	public List<Order> selectByUserId(Integer userId) {
		return mapper.selectByUserId(userId);
	}

    @Override
    public List<Order> selectByKeyword(String column, String keyword) {
        return mapper.selectByKeyword(column, keyword);
    }

    @Override
    public List<Order> selectSales(Integer userId) {
        return mapper.selectSales(userId);
    }
}
