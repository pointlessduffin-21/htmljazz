import React, { Component } from 'react';
import Footer from './Footer';
import Register from './Register';
import Login from './Login';
import Home from './Home';
import CarViewPage from './CarViewPage';
import CarManagementPage from './CarManagementPage';
import UserManagementPage from './UserManagementPage';
import CarAddForm from './CarAddForm';
import CarListPage from './CarListPage';
import Search from './Search';
import { Navbar, Nav, Container, Button, Form, FormControl } from 'react-bootstrap';
import { Link } from 'react-router-dom';

class Header extends Component {
    render() {
        return (
            <>
                <Navbar bg="light" expand="lg" fixed="top" className="deez">
                    <Container>
                        <Navbar.Brand href="/">
                            <img 
                                alt="ABC Cars"
                                src="https://gpupv.yeems214.xyz/R%20e%20p%20o%20s%20i%20t%20o%20r%20y/abc-cars.png"
                                width="30"
                                height="auto"
                                className="d-inline-block align-top"
                            />
                        </Navbar.Brand>
                        <Navbar.Toggle aria-controls="basic-navbar-nav" />
                        <Navbar.Collapse id="basic-navbar-nav">
                            <Nav className="mr-auto">
                                <Nav.Link as={Link} to="/">Home</Nav.Link>
                                <Nav.Link as={Link} to="/Register">Register</Nav.Link>
                                <Nav.Link as={Link} to="/login">Login</Nav.Link>
                                <Nav.Link as={Link} to="/CarViewPage">Car View Page</Nav.Link>
                                <Nav.Link as={Link} to="/CarAddForm">Car Add Form</Nav.Link>
                                <Nav.Link as={Link} to="/CarListPage">Car Management</Nav.Link>
                                <Nav.Link as={Link} to="/UserManagementPage">User Management</Nav.Link>
                                <Nav.Link as={Link} to="/Search">Search</Nav.Link>
                            </Nav>
                        </Navbar.Collapse>
                    </Container>
                </Navbar>

                <br />
                <br />
                <br />
                <br />
                
                </>
        );
    }
}

export default Header;
