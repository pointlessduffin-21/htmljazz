import React, {Component} from 'react';
import logo from './logo.svg';
import './App.css';
import Header from './components/Header';
import Footer from './components/Footer';
import Register from './components/Register';
import Login from './components/Login';
import Home from './components/Home';
import CarViewPage from './components/CarViewPage';
import CarManagementPage from './components/CarManagementPage';
import CarAddForm from './components/CarAddForm';
import CarListPage from './components/CarListPage';
import Search from './components/Search';
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
              <Route path="/CarViewPage" element={<CarViewPage />} />
              <Route path="/CarManagementPage" element={<CarManagementPage />} />
              <Route path="/CarAddForm" element={<CarAddForm />} />
              <Route path="/CarListPage" element={<CarListPage />} />
              <Route path="/Search" element={<Search />} />
            </Routes>
            <Footer />
          </div>
        </Router>
    );
  }
}

export default App;
