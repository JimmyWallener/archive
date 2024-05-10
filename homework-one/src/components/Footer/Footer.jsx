import React, { Component } from 'react';

class Footer extends Component {
  render() {
    return (
      <footer className='flex w-full h-20 bg-black justify-center'>
        <ul className='flex w-2/12 justify-between items-center text-white'>
          <li>
            <a href='https://linkedin.com' target='_blank' rel='noreferrer'>
              Linkedin
            </a>
          </li>
          <li>
            <a href='https://facebook.com' target='_blank' rel='noreferrer'>
              Facebook
            </a>
          </li>
          <li>
            <a href='https://youtube.com' target='_blank' rel='noreferrer'>
              Youtube
            </a>
          </li>
          <li>
            <a href='https://google.com' target='_blank' rel='noreferrer'>
              Google
            </a>
          </li>
        </ul>
      </footer>
    );
  }
}

export default Footer;
