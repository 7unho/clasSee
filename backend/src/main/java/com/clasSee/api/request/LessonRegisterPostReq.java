package com.clasSee.api.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.clasSee.db.entity.lesson.Checklist;
import com.clasSee.db.entity.lesson.Curriculum;
import com.clasSee.db.entity.lesson.Lesson;
import com.clasSee.db.entity.lesson.Pamphlet;
import com.clasSee.db.entity.user.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ApiModel("LessonRegisterPostReq")
public class LessonRegisterPostReq {
    @ApiModelProperty(name="email", example="강사 이메일")
    String email;
    @ApiModelProperty(name="name", example="강의명")
    String name;
    @ApiModelProperty(name="description", example="강의 소개")
    String description;
    @ApiModelProperty(name="category", example="강의 카테고리")
    String category;
    @ApiModelProperty(name="ckls_description", example="준비물 소개")
    String cklsDescription;

    @ApiModelProperty(name="kit_description", example="준비물 소개")
    String kitDescription;
    @ApiModelProperty(name="runningtime", example="강의 소요 시간")
    Long runningtime;
    @ApiModelProperty(name="maximum", example="강의 수강 인원")
    Long maximum;

    @ApiModelProperty(name="price", example="수강료")
    Long price;

    @ApiModelProperty(name="kit_price", example="키트 가격")
    Long kitPrice;



    @ApiModelProperty(name="checklist", example="준비물 리스트 [{img:파일명}]")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    List<Checklist> checkList;

    @ApiModelProperty(name="pamphlet", example="강의 소개 사진 리스트 [{img:파일명}]")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    List<Pamphlet> pamphletList;
    @ApiModelProperty(name="curriculum", example="커리큘럼 리스트 [{stage: 스테이지 숫자, description: 스테이지 설명}]")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    List<Curriculum> curriculumList;


    public Map<String, Object> getLessonInfoFromReq(User user, Long lessonId) {
        Map<String, Object> lessonInfo = new HashMap<>();

        Lesson lesson = Lesson.builder()
                .id(lessonId)
                .name(name)
                .description(description)
                .category(category)
                .maximum(maximum)
                .runningtime(runningtime)
                .price(price)
                .cklsDescription(cklsDescription)
                .kitPrice(kitPrice)
                .kitDescription(kitDescription)
                .user(user)
                .build();

        List<Checklist> checklists = this.checkList;
        List<Pamphlet> pamphlets = this.pamphletList;
        List<Curriculum> curriculums = this.curriculumList;

        lessonInfo.put("LESSON", lesson);
        lessonInfo.put("CHECKLISTS", checklists);
        lessonInfo.put("PAMPHLETS", pamphlets);
        lessonInfo.put("CURRICULUMS", curriculums);
        return lessonInfo;
    }

    public Map<String, Object> getLessonInfoFromReq(User user) {
        Map<String, Object> lessonInfo = new HashMap<>();

        Lesson lesson = Lesson.builder()
                .name(name)
                .description(description)
                .category(category)
                .maximum(maximum)
                .runningtime(runningtime)
                .price(price)
                .cklsDescription(cklsDescription)
                .kitPrice(kitPrice)
                .kitDescription(kitDescription)
                .user(user)
                .build();

        List<Checklist> checklists = this.checkList;
        List<Pamphlet> pamphlets = this.pamphletList;
        List<Curriculum> curriculums = this.curriculumList;

        lessonInfo.put("LESSON", lesson);
        lessonInfo.put("CHECKLISTS", checklists);
        lessonInfo.put("PAMPHLETS", pamphlets);
        lessonInfo.put("CURRICULUMS", curriculums);
        return lessonInfo;
    }
}
