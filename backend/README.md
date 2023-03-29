# 웹 기술 Backend

<!-- 필수 항목 -->

## 소개

웹 기술 프로젝트의 Backend 스켈레톤 코드

<!-- 필수 항목 -->

## 기술스택 및 라이브러리

| Project | Version | Description |
| ------- | ------- | ----------- |
| Java    | 1.8     |             |
| Gradle  | 6.7+    | Build Tool  |
| MySQL   |         |             |
|         |         |             |

<!-- 필수 항목 -->

## 개발 환경 구성

Windows 기준 개발 환경 구성 설명

1. OpenJDK 설치
   1. JDK 다운로드 사이트에서 1.8.x 설치 파일 다운로드 및 실행
      - Zulu OpenJDK: https://www.azul.com/downloads/?version=java-8-lts&package=jdk
      - OJDK Build: https://github.com/ojdkbuild/ojdkbuild
   2. 설치 후 명령 프롬프트(cmd) 확인
      ```
      > java -version
      ```
      출력 예)
      ```
      openjdk version "1.8.0_192"
      OpenJDK Runtime Environment (Zulu 8.33.0.1-win64) (build 1.8.0_192-b01)
      OpenJDK 64-Bit Server VM (Zulu 8.33.0.1-win64) (build 25.192-b01, mixed mode)
      ```

2. 데이터베이스 구성 *(이미 설치되어 있거나 원격 DB를 사용하는 경우 설치 부분 생략)*
   1. MySQL 다운로드 사이트에서 Community 설치 파일 다운로드 및 실행
      
      - https://dev.mysql.com/downloads/installer/
   2. MySQL Server, MySQL Shell을 포함하여 설치
   3. DB 및 계정 생성
      - MySQL Shell 실행
         ```
         MySQL  JS > \connect root@localhost
         MySQL  localhost:3306  JS > \sql
         ```
      - DB 생성
         ```sql
         create database IF NOT EXISTS `ssafy_web_db` collate utf8mb4_general_ci;
         ```
      - User 생성
         ```sql
         create user '사용자계정'@'localhost' identified by '비밀번호';
         grant all privileges on ssafy_web_db.* to 'ssafy'@'localhost';
         flush privileges;
         ```
      ```
      
      ```
   
3. IDE 설치 *(이미 설치되어 있거나 IntelliJ 등 다른 편집기를 사용할 경우 생략)*
   1. Eclipse 다운로드 사이트에서 Eclipse IDE 설치 파일 다운로드 및 실행
      - https://www.eclipse.org/downloads/
   2. Eclipse IDE for Enterprise Java and Web Developer 선택하여 설치
   3. Eclipse 실행 후 Encoding 변경
      - [Window] - [Preferences] - [General] - [Content Types] - [Text] - Default Encoding: UTF-8
      - [Window] - [Preferences] - [General] - [Workspace] - Text file encoding: UTF-8
   4. Spring Tools 3 설치
      - [Help] - [Eclipse Marketplace] - sts 검색 후 Spring Tools 3 설치
   5. Lombok 설치
      - [Help] - [Install New Software] - Work with: https://projectlombok.org/p2 입력 후 Lombok 설치 진행
   6. Eclipse 재시작   

4. 스켈레톤 다운로드 및 실행

   1. 프로젝트 다운로드
      ```
      git clone <repo URL>
      ```

   2. Eclipse의 [File] - [Import] - [Grade] - [Existing Gradle Project]에서 backend-java 폴더 선택 후 [Finish]
   
   3. Project Explorer에서 프로젝트 우클릭 후 [Spring] - [Add Spring Nature] 선택
      
   4. src/main/resources/application.properties 수정
   
      ```
   spring.datasource.hikari.username=<사용자 계정>
      spring.datasource.hikari.password=<비밀번호>
      ```
   
   5. [Gradle Tasks] 탭의 [Rub Gradle Tasks] 선택하여 실행




## 디렉토리 구조

```
.
📦backend
 ┣ 📂.gradle
 ┃ ┣ 📂6.7
 ┃ ┃ ┣ 📂executionHistory
 ┃ ┃ ┃ ┣ 📜executionHistory.bin
 ┃ ┃ ┃ ┗ 📜executionHistory.lock
 ┃ ┃ ┣ 📂fileChanges
 ┃ ┃ ┃ ┗ 📜last-build.bin
 ┃ ┃ ┣ 📂fileHashes
 ┃ ┃ ┃ ┣ 📜fileHashes.bin
 ┃ ┃ ┃ ┗ 📜fileHashes.lock
 ┃ ┃ ┣ 📂javaCompile
 ┃ ┃ ┃ ┣ 📜classAnalysis.bin
 ┃ ┃ ┃ ┣ 📜javaCompile.lock
 ┃ ┃ ┃ ┗ 📜taskHistory.bin
 ┃ ┃ ┣ 📂vcsMetadata-1
 ┃ ┃ ┗ 📜gc.properties
 ┃ ┣ 📂buildOutputCleanup
 ┃ ┃ ┣ 📜buildOutputCleanup.lock
 ┃ ┃ ┣ 📜cache.properties
 ┃ ┃ ┗ 📜outputFiles.bin
 ┃ ┣ 📂checksums
 ┃ ┃ ┣ 📜checksums.lock
 ┃ ┃ ┣ 📜md5-checksums.bin
 ┃ ┃ ┗ 📜sha1-checksums.bin
 ┃ ┣ 📂configuration-cache
 ┃ ┃ ┗ 📜gc.properties
 ┃ ┗ 📂vcs-1
 ┃ ┃ ┗ 📜gc.properties
 ┣ 📂.idea
 ┃ ┣ 📜.gitignore
 ┃ ┣ 📜.name
 ┃ ┣ 📜compiler.xml
 ┃ ┣ 📜gradle.xml
 ┃ ┣ 📜jarRepositories.xml
 ┃ ┣ 📜misc.xml
 ┃ ┣ 📜uiDesigner.xml
 ┃ ┣ 📜vcs.xml
 ┃ ┗ 📜workspace.xml
 ┣ 📂bin
 ┃ ┣ 📂default
 ┃ ┃ ┗ 📂com
 ┃ ┃ ┃ ┗ 📂clasSee
 ┃ ┃ ┃ ┃ ┗ 📂db
 ┃ ┃ ┃ ┃ ┃ ┗ 📂entity
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂board
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QArticle.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QComment.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QLikes.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QNotice.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜QPhotocard.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂lesson
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QChecklist.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QCurriculum.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QLesson.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QOpenLesson.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QPamphlet.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜QReview.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂orders
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜QOrders.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂qna
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QQna.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜QQnaAnswer.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂user
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QAuth.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QBookmark.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QNotification.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜QUser.class
 ┃ ┣ 📂generated-sources
 ┃ ┃ ┗ 📂annotations
 ┃ ┃ ┃ ┗ 📂com
 ┃ ┃ ┃ ┃ ┗ 📂clasSee
 ┃ ┃ ┃ ┃ ┃ ┗ 📂db
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂entity
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂board
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QArticle.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QComment.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QLikes.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QNotice.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜QPhotocard.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂lesson
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QChecklist.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QCurriculum.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QLesson.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QOpenLesson.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QPamphlet.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜QReview.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂orders
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜QOrders.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂qna
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QQna.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜QQnaAnswer.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂user
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QAuth.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QBookmark.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QNotification.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜QUser.java
 ┃ ┗ 📂main
 ┃ ┃ ┣ 📂com
 ┃ ┃ ┃ ┗ 📂clasSee
 ┃ ┃ ┃ ┃ ┣ 📂api
 ┃ ┃ ┃ ┃ ┃ ┣ 📂controller
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ArticleController.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AuthController.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BookmarkController.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜EmailController.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LessonController.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜NoticeController.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OpenViduController.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OrdersController.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PhotocardController.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ReviewController.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜StudentController.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜TeacherController.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserController.class
 ┃ ┃ ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AttendLessonInfoDto$AttendLessonInfoDtoBuilder.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AttendLessonInfoDto$AttendLessonInfoDtoBuilderImpl.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AttendLessonInfoDto.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AttendOpenLessonInfoDto$AttendOpenLessonInfoDtoBuilder.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AttendOpenLessonInfoDto$AttendOpenLessonInfoDtoBuilderImpl.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AttendOpenLessonInfoDto.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AttendStuDto.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AttendTeacherDto.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜KakaoUserDto$KakaoUserDtoBuilder.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜KakaoUserDto.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LessonInfoDto$LessonInfoDtoBuilder.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LessonInfoDto.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LessonSearchFilterDto$LessonSearchFilterDtoBuilder.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LessonSearchFilterDto.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OpenLessonInfoDto$OpenLessonInfoDtoBuilder.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OpenLessonInfoDto.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserEmailPwDto$UserEmailPwDtoBuilder.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserEmailPwDto.class
 ┃ ┃ ┃ ┃ ┃ ┣ 📂request
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ArticleRegisterPostReq.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ArticleUpdatePutReq.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BookmarkRegisterReq.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LessonRegisterPostReq.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LessonScheduleRegisterPostReq.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜NoticeRegisterPostReq.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜NoticeUpdatePutReq.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OrdersRegistPostReq.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PhotocardRegistPostReq.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QnaAnswerRegistPostReq.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QnaRegisterPostReq.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QnaUpdatePutReq.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ReviewRegistPostReq.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ReviewUpdatePutReq.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserFindPwPostReq$UserFindPwPostReqBuilder.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserFindPwPostReq.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserLoginPostReq.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserLogoutPostReq.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserRegisterPostReq.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserUpdatePwPutReq.class
 ┃ ┃ ┃ ┃ ┃ ┣ 📂response
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ArticleInfoGetRes.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ArticleListGetRes.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AttendInfoRes$AttendInfoResBuilder.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AttendInfoRes.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AttendLessonInfoListRes$AttendLessonInfoListResBuilder.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AttendLessonInfoListRes.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LessonDetailsRes$LessonDetailsResBuilder.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LessonDetailsRes.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LessonIdRes$LessonIdResBuilder.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LessonIdRes.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LessonInfoListRes$LessonInfoListResBuilder.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LessonInfoListRes.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LessonSchedulesRes$LessonSchedulesResBuilder.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LessonSchedulesRes.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜NoticeInfoRes.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜NoticeListRes.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OrdersInfoGetRes.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PageGetRes.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PhotocardListGetRes.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PhotocardPageGetRes.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QnaInfoGetRes.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QnaListGetRes.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ReviewListGetRes.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ReviewPageGetRes.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ReviewRegistRes.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserEmailCheckGetRes.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserInfoGetRes.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserLoginPostRes$UserLoginPostResBuilder.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserLoginPostRes.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserRes.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserSaltRes$UserSaltResBuilder.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserSaltRes.class
 ┃ ┃ ┃ ┃ ┃ ┗ 📂service
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ArticleService.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ArticleServiceImpl.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AuthService.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AuthServiceImpl.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BookmarkService.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BookmarkServiceImpl.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜EmailService.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜EmailServiceImpl.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜KakaoService.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LessonService.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LessonServiceImpl.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜NoticeService.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜NoticeServiceImpl.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OrdersService.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OrdersServiceImpl.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PhotocardService.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PhotocardServiceImpl.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QnaService.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QnaServiceImpl.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜RedisService.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ReviewService.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ReviewServiceImpl.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜TeacherService.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜TeacherServiceImpl.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserService.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserServiceImpl.class
 ┃ ┃ ┃ ┃ ┣ 📂common
 ┃ ┃ ┃ ┃ ┃ ┣ 📂auth
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ClasseeUserDetailService.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ClasseeUserDetails.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜JwtAuthenticationFilter.class
 ┃ ┃ ┃ ┃ ┃ ┣ 📂exception
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂handler
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LessonException.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LikesException.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MaximumException.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜NotFoundHandler.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OpenLessonException.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OrdersException.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PhotocardException.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ReviewException.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserException.class
 ┃ ┃ ┃ ┃ ┃ ┣ 📂model
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂response
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BaseResponseBody.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜DuplicateErrorResponseBody.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ForbiddenErrorResponseBody.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜InvalidErrorResponseBody.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜NotFoundErrorResponseBody.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ServerErrorResponseBody.class
 ┃ ┃ ┃ ┃ ┃ ┗ 📂util
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜JwtTokenUtil.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ResponseBodyWriteUtil.class
 ┃ ┃ ┃ ┃ ┣ 📂config
 ┃ ┃ ┃ ┃ ┃ ┣ 📜EmailConfig.class
 ┃ ┃ ┃ ┃ ┃ ┣ 📜JpaConfig.class
 ┃ ┃ ┃ ┃ ┃ ┣ 📜RedisConfig.class
 ┃ ┃ ┃ ┃ ┃ ┣ 📜SecurityConfig.class
 ┃ ┃ ┃ ┃ ┃ ┣ 📜SwaggerConfig.class
 ┃ ┃ ┃ ┃ ┃ ┗ 📜WebMvcConfig.class
 ┃ ┃ ┃ ┃ ┣ 📂db
 ┃ ┃ ┃ ┃ ┃ ┣ 📂entity
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂board
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Article$ArticleBuilder.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Article.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Comment.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Likes$LikesBuilder.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Likes.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Notice$NoticeBuilder.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Notice.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Photocard$PhotocardBuilder.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜Photocard.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂lesson
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Category.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Checklist.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Curriculum.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Lesson$LessonBuilder.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Lesson.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OpenLesson$OpenLessonBuilder.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OpenLesson.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Pamphlet.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Review$ReviewBuilder.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜Review.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂orders
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Orders$OrdersBuilder.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜Orders.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂qna
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Qna$QnaBuilder.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Qna.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QnaAnswer$QnaAnswerBuilder.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜QnaAnswer.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂user
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Auth$AuthBuilder.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Auth.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Bookmark$BookmarkBuilder.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Bookmark.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Notification$NotificationBuilder.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Notification.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜User$UserBuilder.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜User.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserRole.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserType.class
 ┃ ┃ ┃ ┃ ┃ ┗ 📂repository
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ArticleRepositorySupport.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AuthRepository.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AuthRepositorySupport.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BookmarkRepository.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BookmarkRepositorySupport.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CheckListRepositorySupport.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CurriculumRepositorySupport.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LessonRepository.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LessonRepositorySupport.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜NoticeRepositorySupport.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OrdersRepositorySupport.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PamphletRepositorySupport.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PhotocardRepositorySupport.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QnaRepositorySupport.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ReviewRepositorySupport.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserRepository.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserRepositorySupport.class
 ┃ ┃ ┃ ┃ ┗ 📜ClasSeeApplication.class
 ┃ ┃ ┣ 📂dist
 ┃ ┃ ┃ ┣ 📂css
 ┃ ┃ ┃ ┃ ┣ 📜app.80f35f85.css
 ┃ ┃ ┃ ┃ ┗ 📜chunk-vendors.b8a9ac7a.css
 ┃ ┃ ┃ ┣ 📂fonts
 ┃ ┃ ┃ ┃ ┣ 📜SpoqaHanSansNeo-Bold.48d433af.ttf
 ┃ ┃ ┃ ┃ ┣ 📜SpoqaHanSansNeo-Medium.d92f35b6.ttf
 ┃ ┃ ┃ ┃ ┣ 📜SpoqaHanSansNeo-Regular.998877fd.ttf
 ┃ ┃ ┃ ┃ ┣ 📜element-icons.abe71f7d.ttf
 ┃ ┃ ┃ ┃ ┗ 📜element-icons.d9491be2.woff
 ┃ ┃ ┃ ┣ 📂img
 ┃ ┃ ┃ ┃ ┗ 📜ssafy-logo.74eec4f3.png
 ┃ ┃ ┃ ┣ 📂js
 ┃ ┃ ┃ ┃ ┣ 📜app.b20b4136.js
 ┃ ┃ ┃ ┃ ┣ 📜app.b20b4136.js.map
 ┃ ┃ ┃ ┃ ┣ 📜chunk-vendors.16028549.js
 ┃ ┃ ┃ ┃ ┗ 📜chunk-vendors.16028549.js.map
 ┃ ┃ ┃ ┣ 📜favicon.ico
 ┃ ┃ ┃ ┗ 📜index.html
 ┃ ┃ ┣ 📜application-secret.properties
 ┃ ┃ ┗ 📜application.properties
 ┣ 📂build
 ┃ ┣ 📂classes
 ┃ ┃ ┗ 📂java
 ┃ ┃ ┃ ┗ 📂main
 ┃ ┃ ┃ ┃ ┗ 📂com
 ┃ ┃ ┃ ┃ ┃ ┗ 📂clasSee
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂api
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂controller
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ArticleController.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AuthController.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BookmarkController.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜EmailController.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LessonController.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜NoticeController.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OpenViduController.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OrdersController.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PhotocardController.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ReviewController.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜StudentController.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜TeacherController.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserController.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AttendLessonInfoDto$1.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AttendLessonInfoDto$AttendLessonInfoDtoBuilder.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AttendLessonInfoDto$AttendLessonInfoDtoBuilderImpl.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AttendLessonInfoDto.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AttendOpenLessonInfoDto$1.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AttendOpenLessonInfoDto$AttendOpenLessonInfoDtoBuilder.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AttendOpenLessonInfoDto$AttendOpenLessonInfoDtoBuilderImpl.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AttendOpenLessonInfoDto.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AttendStuDto.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AttendTeacherDto.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜KakaoUserDto$KakaoUserDtoBuilder.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜KakaoUserDto.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LessonInfoDto$LessonInfoDtoBuilder.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LessonInfoDto.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LessonSearchFilterDto$LessonSearchFilterDtoBuilder.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LessonSearchFilterDto.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OpenLessonInfoDto$OpenLessonInfoDtoBuilder.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OpenLessonInfoDto.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserEmailPwDto$UserEmailPwDtoBuilder.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserEmailPwDto.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂request
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ArticleRegisterPostReq.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ArticleUpdatePutReq.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BookmarkRegisterReq.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LessonRegisterPostReq.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LessonScheduleRegisterPostReq.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜NoticeRegisterPostReq.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜NoticeUpdatePutReq.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OrdersRegistPostReq.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PhotocardRegistPostReq.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QnaAnswerRegistPostReq.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QnaRegisterPostReq.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QnaUpdatePutReq.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ReviewRegistPostReq.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ReviewUpdatePutReq.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserFindPwPostReq$UserFindPwPostReqBuilder.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserFindPwPostReq.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserLoginPostReq.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserLogoutPostReq.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserRegisterPostReq.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserUpdatePwPutReq.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂response
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ArticleInfoGetRes.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ArticleListGetRes.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AttendInfoRes$AttendInfoResBuilder.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AttendInfoRes.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AttendLessonInfoListRes$AttendLessonInfoListResBuilder.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AttendLessonInfoListRes.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LessonDetailsRes$LessonDetailsResBuilder.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LessonDetailsRes.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LessonIdRes$LessonIdResBuilder.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LessonIdRes.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LessonInfoListRes$LessonInfoListResBuilder.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LessonInfoListRes.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LessonSchedulesRes$LessonSchedulesResBuilder.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LessonSchedulesRes.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜NoticeInfoRes.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜NoticeListRes.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OrdersInfoGetRes.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PageGetRes.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PhotocardListGetRes.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PhotocardPageGetRes.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QnaInfoGetRes.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QnaListGetRes.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ReviewListGetRes.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ReviewPageGetRes.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ReviewRegistRes.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserEmailCheckGetRes.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserInfoGetRes.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserLoginPostRes$UserLoginPostResBuilder.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserLoginPostRes.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserRes.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserSaltRes$UserSaltResBuilder.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserSaltRes.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂service
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ArticleService.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ArticleServiceImpl.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AuthService.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AuthServiceImpl.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BookmarkService.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BookmarkServiceImpl.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜EmailService.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜EmailServiceImpl.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜KakaoService.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LessonService.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LessonServiceImpl.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜NoticeService.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜NoticeServiceImpl.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OrdersService.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OrdersServiceImpl.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PhotocardService.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PhotocardServiceImpl.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QnaService.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QnaServiceImpl.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜RedisService.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ReviewService.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ReviewServiceImpl.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜TeacherService.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜TeacherServiceImpl.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserService.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserServiceImpl.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂common
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂auth
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜JwtAuthenticationFilter.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜SsafyUserDetailService.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜SsafyUserDetails.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂exception
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂handler
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LessonException.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LikesException.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MaximumException.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜NotFoundHandler.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OpenLessonException.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OrdersException.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PhotocardException.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ReviewException.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserException.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂model
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂response
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BaseResponseBody.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜DuplicateErrorResponseBody.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ForbiddenErrorResponseBody.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜InvalidErrorResponseBody.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜NotFoundErrorResponseBody.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ServerErrorResponseBody.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂util
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜JwtTokenUtil.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ResponseBodyWriteUtil.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂config
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜EmailConfig.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜JpaConfig.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜RedisConfig.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜SecurityConfig.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜SwaggerConfig.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜WebMvcConfig.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂db
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂entity
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂board
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Article$ArticleBuilder.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Article.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Comment.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Likes$LikesBuilder.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Likes.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Notice$NoticeBuilder.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Notice.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Photocard$PhotocardBuilder.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Photocard.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QArticle.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QComment.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QLikes.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QNotice.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜QPhotocard.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂lesson
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Category.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Checklist.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Curriculum.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Lesson$LessonBuilder.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Lesson.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OpenLesson$OpenLessonBuilder.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OpenLesson.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Pamphlet.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QChecklist.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QCurriculum.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QLesson.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QOpenLesson.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QPamphlet.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QReview.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Review$ReviewBuilder.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜Review.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂orders
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Orders$OrdersBuilder.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Orders.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜QOrders.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂qna
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QQna.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QQnaAnswer.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Qna$QnaBuilder.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Qna.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QnaAnswer$QnaAnswerBuilder.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜QnaAnswer.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂user
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Auth$AuthBuilder.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Auth.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Bookmark$BookmarkBuilder.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Bookmark.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Notification$NotificationBuilder.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Notification.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QAuth.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QBookmark.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QNotification.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QUser.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜User$UserBuilder.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜User.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserRole.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserType.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂repository
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ArticleRepositorySupport.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AuthRepository.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AuthRepositorySupport.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BookmarkRepository.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BookmarkRepositorySupport.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CheckListRepositorySupport.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CurriculumRepositorySupport.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LessonRepository.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LessonRepositorySupport.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜NoticeRepositorySupport.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OrdersRepositorySupport.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PamphletRepositorySupport.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PhotocardRepositorySupport.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QnaRepositorySupport.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ReviewRepositorySupport.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserRepository.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserRepositorySupport.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ClasSeeApplication.class
 ┃ ┣ 📂generated
 ┃ ┃ ┗ 📂sources
 ┃ ┃ ┃ ┣ 📂annotationProcessor
 ┃ ┃ ┃ ┃ ┗ 📂java
 ┃ ┃ ┃ ┃ ┃ ┗ 📂main
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂com
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂clasSee
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂db
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂entity
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂board
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QArticle.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QComment.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QLikes.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QNotice.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜QPhotocard.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂lesson
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QChecklist.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QCurriculum.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QLesson.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QOpenLesson.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QPamphlet.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜QReview.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂orders
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜QOrders.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂qna
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QQna.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜QQnaAnswer.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂user
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QAuth.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QBookmark.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QNotification.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜QUser.java
 ┃ ┃ ┃ ┗ 📂headers
 ┃ ┃ ┃ ┃ ┗ 📂java
 ┃ ┃ ┃ ┃ ┃ ┗ 📂main
 ┃ ┣ 📂resources
 ┃ ┃ ┗ 📂main
 ┃ ┃ ┃ ┣ 📂dist
 ┃ ┃ ┃ ┃ ┣ 📂css
 ┃ ┃ ┃ ┃ ┃ ┣ 📜app.80f35f85.css
 ┃ ┃ ┃ ┃ ┃ ┗ 📜chunk-vendors.b8a9ac7a.css
 ┃ ┃ ┃ ┃ ┣ 📂fonts
 ┃ ┃ ┃ ┃ ┃ ┣ 📜SpoqaHanSansNeo-Bold.48d433af.ttf
 ┃ ┃ ┃ ┃ ┃ ┣ 📜SpoqaHanSansNeo-Medium.d92f35b6.ttf
 ┃ ┃ ┃ ┃ ┃ ┣ 📜SpoqaHanSansNeo-Regular.998877fd.ttf
 ┃ ┃ ┃ ┃ ┃ ┣ 📜element-icons.abe71f7d.ttf
 ┃ ┃ ┃ ┃ ┃ ┗ 📜element-icons.d9491be2.woff
 ┃ ┃ ┃ ┃ ┣ 📂img
 ┃ ┃ ┃ ┃ ┃ ┗ 📜ssafy-logo.74eec4f3.png
 ┃ ┃ ┃ ┃ ┣ 📂js
 ┃ ┃ ┃ ┃ ┃ ┣ 📜app.b20b4136.js
 ┃ ┃ ┃ ┃ ┃ ┣ 📜app.b20b4136.js.map
 ┃ ┃ ┃ ┃ ┃ ┣ 📜chunk-vendors.16028549.js
 ┃ ┃ ┃ ┃ ┃ ┗ 📜chunk-vendors.16028549.js.map
 ┃ ┃ ┃ ┃ ┣ 📜favicon.ico
 ┃ ┃ ┃ ┃ ┗ 📜index.html
 ┃ ┃ ┃ ┣ 📜application-secret.properties
 ┃ ┃ ┃ ┗ 📜application.properties
 ┃ ┗ 📂tmp
 ┃ ┃ ┗ 📂compileJava
 ┃ ┃ ┃ ┗ 📜source-classes-mapping.txt
 ┣ 📂gradle
 ┃ ┗ 📂wrapper
 ┃ ┃ ┣ 📜gradle-wrapper.jar
 ┃ ┃ ┗ 📜gradle-wrapper.properties
 ┣ 📂src
 ┃ ┗ 📂main
 ┃ ┃ ┣ 📂generated
 ┃ ┃ ┃ ┗ 📂com
 ┃ ┃ ┃ ┃ ┗ 📂ssafy
 ┃ ┃ ┃ ┃ ┃ ┗ 📂db
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂entity
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QBaseEntity.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜QUser.java
 ┃ ┃ ┣ 📂java
 ┃ ┃ ┃ ┗ 📂com
 ┃ ┃ ┃ ┃ ┗ 📂clasSee
 ┃ ┃ ┃ ┃ ┃ ┣ 📂api
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂controller
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ArticleController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AuthController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BookmarkController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜EmailController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LessonController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜NoticeController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OpenViduController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OrdersController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PhotocardController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ReviewController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜StudentController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜TeacherController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AttendLessonInfoDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AttendOpenLessonInfoDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AttendStuDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AttendTeacherDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜KakaoUserDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LessonInfoDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LessonSearchFilterDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OpenLessonInfoDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserEmailPwDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂request
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ArticleRegisterPostReq.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ArticleUpdatePutReq.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BookmarkRegisterReq.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LessonRegisterPostReq.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LessonScheduleRegisterPostReq.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜NoticeRegisterPostReq.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜NoticeUpdatePutReq.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OrdersRegistPostReq.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PhotocardRegistPostReq.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QnaAnswerRegistPostReq.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QnaRegisterPostReq.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QnaUpdatePutReq.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ReviewRegistPostReq.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ReviewUpdatePutReq.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserFindPwPostReq.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserLoginPostReq.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserLogoutPostReq.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserRegisterPostReq.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserUpdatePwPutReq.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂response
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ArticleInfoGetRes.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ArticleListGetRes.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AttendInfoRes.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AttendLessonInfoListRes.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LessonDetailsRes.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LessonIdRes.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LessonInfoListRes.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LessonSchedulesRes.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜NoticeInfoRes.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜NoticeListRes.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OrdersInfoGetRes.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PageGetRes.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PhotocardListGetRes.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PhotocardPageGetRes.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QnaInfoGetRes.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QnaListGetRes.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ReviewListGetRes.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ReviewPageGetRes.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ReviewRegistRes.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserEmailCheckGetRes.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserInfoGetRes.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserLoginPostRes.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserRes.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserSaltRes.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂service
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ArticleService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ArticleServiceImpl.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AuthService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AuthServiceImpl.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BookmarkService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BookmarkServiceImpl.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜EmailService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜EmailServiceImpl.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜KakaoService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LessonService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LessonServiceImpl.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜NoticeService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜NoticeServiceImpl.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OrdersService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OrdersServiceImpl.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PhotocardService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PhotocardServiceImpl.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QnaService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QnaServiceImpl.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜RedisService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ReviewService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ReviewServiceImpl.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜TeacherService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜TeacherServiceImpl.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserServiceImpl.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂common
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂auth
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ClasseeUserDetailService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ClasseeUserDetails.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜JwtAuthenticationFilter.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂exception
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂handler
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LessonException.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LikesException.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MaximumException.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜NotFoundHandler.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OpenLessonException.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OrdersException.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PhotocardException.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ReviewException.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserException.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂model
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂response
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BaseResponseBody.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜DuplicateErrorResponseBody.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ForbiddenErrorResponseBody.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜InvalidErrorResponseBody.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜NotFoundErrorResponseBody.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ServerErrorResponseBody.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂util
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜JwtTokenUtil.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ResponseBodyWriteUtil.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂config
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜EmailConfig.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜JpaConfig.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜RedisConfig.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜SecurityConfig.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜SwaggerConfig.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜WebMvcConfig.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂db
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂entity
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂board
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Article.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Comment.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Likes.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Notice.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜Photocard.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂lesson
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Category.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Checklist.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Curriculum.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Lesson.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OpenLesson.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Pamphlet.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜Review.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂orders
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜Orders.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂qna
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Qna.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜QnaAnswer.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂user
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Auth.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Bookmark.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Notification.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜User.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserRole.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserType.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂repository
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ArticleRepositorySupport.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AuthRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AuthRepositorySupport.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BookmarkRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BookmarkRepositorySupport.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CheckListRepositorySupport.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CurriculumRepositorySupport.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LessonRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LessonRepositorySupport.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜NoticeRepositorySupport.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OrdersRepositorySupport.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PamphletRepositorySupport.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PhotocardRepositorySupport.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QnaRepositorySupport.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ReviewRepositorySupport.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserRepositorySupport.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📜ClasSeeApplication.java
 ┃ ┃ ┗ 📂resources
 ┃ ┃ ┃ ┣ 📂dist
 ┃ ┃ ┃ ┃ ┣ 📂css
 ┃ ┃ ┃ ┃ ┃ ┣ 📜app.80f35f85.css
 ┃ ┃ ┃ ┃ ┃ ┗ 📜chunk-vendors.b8a9ac7a.css
 ┃ ┃ ┃ ┃ ┣ 📂fonts
 ┃ ┃ ┃ ┃ ┃ ┣ 📜SpoqaHanSansNeo-Bold.48d433af.ttf
 ┃ ┃ ┃ ┃ ┃ ┣ 📜SpoqaHanSansNeo-Medium.d92f35b6.ttf
 ┃ ┃ ┃ ┃ ┃ ┣ 📜SpoqaHanSansNeo-Regular.998877fd.ttf
 ┃ ┃ ┃ ┃ ┃ ┣ 📜element-icons.abe71f7d.ttf
 ┃ ┃ ┃ ┃ ┃ ┗ 📜element-icons.d9491be2.woff
 ┃ ┃ ┃ ┃ ┣ 📂img
 ┃ ┃ ┃ ┃ ┃ ┗ 📜ssafy-logo.74eec4f3.png
 ┃ ┃ ┃ ┃ ┣ 📂js
 ┃ ┃ ┃ ┃ ┃ ┣ 📜app.b20b4136.js
 ┃ ┃ ┃ ┃ ┃ ┣ 📜app.b20b4136.js.map
 ┃ ┃ ┃ ┃ ┃ ┣ 📜chunk-vendors.16028549.js
 ┃ ┃ ┃ ┃ ┃ ┗ 📜chunk-vendors.16028549.js.map
 ┃ ┃ ┃ ┃ ┣ 📜favicon.ico
 ┃ ┃ ┃ ┃ ┗ 📜index.html
 ┃ ┃ ┃ ┣ 📜application-secret.properties
 ┃ ┃ ┃ ┗ 📜application.properties
 ┣ 📜README.md
 ┣ 📜build.gradle
 ┣ 📜gradlew
 ┣ 📜gradlew.bat
 ┣ 📜settings.gradle
 ┗ 📜ssafy-web.log.2023-01-30.0.gz
 ```
