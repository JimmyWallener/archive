// @ts-nocheck
import React, { Component } from 'react';
import BankForm from './Bank/BankForm';

class Main extends Component {
  constructor(props) {
    super(props);
    this.updateBudgetHandler = this.updateBudgetHandler.bind(this);
    this.updateWithdrawHandler = this.updateWithdrawHandler.bind(this);
    this.state = {
      budget: 0,
      withdraw: 0,
      balance: 0,
    };
  }

  componentDidMount() {
    if (localStorage.getItem('banking')) {
      this.setState(JSON.parse(localStorage.getItem('banking')));
    }
  }

  componentDidUpdate(prevProps, prevState) {
    if (JSON.stringify(prevState) !== JSON.stringify(this.state)) {
      this.setState((prevState) => ({
        ...prevState,
        budget: this.state.budget,
        withdraw: this.state.withdraw,
        balance: this.state.balance,
      }));
      localStorage.setItem('banking', JSON.stringify(this.state));
    }
  }

  updateBudgetHandler = (budget) => {
    this.setState((prevState) => ({
      ...prevState,
      budget: +this.state.budget + +budget,
      balance:
        +prevState.withdraw === 0
          ? +prevState.budget + +budget
          : +prevState.balance + +budget,
    }));
  };

  updateWithdrawHandler = (amount) => {
    this.setState((prevState) => ({
      ...prevState,
      withdraw: +this.state.withdraw + +amount,
      balance: +this.state.budget - (+prevState.withdraw + +amount),
    }));
  };

  render() {
    return (
      <main className='flex items-center justify-center w-full h-screen'>
        <BankForm
          onBudgetUpdate={this.updateBudgetHandler}
          onUpdateWithdraw={this.updateWithdrawHandler}
          expenseState={this.state}
        />
      </main>
    );
  }
}

export default Main;
