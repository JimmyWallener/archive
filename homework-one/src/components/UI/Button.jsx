// @ts-nocheck
import React, { Component } from 'react';

class Button extends Component {
  constructor({ text, value }) {
    super();
    this.text = text;
    this.value = value;
  }

  render() {
    return <button {...this.value}>{this.text}</button>;
  }
}

export default Button;
