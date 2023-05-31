import React, { Component } from 'react';
import Home from './Home';
import Login from './Login';
import Register from './Register';
import Terms from './Terms';
import About from './About';
import Contact from './Contact';
import Search from './Search';
import { Navbar, Nav, Container, Button, Form, FormControl } from 'react-bootstrap';
import { Link } from 'react-router-dom';

class Header extends Component {
    render() {
        return (
            <>
                <Navbar bg="light" expand="lg" fixed="top" className="deez navbar navbar-light navbar-expand-lg fixed-top bg-white clean-navbar">
                    <Container>
                        <Navbar.Brand href="/">
                            <img 
                                alt="Know Your Neighborhood"
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
                                <Nav.Link as={Link} to="/login">Login</Nav.Link>
                                <Nav.Link as={Link} to="/register">Register</Nav.Link>
                                <Nav.Link as={Link} to="/Terms">Terms and Conditions</Nav.Link>
                                <Nav.Link as={Link} to="/contact">Contact Us</Nav.Link>
                                <Nav.Link as={Link} to="/about">About Us</Nav.Link>
                                <Nav.Link as={Link} to="/search">Search</Nav.Link>
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
