import React, { Component } from 'react';
import Footer from './Footer';
import Register from './Register';
import Login from './Login';
import Home from './Home';
import CarViewPage from './CarViewPage';
import CarManagementPage from './CarManagementPage';
import CarAddForm from './CarAddForm';
import CarListPage from './CarListPage';
import Search from './Search';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';

class Header extends Component {
    render() {
        return (
            <React.Fragment>
                <nav className="navbar navbar-expand-lg navbar-light bg-light">
                <div>
                    <Link to="/">Home</Link>
                    <Link to="/Register">Register</Link>
                    <Link to="/Login">Login</Link>
                    <Link to="/CarViewPage">Car View Page</Link>
                    <Link to="/CarManagementPage">Car Management Page</Link>
                    <Link to="/CarAddForm">Car Add Form</Link>
                    <Link to="/CarListPage">Car List Page</Link>
                    <Link to="/Search">Search</Link>
                </div>

                

                </nav>
            </React.Fragment>
        )
    }
}

export default Header;
