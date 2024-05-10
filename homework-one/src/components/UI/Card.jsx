import React, { Component } from 'react';

export default class Card extends Component {
  constructor(props) {
    super(props);
    this.props = props;
  }
  render() {
    return (
      <div className='p-2 my-2 w-[70%] card-shadow rounded-2xl bg-white'>
        {this.props.children}
      </div>
    );
  }
}
