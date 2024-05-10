import React from 'react';

const Card = ({ children, styleOptions }) => {
  return (
    <div
      className={`${styleOptions} p-2 my-2 card-shadow rounded-2x1 bg-white`}
    >
      {children}
    </div>
  );
};

export default Card;
