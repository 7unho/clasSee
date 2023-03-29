package com.clasSee.api.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LessonSearchFilterDto {
    String keyword;
    Long minPrice;
    Long maxPrice;
    Long minStartTime;
    Long maxStartTime;
    String category;
    String dayOfWeek;
}
