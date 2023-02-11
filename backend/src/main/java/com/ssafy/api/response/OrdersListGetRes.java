package com.ssafy.api.response;

import com.ssafy.db.entity.orders.Orders;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.PutMapping;

import java.time.LocalDateTime;

@Getter
@Setter
@ApiModel("OrdersInfoGetRes")
@NoArgsConstructor
public class OrdersListGetRes {

    Long id;

    String phone;

    String address;

    LocalDateTime regtime;

    Long price;

    String email;

    Long openLesson_id;

    public OrdersListGetRes(Orders orders){
        this.id = orders.getId();
        this.phone = orders.getPhone();
        this.address = orders.getAddress();
        this.regtime = orders.getRegTime();
        this.price = orders.getPrice();
        this.email = orders.getUser().getAuth().getEmail();
        this.openLesson_id = orders.getOpenLesson().getId();
    }

}
