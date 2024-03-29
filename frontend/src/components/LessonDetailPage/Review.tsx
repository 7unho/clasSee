import React, { useEffect, useState, useRef } from 'react';
import { Pagination, Rating } from '@mui/material';
import { useRecoilValue } from 'recoil';

import { useParams, useNavigate } from 'react-router-dom';
import useViewModel from '../../viewmodels/ReviewViewModel';
import PrivateInfoState from '../../models/PrivateInfoAtom';
import { ReviewType } from '../../types/ReviewType';
import ReviewItem from './ReviewItem';

const Review = ({ attended }: any) => {
  const userInfo = useRecoilValue(PrivateInfoState);
  const params = useParams();
  const navigate = useNavigate();
  const textRef = useRef<HTMLTextAreaElement>(null);
  const [score, setScore] = useState<number | null>(0);
  const [img, setImg] = useState<File>();
  const [page, setPage] = useState<number>(1);
  const [count, setCount] = useState<number>(1);
  const [reviews, setReviews] = useState<Array<ReviewType>>([]);
  const { createReview, getReviews, deleteReview } = useViewModel();

  const handleRatingChange = (
    event: React.ChangeEvent<object>,
    newValue: number | null,
  ) => {
    setScore(newValue);
  };
  const handleImageChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    if (event.currentTarget.files !== null) {
      const result = URL.createObjectURL(event.currentTarget.files[0]);
      setImg(event.currentTarget.files[0]);
    }
  };
  const getData = async () => {
    const limit = 10;
    const offset = (page - 1) * limit;
    const response = await getReviews(Number(params.lessonId), limit, offset);
    if (response.count === 0) {
      setCount(1);
    } else {
      setCount(Math.ceil(response.count / limit));
    }
    setReviews(response.page);
  };

  const handleDeleteReview = async (reviewId: number, imgSrc: string) => {
    if (window.confirm('정말 삭제 하시겠습니까?')) {
      const response = await deleteReview(reviewId, imgSrc);
      if (response.statusCode === 200) {
        getData();
      } else if (response.statusCode === 401) {
        alert('로그인 후 이용 바랍니다');
        navigate('/login');
      } else if (response.statusCode === 404) {
        alert('유효하지 않은 접근입니다');
      } else if (response.statusCode === 500) {
        alert('서버오류 입니다');
      } else {
        alert('알 수 없는 오류입니다');
      }
    }
  };
  const handleReviewSubmit = async (
    event: React.FormEvent<HTMLFormElement>,
  ) => {
    event.preventDefault();
    if (textRef.current !== null && userInfo !== null && score !== null) {
      const content = textRef.current.value;
      if (content) {
        const response = await createReview(
          {
            content,
            img: '',
            lessonId: Number(params.lessonId),
            score,
            userEmail: userInfo.email,
          },
          img,
        );
        if (response.statusCode === 200) {
          getData();
          setScore(0);
          textRef.current.value = '';
          setImg(undefined);
        } else if (response.statusCode === 401) {
          alert('로그인이 필요합니다');
          navigate('/login');
        } else if (response.statusCode === 404) {
          alert('유효하지 않은 접근입니다');
        } else if (response.statusCode === 500) {
          alert('서버오류 입니다');
        } else {
          alert('알 수 없는 오류입니다');
        }
        if (response !== null) {
          getData();
          setScore(0);
          textRef.current.value = '';
          setImg(undefined);
        }
      } else {
        alert('리뷰 내용을 작성해 주세요');
      }
    }
  };
  const handlePageChange = (
    event: React.ChangeEvent<unknown>,
    value: number,
  ) => {
    setPage(value);
  };
  // 마운트시 리뷰 목록 불러옴
  useEffect(() => {
    getData();
  }, [page]);

  return (
    <div className="review">
      {attended ? (
        <div className="review__input-box">
          <form className="review__form" onSubmit={handleReviewSubmit}>
            <textarea ref={textRef} />
            <div className="review__row--input-box">
              <Rating
                name="simple-controlled"
                value={score}
                precision={0.5}
                onChange={handleRatingChange}
                readOnly={false}
              />{' '}
              <label className="review__label" htmlFor="input-file">
                {img === undefined ? null : img.name}
                <input
                  type="file"
                  name="후기사진"
                  accept="image/*"
                  id="input-file"
                  className=";"
                  style={{ display: 'none' }}
                  onChange={handleImageChange}
                />
                <div className="button review__button--upload">사진 업로드</div>
              </label>
            </div>
            <button type="submit" className="button review__button--submit">
              등록
            </button>
          </form>
        </div>
      ) : null}
      <div className="review__review-list">
        {reviews.map((review: ReviewType) => (
          <ReviewItem
            review={review}
            key={review.id}
            handleDeleteReview={handleDeleteReview}
          />
        ))}
      </div>
      <div className="review__pagination">
        <Pagination
          variant="outlined"
          count={count}
          page={page}
          shape="rounded"
          size="large"
          onChange={handlePageChange}
        />
      </div>
    </div>
  );
};

export default Review;
