// @ts-nocheck
import React, { Component } from 'react';
import Item from './Item';

class ExpenseList extends Component {
  constructor(props) {
    super(props);
    this.props = props;
    this.items = [];
    this.populateListOfItems = this.populateListOfItems.bind(this);
  }

  populateListOfItems = () => {
    if (this.items.length > 0) this.items = [];
    this.props.itemList.forEach((price, item) =>
      this.items.push(<Item key={item} item={item} price={price} />)
    );
  };

  componentDidUpdate() {
    this.populateListOfItems();
  }

  render() {
    return (
      <>
        <div className='flex justify-between w-full items-center mt-10'>
          <h3 className='font-bold text-2xl uppercase ml-5'>Item</h3>
          <h3 className='font-bold text-2xl uppercase mr-5'>Price</h3>
        </div>
        {this.props.itemList.size > 0 && (
          <div>
            <ul className='list-none flex w-full mt-5 flex-col text-black'>
              {this.items}
            </ul>
          </div>
        )}
      </>
    );
  }
}

export default ExpenseList;
