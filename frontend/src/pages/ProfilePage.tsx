import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { useRecoilValue } from 'recoil';
import { Card, CardContent } from '@mui/material';
import { PersonOutline } from '@mui/icons-material';

import privateInfoState from '../models/PrivateInfoAtom';
import useViewModel from '../viewmodels/ProfileViewModel';

const ProfilePage = () => {
  const [image, setImage] = useState<string>();
  const navigate = useNavigate();
  const userInfo = useRecoilValue(privateInfoState);

  const { uploadProfileImage, getProfileImage, updateNickName, updatePhone } =
    useViewModel();

  const upload = async (e: React.ChangeEvent<HTMLInputElement>) => {
    if (e.currentTarget.files !== null && userInfo !== null) {
      await uploadProfileImage(e.currentTarget.files[0]);
      const uploadedImage = await getProfileImage(userInfo.email);
      setImage(uploadedImage);
    }
  };

  const handleUpdateNickName = async () => {
    if (userInfo !== null) {
      const nickname = prompt('변경할 닉네임을 입력하세요.', userInfo.name);
      if (nickname !== null) {
        updateNickName(nickname);
      }
    }
  };

  const handleUpdatePhone = async () => {
    if (userInfo !== null) {
      const phone = prompt('변경할 전화번호를 입력하세요.', userInfo.phone);
      if (phone !== null) {
        updatePhone(phone);
      }
    }
  };

  useEffect(() => {
    if (userInfo === null) {
      alert('로그인 후 이용 가능합니다.');
      navigate('/login');
    } else {
      const getImage = async () => {
        const imageUrl = await getProfileImage(userInfo.email);
        console.log(imageUrl);
        setImage(imageUrl);
      };
      getImage();
    }
  }, []);

  return (
    <div className="profile-page">
      {userInfo !== null ? (
        <Card className="profile-page__card">
          <CardContent>
            <div className="profile-page__header">
              <div className="profile-page__image">
                {image === null ? (
                  <div className="profile-page__image--not">
                    <PersonOutline
                      style={{
                        fontSize: '200px',
                      }}
                    />
                  </div>
                ) : (
                  <img
                    src={image}
                    alt={image}
                    className="profile-page__image--not"
                  />
                )}
                <div className="profile-page__image--change">
                  <label htmlFor="profile-page__image-input">
                    프로필 변경
                    <input
                      type="file"
                      placeholder="프로필 변경"
                      id="profile-page__image-input"
                      onChange={upload}
                    />
                  </label>
                </div>
              </div>
              <div className="profile-page__sub-header">
                <div className="profile-page__section--nickname">
                  <div className="profile-page__nickname">
                    <span>{userInfo.nickname}</span>님 안녕하세요!
                  </div>
                  <div className="profile-page__buttons">
                    <button
                      type="button"
                      className="button profile-page__button"
                      onClick={handleUpdateNickName}
                    >
                      닉네임 변경
                    </button>
                  </div>
                </div>
                <div className="profile-page__section--point">
                  <div className="profile-page__point">
                    <span>{userInfo.point}</span> P
                  </div>
                  <div className="profile-page__buttons">
                    <button
                      type="button"
                      className="button profile-page__button"
                    >
                      포인트 충전
                    </button>
                    <button
                      type="button"
                      className="button profile-page__button"
                    >
                      포인트 정산
                    </button>
                  </div>
                </div>
              </div>
            </div>
            <div className="profile-page__info">
              <div className="profile-page__section">
                <div className="profile-page__section--label">이름</div>
                <div className="profile-page__section--content">
                  {userInfo.name}
                </div>
              </div>
              <div className="profile-page__section">
                <div className="profile-page__section--label">이메일</div>
                <div className="profile-page__section--content">
                  {userInfo.email}
                </div>
              </div>
              <div className="profile-page__section">
                <div className="profile-page__section--label">비밀번호</div>
                <div className="profile-page__section--content">******</div>
                <div className="profile-page__buttons">
                  <button type="button" className="button profile-page__button">
                    비밀번호 변경
                  </button>
                </div>
              </div>
              <div className="profile-page__section">
                <div className="profile-page__section--label">전화번호</div>
                <div className="profile-page__section--content">
                  {userInfo.phone}
                </div>
                <div className="profile-page__buttons">
                  <button
                    type="button"
                    className="button profile-page__button"
                    onClick={handleUpdatePhone}
                  >
                    전화번호 변경
                  </button>
                </div>
              </div>
              <div className="profile-page__section">
                <div className="profile-page__section--label">주소</div>
                <div className="profile-page__section--content">
                  {userInfo.address}
                </div>
                <div className="profile-page__buttons">
                  <button type="button" className="button profile-page__button">
                    주소 변경
                  </button>
                </div>
              </div>
              <div className="profile-page__section">
                <div className="profile-page__section--label">소개</div>
                <div className="profile-page__section--content">
                  <textarea>{userInfo.description}</textarea>
                </div>
                <div className="profile-page__buttons">
                  <button type="button" className="button profile-page__button">
                    소개 변경
                  </button>
                </div>
              </div>
            </div>
            <button type="button" className="button profile-page__withdrawl">
              회원탈퇴
            </button>
          </CardContent>
        </Card>
      ) : null}
    </div>
  );
};

export default ProfilePage;
