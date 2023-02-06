export interface LessonDetailRequest {
  lessonId: number;
}

export interface CurriculumsType {
  id: number;
  stage: number;
  description: string;
  lessonId: number;
}

export interface CheckListsType {
  id: number;
  img: string;
  lessonId: number;
}

export interface PamphletsType {
  id: number;
  img: string;
  lessonId: number;
}

export interface LessonDetailResponse {
  message: string;
  statusCode: number;
  userEmail: string;
  lessonName: string;
  cklsDescription: string;
  lessonDescription: string;
  kitPrice: number;
  kitDescription: string;
  category: string;
  runningtime: number;
  userName: string;
  userDesciption: string | null;
  profileImg: string | null;
  curriculums: CurriculumsType[];
  checkLists: CheckListsType[];
  pamphlets: PamphletsType[];
  score: number;
}

export interface LessonDetailProps {
  lessonId: number;
  lessonDetailState: LessonDetailResponse;
  setLessonDetailState: React.Dispatch<
    React.SetStateAction<LessonDetailResponse>
  >;
  pamphletsImgState: any;
  setPamphletsImgState: React.Dispatch<React.SetStateAction<any>>;
  checkListImgState: any;
  setCheckListImgState: React.Dispatch<React.SetStateAction<any>>;
  teacherImgState: any;
  setTeacherImgState: React.Dispatch<React.SetStateAction<any>>;
  schedulesListState: any;
  setScheduleListState: React.Dispatch<React.SetStateAction<any>>;
  scheduleInputState: boolean;
  setScheduleInputState: React.Dispatch<React.SetStateAction<boolean>>;
}
