import React, { useEffect, useState } from 'react';
import Category from './Fridge/Category';
import Filter from './Fridge/Filter';
import Form from './Fridge/Form';

const Main = () => {
  const [productList, setProductList] = useState([]);
  const [categoryList, setCategoryList] = useState(new Set(['all']));
  const [sortWord, setSortWord] = useState('all');

  const submitHandler = (state) => {
    setProductList((prevState) => [...prevState, { ...state }]);
  };

  const onClickHandler = (category) => {
    setSortWord(category);
  };

  useEffect(() => {
    for (const products of productList) {
      setCategoryList((prevState) => new Set(prevState.add(products.category)));
    }
  }, [productList, sortWord]);

  return (
    <div className='flex justify-center flex-col items-center'>
      <Form onSubmitHandler={submitHandler} />
      <Category list={categoryList} onClick={onClickHandler} />
      <Filter product={productList} category={sortWord} />
    </div>
  );
};

export default Main;
