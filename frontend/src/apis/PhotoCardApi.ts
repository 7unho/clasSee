import axios from 'axios';

import { Response } from '../types/BaseType';
import { CreatePhotoCardRequest } from '../types/PhotoCardType';

const PhotoCardApi = () => {
  const accesstoken = localStorage.getItem('accessToken');
  const doDeletePhotoCard = async (id: number) => {
    try {
      const response = await axios.delete(
        `${process.env.REACT_APP_SERVER_URI}/api/v1/photocard?id=${id}`,
        {
          headers: {
            Authorization: `Bearer ${accesstoken}`,
          },
        },
      );
      return response.data;
    } catch (error: any) {
      return error.response.data;
    }
  };
  const doLikePhotoCard = async (email: string, id: number) => {
    try {
      const response = await axios.post(
        `${process.env.REACT_APP_SERVER_URI}/api/v1/photocard/likes?email=${email}&id=${id}`,
        {},
        {
          headers: {
            Authorization: `Bearer ${accesstoken}`,
          },
        },
      );
      return response.data;
    } catch (error: any) {
      return error.response.data;
    }
  };

  const doDislikePhotoCard = async (email: string, id: number) => {
    try {
      const response = await axios.delete(
        `${process.env.REACT_APP_SERVER_URI}/api/v1/photocard/likes?email=${email}&id=${id}`,
        {
          headers: {
            Authorization: `Bearer ${accesstoken}`,
          },
        },
      );
      return response.data;
    } catch (error: any) {
      return error.response.data;
    }
  };

  const doCreatePhotoCard = async (requestBody: CreatePhotoCardRequest) => {
    try {
      const response = await axios.post<Response>(
        `${process.env.REACT_APP_SERVER_URI}/api/v1/photocard`,
        requestBody,
      );
      return response.data;
    } catch (error: any) {
      return error.response.data;
    }
  };

  const doGetPhotoCards = async (
    email: string | null,
    limit: number,
    offset: number,
  ) => {
    try {
      if (email === null) {
        const response = await axios.get(
          `${process.env.REACT_APP_SERVER_URI}/api/v1/photocard/list?limit=${limit}&offset=${offset}`,
        );
        return response.data;
      }
      const response = await axios.get(
        `${process.env.REACT_APP_SERVER_URI}/api/v1/photocard/list?email=${email}&limit=${limit}&offset=${offset}`,
        {
          headers: {
            Authorization: `Bearer ${accesstoken}`,
          },
        },
      );
      return response.data;
    } catch (error: any) {
      return error.response.data;
    }
  };
  const doGetMyPhotoCards = async (
    email: string,
    limit: number,
    offset: number,
  ) => {
    try {
      const response = await axios.get(
        `${process.env.REACT_APP_SERVER_URI}/api/v1/photocard/list/${email}?limit=${limit}&offset=${offset}`,
        {
          headers: {
            Authorization: `Bearer ${accesstoken}`,
          },
        },
      );
      return response.data;
    } catch (error: any) {
      return error.response.data;
    }
  };
  return {
    doCreatePhotoCard,
    doGetPhotoCards,
    doLikePhotoCard,
    doDislikePhotoCard,
    doDeletePhotoCard,
    doGetMyPhotoCards,
  };
};

export default PhotoCardApi;
