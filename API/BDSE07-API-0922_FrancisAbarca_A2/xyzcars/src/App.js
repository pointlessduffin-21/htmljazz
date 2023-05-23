import React, {Component} from 'react';
import logo from './logo.svg';
import './App.css';
import Header from './components/Header';
import Footer from './components/Footer';
import Register from './components/Register';
import Login from './components/Login';
import Home from './components/Home';
import SearchResult from './components/SearchResult';
import UserManager from './components/UserManager';
import { Button, Container, Row, Col , ComponentName } from 'bootstrap'; // assuming you have these components from 'bootstrap'
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';

class App extends Component {
  render() {
    return (
        <Router>
          <div className="App">
            <Header />
            <Routes>
              <Route exact path="/" element={<Home />} />
              <Route path="/Register" element={<Register />} />
              <Route path="/Login" element={<Login />} />
              <Route path="/SearchResult" element={<SearchResult />} />
              <Route path="/UserManager" element={<UserManager />} />
            </Routes>
            <Footer />
          </div>
        </Router>
    );
  }
}

export default App;
