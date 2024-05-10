import React from 'react';

const Button = ({ type, styleOptions, label, ...args }) => {
  return (
    <button type={type} className={`${styleOptions}`} {...args}>
      {label}
    </button>
  );
};

export default Button;
