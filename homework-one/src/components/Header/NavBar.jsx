import React, { Component } from 'react';
import Logo from './Logo';

class NavBar extends Component {
  render() {
    return (
      <header>
        <nav className='h-20 bg-black w-full'>
          <Logo />
        </nav>
      </header>
    );
  }
}

export default NavBar;
