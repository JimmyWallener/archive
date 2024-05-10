import React from 'react';
import Logo from './Logo';

const NavBar = () => {
  return (
    <header>
      <nav className='h-20 bg-black w-full'>
        <Logo />
      </nav>
    </header>
  );
};

export default NavBar;
