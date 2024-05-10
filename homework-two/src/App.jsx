import React, { Fragment } from 'react';
import './App.css';
import Footer from './components/Footer/Footer';
import NavBar from './components/Header/NavBar';
import Main from './components/Main';
function App() {
  return (
    <Fragment>
      <NavBar />
      <Main />
      <Footer />
    </Fragment>
  );
}

export default App;
