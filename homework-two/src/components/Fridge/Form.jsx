import React, { useState } from 'react';
import Button from '../UI/Button';
import Card from '../UI/Card';
import Input from '../UI/Input';

const Form = ({ onSubmitHandler }) => {
  const [newItem, setNewItem] = useState({
    name: '',
    amount: '',
    category: '',
    date: Date,
  });
  const changeStateHandler = (e) => {
    setNewItem((prevState) => {
      return {
        ...prevState,
        [e.target.name]: e.target.value,
      };
    });
  };

  const submitHandler = (e) => {
    e.preventDefault();
    onSubmitHandler(newItem);
    setNewItem({
      name: ''.toLowerCase().trim(),
      amount: '',
      category: ''.toLowerCase().trim(),
      date: Date,
    });
  };

  return (
    <Card
      styleOptions={
        'w-[70vw] xl:w-[40vw] flex  items-center justify-start flex-col'
      }
    >
      <form className='flex flex-col h-[40vh] w-full' onSubmit={submitHandler}>
        <div className='flex justify-between h-[10vh] mt-16'>
          <Input
            attr={{
              name: 'name',
              type: 'text',
              placeholder: 'Product Name',
            }}
            onChange={changeStateHandler}
            value={newItem.name}
          />
          <Input
            attr={{
              name: 'amount',
              type: 'number',
              placeholder: 'Product Amount',
              min: 1,
              max: 99999999,
            }}
            onChange={changeStateHandler}
            value={newItem.amount}
          />
        </div>
        <div className='flex justify-between h-[10vh] mt-16'>
          <Input
            attr={{
              name: 'date',
              type: 'date',
            }}
            onChange={changeStateHandler}
            value={newItem.date}
          />
          <Input
            attr={{
              name: 'category',
              type: 'text',
              placeholder: 'Product Category',
            }}
            onChange={changeStateHandler}
            value={newItem.category}
          />
        </div>
        <div className='flex items-center justify-center'>
          <Button
            styleOptions={
              'mb-2 p-2 w-[70%] cursor-pointer bg-blue-800 rounded-md text-white uppercase font-bold hover:bg-blue-600 card-shadow '
            }
            label={'Add Product'}
            type={'submit'}
          />
        </div>
      </form>
    </Card>
  );
};

export default Form;
