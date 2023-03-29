package com.clasSee.api.response;

import com.clasSee.api.dto.LessonInfoDto;
import com.clasSee.common.model.response.BaseResponseBody;
        import io.swagger.annotations.ApiModel;
import lombok.*;

import java.util.List;

/*
- 강의명
- 소요시간
- 카테고리
- 이미지
- 별점 평균
*/
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ApiModel("LessonListGetResponse")
public class LessonInfoListRes extends BaseResponseBody{
    List<LessonInfoDto> lessonInfoList;
    long count;

    public static LessonInfoListRes of(Integer statusCode, String message, LessonInfoListRes lessonInfoListRes) {
        LessonInfoListRes res = new LessonInfoListRes();
        res.setStatusCode(statusCode);
        res.setMessage(message);
        res.setLessonInfoList(lessonInfoListRes.getLessonInfoList());
        res.setCount(lessonInfoListRes.getCount());
        return res;
    }
}

