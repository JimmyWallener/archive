// @ts-nocheck
import React, { Component } from 'react';

class Balance extends Component {
  constructor(props) {
    super(props);
    this.renderValues = this.renderValues.bind(this);
    this.stateMapper = this.stateMapper.bind(this);
  }

  renderValues(expense) {
    return (
      <ul className='flex w-full h-10 justify-between items-center p-2'>
        <li>Budget: {expense.budget}</li>
        <li>Withdraw: {expense.withdraw}</li>
        <li>Balance: {expense.balance}</li>
      </ul>
    );
  }
  stateMapper() {
    Object.keys(this.props.expenses).map((keys) => this.renderValues(keys));
  }

  render() {
    return (
      <div className='flex bg-gray-500 text-white'>
        {this.renderValues(this.props.expenses)}
      </div>
    );
  }
}

export default Balance;
