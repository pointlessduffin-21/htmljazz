import React, {Component} from 'react';
import {Link} from 'react-router-dom';

class Register extends Component {
    render() {
        return (
            <div>
                <h1>Register</h1>
                <p>This is the register page</p>
                <Link to="/">Home</Link>
            </div>
        );
    }
}

export default Register;