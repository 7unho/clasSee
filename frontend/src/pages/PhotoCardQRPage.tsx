import React, { useEffect } from 'react';
import { Link, useNavigate, useParams } from 'react-router-dom';
import { useRecoilValue } from 'recoil';
import { QRCodeSVG } from 'qrcode.react';

import PrivateInfoState from '../models/PrivateInfoAtom';

const PhotoCardQRPage = () => {
  const userInfo = useRecoilValue(PrivateInfoState);
  const navigate = useNavigate();
  const params = useParams();
  const { lessonId, openLessonId } = useParams();
  useEffect(() => {
    if (userInfo === null) {
      navigate('/');
    }
  }, []);
  return (
    <div className="photo-card-qr-page page">
      <h1>포토카드 생성하기</h1>
      {userInfo !== null ? (
        <QRCodeSVG
          className="photo-card-qr-page__qr-code"
          size={256}
          value={`http://www.classee.site/photo-card/create/${lessonId}/${openLessonId}/${userInfo.email}`}
        />
      ) : null}
      <div className="photo-card-qr-page__buttons">
        {userInfo !== null ? (
          <Link
            to={`/photo-card/create/${lessonId}/${openLessonId}/${userInfo.email}`}
          >
            <button type="button" className="button photo-card-qr-page__button">
              PC에서 만들기
            </button>
          </Link>
        ) : null}
        <button
          type="button"
          className="button photo-card-qr-page__button--quit"
          onClick={window.close}
        >
          종료하기
        </button>
      </div>
    </div>
  );
};

export default PhotoCardQRPage;
