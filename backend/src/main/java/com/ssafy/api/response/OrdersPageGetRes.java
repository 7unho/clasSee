package com.ssafy.api.response;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@ApiModel("OrdersPageGetRes")
public class OrdersPageGetRes {

    Long count;
    List<OrdersListGetRes> ordersListGetResList;

}
