// @ts-nocheck
import React, { Component } from 'react';

class Input extends Component {
  constructor({ label, value }) {
    super();
    this.value = value;
    this.label = label;
  }
  render() {
    return (
      <>
        {this.label && (
          <label
            htmlFor={this.label}
            className='bg-gray-800 text-white font-bold mb-10 p-4 w-full text-center rounded-sm'
          >
            {this.label}
          </label>
        )}

        <input {...this.value}></input>
      </>
    );
  }
}

export default Input;
