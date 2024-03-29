import LessonsApi from '../apis/LessonsApi';

import { LessonRequest } from '../types/LessonsType';

const CreateLessonViewModel = () => {
  const { doCreateLesson, doUpdateLesson } = LessonsApi();

  const createLesson = async (data: LessonRequest) => {
    const res = await doCreateLesson(data);
    return res;
  };
  const updateLesson = async (data: LessonRequest, lessonId: number) => {
    const res = await doUpdateLesson(data, lessonId);
    return res;
  };

  return {
    createLesson,
    updateLesson,
  };
};

export default CreateLessonViewModel;
