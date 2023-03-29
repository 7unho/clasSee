package com.clasSee.api.service;

import com.clasSee.api.request.OrdersRegistPostReq;
import com.clasSee.api.response.OrdersInfoGetRes;
import com.clasSee.common.exception.handler.UserException;

public interface OrdersService {

    OrdersInfoGetRes readOrders(String email, Long id) throws Exception;

    void createOrders(OrdersRegistPostReq ordersRegistPostReq) throws Exception;

    void chargePoint(String email, Long point) throws UserException;

    void deleteOrders(String email, Long openLessonId) throws Exception;
}
