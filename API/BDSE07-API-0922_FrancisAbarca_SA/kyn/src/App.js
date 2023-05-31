import React, {Component} from 'react';
import Header from './Components/Header';
import Footer from './Components/Footer';
import Home from './Components/Home';
import Login from './Components/Login';
import Register from './Components/Register';
import Terms from './Components/Terms';
import About from './Components/About';
import Contact from './Components/Contact';
import Search from './Components/Search';
import Message from './Components/Message';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import logo from './logo.svg';
import './App.css';

function App() {
  return (
    <Router>
      <div className="App">
        <Header />
        <Routes>
          <Route exact path="/" element={<Home />} />
          <Route path="/about" element={<About />} />
          <Route path="/contact" element={<Contact />} />
          <Route path="/login" element={<Login />} />
          <Route path="/search" element={<Search />} />
          <Route path="/register" element={<Register />} />
          <Route path="/Terms" element={<Terms />} />
          <Route path="/Message" element={<Message />} />
        </Routes>
        <Footer />
        </div>
      </Router>
  );
}

export default App;
