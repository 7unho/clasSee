package com.ssafy.api.service;

import com.ssafy.api.request.OrdersRegistPostReq;
import com.ssafy.api.response.OrdersInfoGetRes;
import com.ssafy.common.exception.handler.OrdersException;
import com.ssafy.common.exception.handler.UserException;
import com.ssafy.db.entity.orders.Orders;

import java.util.List;

public interface OrdersService {

    OrdersInfoGetRes readOrders(String email, Long id) throws Exception;

    void createOrders(OrdersRegistPostReq ordersRegistPostReq) throws Exception;

    List<Orders> readOrdersList(String email, int offset, int limit) throws UserException;

    Long countOrders(String email);

    void chargePoint(String email, Long point) throws UserException;

    void deleteOrders(Long ordersId) throws OrdersException;
}
