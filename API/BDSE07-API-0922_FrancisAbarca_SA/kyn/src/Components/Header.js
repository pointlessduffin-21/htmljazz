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
                                src="https://cdn.discordapp.com/attachments/1077803645975928853/1113025138716315738/OIG.ZNbN1.png"
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
