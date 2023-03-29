package com.clasSee.api.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class OpenLessonInfoDto {
    Long openLessonId;
    Long lessonId;
    Long totalCount;
    Long attendCount;
    String startTime;
    String endTime;
}
