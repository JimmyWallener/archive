import React, { Component } from 'react';
import Button from '../UI/Button';
import Input from '../UI/Input';

class WithdrawForm extends Component {
  constructor(props) {
    super(props);
    this.onSubmitHandle = this.onSubmitHandle.bind(this);
  }

  onSubmitHandle = (event) => {
    event.preventDefault();
    this.props.onSubmitHandle(
      event.target[0].value.trim(),
      event.target[1].value.trim()
    );
    event.target[0].value = '';
    event.target[1].value = '';
  };

  render() {
    return (
      <form
        onSubmit={this.onSubmitHandle}
        className='mt-5 flex-col flex items-center w-full'
      >
        <Input
          label='Expense Form'
          value={{
            type: 'text',
            placeholder: 'Enter expense description',
            className:
              'w-full text-center h-10 bg-slate-300 my-2 focus:bg-teal-400',
          }}
        />
        <Input
          label=''
          value={{
            type: 'number',
            min: 1,
            max: 999999999,
            step: 1,
            placeholder: 'Enter expense amount',
            className:
              'w-full text-center h-10 bg-slate-300 mb-5 focus:bg-teal-400',
          }}
        />
        <Button
          text='Add Expense'
          value={{
            type: 'submit',
            className:
              'bg-black text-white p-2 uppercase tracking-wide font-bold w-full bg-red-600 text-center rounded-xl',
          }}
        />
        <Button
          text='Cancel'
          value={{
            type: 'reset',
            className:
              'bg-black text-white mt-1 p-2 font-bold tracking-wide uppercase text-center w-full rounded-xl',
          }}
        />
      </form>
    );
  }
}

export default WithdrawForm;
