package com.clasSee.api.controller;

import com.clasSee.api.dto.LessonInfoDto;
import com.clasSee.api.response.LessonInfoListRes;
import com.clasSee.api.response.UserSaltRes;
import com.clasSee.api.service.BookmarkService;
import com.clasSee.api.service.LessonService;
import com.clasSee.api.service.UserService;
import com.clasSee.common.model.response.BaseResponseBody;
import com.clasSee.db.entity.lesson.Lesson;
import com.clasSee.db.entity.user.User;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "북마크 API, 로그인 O", tags = {"Bookmark"})
@RestController
@RequestMapping("/api/v1/bookmarks")
public class BookmarkController {
    @Autowired
    UserService userService;
    @Autowired
    BookmarkService bookmarkService;

    @Autowired
    LessonService lessonService;

    @PostMapping("/{email}/{lessonId}")
    @ApiOperation(value = "북마크 등록, 로그인 O", notes = "<strong>회원 정보와 강의 정보</strong>를 통해 북마크를 등록한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 401, message = "등록 실패[ 이미 등록된 상태 ]"),
            @ApiResponse(code = 404, message = "사용자 없음"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<? extends BaseResponseBody> registerBookmark(@PathVariable String email, @PathVariable Long lessonId) {
        User user = userService.getUserByAuth(email);
        if (user == null) return ResponseEntity.status(200).body(BaseResponseBody.of(404, "USER NOT FOUND"));

        int result = bookmarkService.create(user.getAuth().getId(), lessonId);

        if(result == 0) return ResponseEntity.status(200).body(BaseResponseBody.of(401, "FAILED"));
        return ResponseEntity.status(200).body(BaseResponseBody.of(200, "SUCCESS"));
    }

    @DeleteMapping("/{email}/{lessonId}")
    @ApiOperation(value = "북마크 삭제, 로그인 O", notes = "<strong>회원 정보와 강의 정보</strong>를 통해 북마크를 삭제한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 401, message = "인증 실패"),
            @ApiResponse(code = 404, message = "사용자 없음"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<? extends BaseResponseBody> deleteBookmark(@PathVariable String email, @PathVariable Long lessonId) {
        bookmarkService.delete(email, lessonId);

        return ResponseEntity.status(200).body(BaseResponseBody.of(200,"성공"));

    }

    @GetMapping("/{email}")
    @ApiOperation(value = "북마크 리스트, 로그인 O", notes = "사용자의 북마크 리스트")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공", response = UserSaltRes.class),
            @ApiResponse(code = 401, message = "인증 실패", response = BaseResponseBody.class),
            @ApiResponse(code = 404, message = "사용자 없음", response = BaseResponseBody.class),
            @ApiResponse(code = 500, message = "서버 오류", response = BaseResponseBody.class)
    })
    public ResponseEntity<? extends BaseResponseBody> getBookmarkList(@PathVariable String email, @RequestParam int limit, @RequestParam int offset) {
        User user = userService.getUserByAuth(email);
        if(user == null) return ResponseEntity.status(404).body(BaseResponseBody.of(404, "USER NOT FOUND"));

        List<Lesson> bookmarkList = bookmarkService.getBookmarkList(user.getAuth().getId(), limit, offset);
        List<LessonInfoDto> lessonList = lessonService.setLessonProperty(bookmarkList, user);
        Long count = bookmarkService.getBookmarkCount(user.getAuth().getId());

        LessonInfoListRes res = LessonInfoListRes.builder()
                                                 .lessonInfoList(lessonList)
                                                 .count(count)
                                                 .build();

        return ResponseEntity.status(200).body(LessonInfoListRes.of(200, "SUCCESS", res));
    }

}
