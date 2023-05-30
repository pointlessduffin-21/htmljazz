import React, {Component} from 'react';
import {Link} from 'react-router-dom';

class Login extends Component {
    render(){
        return (
        <div>
            <h1>Login</h1>
            <p>This is the login page</p>
            <Link to="/">Home</Link>
        </div>
        );
    }
}

export default Login;