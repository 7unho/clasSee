package com.ssafy.api.controller;

import com.ssafy.api.request.OrdersRegistPostReq;
import com.ssafy.api.request.PhotocardRegistPostReq;
import com.ssafy.api.response.NoticeInfoRes;
import com.ssafy.api.response.OrdersInfoGetRes;
import com.ssafy.api.response.OrdersListGetRes;
import com.ssafy.api.response.OrdersPageGetRes;
import com.ssafy.api.service.OrdersService;
import com.ssafy.common.exception.handler.LessonException;
import com.ssafy.common.exception.handler.OpenLessonException;
import com.ssafy.common.exception.handler.OrdersException;
import com.ssafy.common.exception.handler.UserException;
import com.ssafy.common.model.response.*;
import com.ssafy.db.entity.board.Notice;
import com.ssafy.db.entity.orders.Orders;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import retrofit2.http.Path;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Api(value = "주문 API", tags = {"Orders"})
@RestController
@RequestMapping("/api/v1/orders")
public class OrdersController {

    @Autowired
    OrdersService ordersService;

    @PostMapping()
    @ApiOperation(value = "주문 정보 등록, 로그인 O", notes = "주문 정보 입력 후 주문 생성, 잔액 부족 시 403")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공", response = BaseResponseBody.class),
            @ApiResponse(code = 401, message = "인증 실패", response = InvalidErrorResponseBody.class),
            @ApiResponse(code = 403, message = "거절", response = ForbiddenErrorResponseBody.class),
            @ApiResponse(code = 404, message = "해당 자료 없음", response = NotFoundErrorResponseBody.class),
            @ApiResponse(code = 409, message = "중복", response = DuplicateErrorResponseBody.class),
            @ApiResponse(code = 500, message = "서버 오류", response = ServerErrorResponseBody.class)
    })
    public ResponseEntity<? extends BaseResponseBody> registOrders(@RequestBody OrdersRegistPostReq ordersRegistPostReq) throws Exception {

        try{
            ordersService.createOrders(ordersRegistPostReq);
        } catch (UserException u){
            return ResponseEntity.status(404).body(BaseResponseBody.of(404,"user not found"));
        } catch (OpenLessonException o){
            return ResponseEntity.status(404).body(BaseResponseBody.of(404,"openLesson not found"));
        } catch (LessonException l){
            return ResponseEntity.status(404).body(BaseResponseBody.of(404,"lesson not found"));
        } catch (OrdersException o){
            return ResponseEntity.status(409).body(BaseResponseBody.of(409,"duplicated orders"));
        } catch(Exception e){
            return ResponseEntity.status(403).body(BaseResponseBody.of(403,"payment forbidden"));
        }

        return ResponseEntity.status(200).body(BaseResponseBody.of(200,"success"));
    }

    @PutMapping("/{email}/point")
    @ApiOperation(value = "포인트 충전, 로그인 O", notes = "유저 이메일과 금액 입력 후 포인트 충전")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공", response = BaseResponseBody.class),
            @ApiResponse(code = 401, message = "인증 실패", response = InvalidErrorResponseBody.class),
            @ApiResponse(code = 404, message = "해당 자료 없음", response = NotFoundErrorResponseBody.class),
            @ApiResponse(code = 500, message = "서버 오류", response = ServerErrorResponseBody.class)
    })
    public ResponseEntity<? extends BaseResponseBody> chargePoint(@PathVariable String email, @RequestParam Long point){

        try {
            ordersService.chargePoint(email, point);
        } catch (UserException u){
            return ResponseEntity.status(404).body(BaseResponseBody.of(404,"user not found"));
        }

        return ResponseEntity.status(200).body(BaseResponseBody.of(200,"success"));
    }


    @GetMapping()
    @ApiOperation(value = "주문페이지 정보, 로그인 O", notes = "주문 페이지에 들어왔을 때, 필요한 정보들을 반환")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공", response = OrdersInfoGetRes.class),
            @ApiResponse(code = 401, message = "인증 실패", response = InvalidErrorResponseBody.class),
            @ApiResponse(code = 404, message = "해당 자료 없음", response = NotFoundErrorResponseBody.class),
            @ApiResponse(code = 500, message = "서버 오류", response = ServerErrorResponseBody.class)
    })
    public ResponseEntity<?> getOrdersInfo(@RequestParam String email, @RequestParam Long openLessonId){

        OrdersInfoGetRes ordersInfoGetRes = new OrdersInfoGetRes();

        try {
            ordersInfoGetRes = ordersService.readOrders(email, openLessonId);
        } catch (OpenLessonException o){
            return ResponseEntity.status(404).body("openLesson not found");
        } catch (LessonException l){
            return ResponseEntity.status(404).body("lesson not found");
        } catch (UserException u){
            return ResponseEntity.status(404).body("user not found");
        } catch (Exception e){
            return ResponseEntity.status(404).body("unexpected exception");
        }

        return ResponseEntity.status(200).body(ordersInfoGetRes);
    }

    @GetMapping("/{email}/info")
    @ApiOperation(value = "주문 리스트, 로그인 O", notes = "내가 한 주문들을 확인")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공", response = OrdersPageGetRes.class),
            @ApiResponse(code = 401, message = "인증 실패", response = InvalidErrorResponseBody.class),
            @ApiResponse(code = 404, message = "해당 자료 없음", response = NotFoundErrorResponseBody.class),
            @ApiResponse(code = 500, message = "서버 오류", response = ServerErrorResponseBody.class)
    })
    public ResponseEntity<?> getOrdersListInfo(@PathVariable String email, @RequestParam int offset, @RequestParam int limit){

        List<Orders> ordersList = new ArrayList<>();

        try {
            ordersList = ordersService.readOrdersList(email, offset, limit);
        } catch (UserException u){
            return ResponseEntity.status(404).body("user not found");
        }

        List<OrdersListGetRes> ordersListGetResList =
                ordersList.stream().map(o -> new OrdersListGetRes(o)).collect(Collectors.toList());

        Long ordersCount = ordersService.countOrders(email);

        OrdersPageGetRes ordersPageGetRes = new OrdersPageGetRes();
        ordersPageGetRes.setCount(ordersCount);
        ordersPageGetRes.setOrdersListGetResList(ordersListGetResList);

        return ResponseEntity.status(200).body(ordersPageGetRes);

    }

    @DeleteMapping("/{ordersId}")
    @ApiOperation(value = "주문 취소, 로그인 O", notes = "주문 ID ")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공", response = BaseResponseBody.class),
            @ApiResponse(code = 401, message = "인증 실패", response = InvalidErrorResponseBody.class),
            @ApiResponse(code = 404, message = "해당 자료 없음", response = NotFoundErrorResponseBody.class),
            @ApiResponse(code = 500, message = "서버 오류", response = ServerErrorResponseBody.class)
    })
    public ResponseEntity<? extends BaseResponseBody> deleteOrders(@PathVariable Long ordersId){

        try {
            ordersService.deleteOrders(ordersId);
        } catch (OrdersException o){
            return ResponseEntity.status(404).body(BaseResponseBody.of(404, "orders not found"));
        }

        return ResponseEntity.status(200).body(BaseResponseBody.of(200,"success"));
    }

}
