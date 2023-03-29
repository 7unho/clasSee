package com.clasSee.api.response;

import com.clasSee.api.dto.OpenLessonInfoDto;
import com.clasSee.common.model.response.BaseResponseBody;
import io.swagger.annotations.ApiModel;
import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ApiModel("LessonSchedulesResponse")
public class LessonSchedulesRes extends BaseResponseBody {
    List<OpenLessonInfoDto> lessonSchedules;

    public static LessonSchedulesRes of(Integer statusCode, String message, LessonSchedulesRes lessonSchedulsRes) {
        LessonSchedulesRes res = new LessonSchedulesRes();
        res.setStatusCode(statusCode);
        res.setMessage(message);
        res.setLessonSchedules(lessonSchedulsRes.getLessonSchedules());
        return res;
    }
}
