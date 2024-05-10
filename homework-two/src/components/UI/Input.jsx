import React from 'react';

const Input = ({ attr, onChange, value }) => {
  return (
    <input
      {...attr}
      value={value.toString()}
      className='text-center border card-shadow appearance-none rounded-md border-gray-400 w-[30vw] h-[4vh] mr-2 focus:bg-teal-200 focus:border-teal-200'
      onChange={onChange}
      required
    ></input>
  );
};

export default Input;
