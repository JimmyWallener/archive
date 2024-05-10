// @ts-nocheck
import React, { Component } from 'react';
import ExpenseList from '../ItemizedList/ExpenseList';
import Card from '../UI/Card';
import ErrorModal from '../UI/ErrorModal';
import Balance from './Balance';
import DepositForm from './DepositForm';
import WithdrawForm from './WithdrawForm';

class BankForm extends Component {
  constructor(props) {
    super(props);
    this.list = localStorage.getItem('items')
      ? new Map(JSON.parse(localStorage.items))
      : new Map();
    this.state = { isMapped: false };
    this.errorMsg = '';
    this.submitHandle = this.submitHandle.bind(this);
    this.handleClick = this.handleClick.bind(this);
  }

  submitHandle = (item, price) => {
    if (!this.list.has(item) && this.props.expenseState.balance - price >= 0) {
      this.list.set(item, price);
      this.props.onUpdateWithdraw(+price);
      localStorage.setItem('items', JSON.stringify([...this.list]));
    } else {
      if (this.list.has(item)) {
        this.errorMsg = `${item} is already in the list`;
      } else {
        this.errorMsg = `Current Balance is: ${this.props.expenseState.balance}.\n Unable to withdraw: ${price}`;
      }
      this.setState((prevState) => ({
        isMapped: !prevState.isMapped,
      }));
    }
  };

  handleClick = (event) => {
    event.preventDefault();
    this.setState((prevState) => ({
      isMapped: !prevState.isMapped,
    }));
  };

  render() {
    return (
      <>
        {this.state.isMapped && (
          <ErrorModal
            errorMsg={this.errorMsg}
            onHandleClick={this.handleClick}
          />
        )}
        <Card>
          <div className='flex justify-center w-full'>
            <div className='flex flex-col items-center w-[50%] mr-10 w-2xl'>
              <Card>
                <DepositForm onDeposit={this.props.onBudgetUpdate} />
              </Card>
              <Card>
                <WithdrawForm onSubmitHandle={this.submitHandle} />
              </Card>
            </div>

            <div className='flex flex-col w-[50%]'>
              <Balance expenses={this.props.expenseState} />
              <ExpenseList itemList={this.list} />
            </div>
          </div>
        </Card>
      </>
    );
  }
}

export default BankForm;
