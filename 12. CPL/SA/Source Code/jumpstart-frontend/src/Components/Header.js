import Home from './Home';
import Login from './Login';
import Register from './Register';
import Chat from './Chat';
import Product from './Product';
import Feedback from './Feedback';
import React, { Component } from 'react';
import { Navbar, Nav, Container, Button, Form, FormControl } from 'react-bootstrap';
import { Link } from 'react-router-dom';

class Header extends Component {
    render() {
        const { logout, success } = this.props;
        return (
            <>
                <Navbar bg="light" expand="lg" fixed="top" className="deez navbar navbar-light navbar-expand-lg fixed-top bg-white clean-navbar">
    <Container>
        <Navbar.Brand href="/">
            <img 
                alt="Jumpstart"
                src="https://gpupv.yeems214.xyz/R%20e%20p%20o%20s%20i%20t%20o%20r%20y/jumpstart/banner-logo.png"
                width="125"
                height="auto"
                className="d-inline-block align-top"
            />
        </Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav" className="justify-content-end">
            <Nav>
                <Nav.Link as={Link} to="/">Home</Nav.Link>
                {/* <Nav.Link as={Link} to="/Login">Login</Nav.Link>  */}
                <Nav.Link as={Link} to="/Register">Register</Nav.Link> 
                <Nav.Link as={Link} to="/Chat">Chat</Nav.Link>
                <Nav.Link as={Link} to="/Feedback">Feedback</Nav.Link>
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