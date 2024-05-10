import React from 'react';

const Footer = () => {
  return (
    <footer className='flex xl:w-full h-20 bg-black justify-center'>
      <ul className='flex w-[50vw] xl:w-[30vw] justify-between items-center text-white'>
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
};

export default Footer;
