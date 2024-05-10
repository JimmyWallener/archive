import React, { Component } from 'react';

export default class Item extends Component {
  constructor(props) {
    super(props);
    this.props = props;
  }
  render() {
    return (
      <>
        {
          <li className='flex justify-between items-center'>
            <span className='text-xl ml-5'>{this.props.item}</span>
            <span className='text-md text-gray-500 mr-5'>
              {this.props.price}
            </span>
          </li>
        }
      </>
    );
  }
}
