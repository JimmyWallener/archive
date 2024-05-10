import React from 'react';
import Button from '../UI/Button';
const Category = ({ list, onClick }) => {
  return (
    <div className='flex w-5/6 xl:w-6/12 xl:ml-[8vw] flex-wrap gap-4 justify-start items-center'>
      {list.size > 1 &&
        Array.from(list).map((cat) => (
          <Button
            key={cat}
            label={cat}
            type='submit'
            styleOptions={
              'w-48 p-1 capitalize focus:bg-black focus:text-white m-4 ml-10 bg-white text-black border border-black card-shadow'
            }
            onClick={onClick.bind(null, cat)}
          />
        ))}
    </div>
  );
};

export default Category;
