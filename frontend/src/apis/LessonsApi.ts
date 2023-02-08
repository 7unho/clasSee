import axios, { AxiosResponse } from 'axios';
import { useRecoilValue } from 'recoil';
import AuthTokenState from '../models/AuthTokenAtom';

const LessonsApi = () => {
  const accessToken = useRecoilValue(AuthTokenState);
  const getRecommandLessonsApi = async (email: string | null) => {
    try {
      const response = await axios.get(
        `${process.env.REACT_APP_SERVER_URI}/api/v1/lessons/recommands?email=${email}`,
      );
      return response.data;
    } catch (error: any) {
      console.log(error);
    }
    return null;
  };
  // 내가 개설한 강의 2개 불러오는 함수
  const MyCreatedLessonsMainpageApi = async (
    email: string,
    limit: number,
    offset: number,
    query: string,
  ) => {
    try {
      const response = await axios.get(
        `${process.env.REACT_APP_SERVER_URI}/api/v1/teachers/${email}/lessons?limit=${limit}&offset=${offset}&query=${query}`,
        {
          headers: {
            Authorization: `Bearer ${accessToken}`,
          },
        },
      );
      // console.log(response.data);
      return response.data;
    } catch (error: any) {
      console.error(error);
    }
    return null;
  };
  const MyAppliedLessonsMainpageApi = async (
    email: string,
    limit: number,
    offset: number,
    query: string,
  ) => {
    try {
      const response = await axios.get(
        `${process.env.REACT_APP_SERVER_URI}/api/v1/students/${email}/lessons?limit=${limit}&offset=${offset}&query=${query}`,
        {
          headers: {
            Authorization: `Bearer ${accessToken}`,
          },
        },
      );
      return response.data;
    } catch (error: any) {
      console.error(error);
    }
    return null;
  };
  const deleteMyAppliedLessonsMainpageApi = async (
    userId: string,
    lessonId: number,
  ) => {
    try {
      const response = await axios.delete(
        `${process.env.REACT_APP_SERVER_URI}/api/v1/myappliedlessonsmainpage/${userId}/${lessonId}`,
      );
      return response.data;
    } catch (error: any) {
      console.error(error);
    }
    return null;
  };
  const deleteBookmarkApi = async (email: string, lessonId: number) => {
    try {
      const response = await axios.delete(
        `${process.env.REACT_APP_SERVER_URI}/api/v1/bookmarks/${email}/${lessonId}`,
      );
      return response.data;
    } catch (error: any) {
      console.error(error);
    }
    return null;
  };
  const addBookmarkApi = async (email: string, lessonId: number) => {
    try {
      const response = await axios.post(
        `${process.env.REACT_APP_SERVER_URI}/api/v1/bookmarks/${email}/${lessonId}`,
      );
      return response.data;
    } catch (error: any) {
      console.error(error);
    }
    return null;
  };
  return {
    getRecommandLessonsApi,
    MyCreatedLessonsMainpageApi,
    MyAppliedLessonsMainpageApi,
    deleteMyAppliedLessonsMainpageApi,
    deleteBookmarkApi,
    addBookmarkApi,
  };
};

export default LessonsApi;
