import React from 'react';

import ImageUpload from '../ImageUpload';

import { ImageUploadProps, MaterialDescriptionProps } from '../../types/CreateLessonType';

// 상의한 Props를 엮어서 CombinedProps라는 새로운 type를 생성함
type CombinedProps = ImageUploadProps & MaterialDescriptionProps;

const StepFour = ({
  limitNumber,
  imgSrcList,
  setImgSrcList,
  materialDescription,
  setMaterialDescription,
}: CombinedProps) => {
  const handleInputMaterialDescription = (e: React.ChangeEvent<HTMLTextAreaElement>) => {
    setMaterialDescription(e.target.value);
  };
  return (
    <div>
      <h2>Step 4. 준비물 등록</h2>
      {/* props로 ImageUpload에 전달할 사진 개수를 limit 변수에 지정 */}
      <ImageUpload limitNumber={limitNumber} imgSrcList={imgSrcList} setImgSrcList={setImgSrcList} />
      <textarea
        cols={30}
        rows={10}
        placeholder="준비물에 대해 입력해주세요."
        value={materialDescription}
        onChange={handleInputMaterialDescription}
      />
    </div>
  );
};

export default StepFour;
