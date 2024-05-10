// @ts-nocheck
import React, { Component } from 'react';
import Button from '../UI/Button';
import Input from '../UI/Input';

class DepositForm extends Component {
  constructor({ onDeposit }) {
    super();
    this.onSubmitHandle = this.onSubmitHandle.bind(this);
    this.deposit = onDeposit;
  }

  onSubmitHandle = (event) => {
    event.preventDefault();
    this.deposit(event.target.children[1].value.trim());
    event.target.children[1].value = '';
  };

  render() {
    return (
      <form
        onSubmit={this.onSubmitHandle}
        className='flex-col flex items-center w-auto mb-10'
      >
        <Input
          label='Deposit Form'
          value={{
            name: 'deposit',
            type: 'number',
            min: 1,
            max: 999999999,
            step: 1,
            placeholder: 'Enter amount to deposit',
            className:
              'w-full text-center h-10 bg-slate-300 my-5 focus:bg-teal-400',
          }}
        />
        <Button
          text='Add Deposit'
          value={{
            type: 'submit',
            className:
              'bg-black text-white p-2 font-bold tracking-wide uppercase w-full bg-blue-500 text-center rounded-xl',
          }}
        />
        <Button
          text='Cancel'
          value={{
            type: 'reset',
            className:
              'bg-black text-white mt-1 p-2 font-bold tracking-wide uppercase w-full text-center rounded-xl',
          }}
        />
      </form>
    );
  }
}

export default DepositForm;
