import React, { Component } from 'react';

class Login extends Component {
    render() {
        return (
            <div>
                <h1>Login</h1>
                <h3>Email Address: </h3>
                    <input type="text" />
                <h3>Password: </h3>
                    <input type="password" />
                <br />
                <button type="button" class="btn btn-primary">Submit</button>
            </div>
        );
    }
}

export default Login;