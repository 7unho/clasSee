package com.clasSee.api.response;

import com.clasSee.common.model.response.BaseResponseBody;
import com.clasSee.db.entity.user.User;
import com.clasSee.db.entity.user.UserRole;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@ApiModel("UserInfoGetResponse")
public class UserInfoGetRes extends BaseResponseBody {

    String name;
    String nickname;
    String address;
    LocalDate birth;
    String phone;
    Long point;
    String img;
    String description;
    UserRole userRole;

    public UserInfoGetRes(User user){
        this.name = user.getName();
        this.nickname = user.getNickname();
        this.address = user.getAddress();
        this.birth = user.getBirth();
        this.phone = user.getPhone();
        this.point = user.getPoint();
        this.img = user.getImg();
        this.description = user.getDescription();
        this.userRole = user.getRole();
    }

}
