package com.clasSee.api.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("QnaAnswerRegistPostRequest")
public class QnaAnswerRegistPostReq {

    @ApiModelProperty(name="Answer 내용", example="답변 내용")
    String content;

//    @ApiModelProperty(name="qna 작성시간", example="qna_regtime")
//    Timestamp regtime;

    @ApiModelProperty(name="qna id", example="QnA 아이디")
    Long qna_id;
}
