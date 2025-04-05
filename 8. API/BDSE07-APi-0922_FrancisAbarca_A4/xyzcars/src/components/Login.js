import React, { Component } from 'react';
import { Link } from 'react-router-dom';

class Login extends Component {
    redirectToFBLogin = () => {
        window.location.href ="http://localhost:9090/login";  // Backend-handled Facebook Login API URL
    };


    constructor(props) {
        super(props);
        this.state = {
            username: '',
            password: '',
            error_string: null,
            success_login: null,
            success_logout: null
        };
    }

    handleInputChange = (event) => {
        this.setState({
            [event.target.name]: event.target.value
        });
    }

    handleSubmit = async (event) => {
        event.preventDefault();
        
        const loginResponse = await fetch(`/login?userName=${encodeURIComponent(this.state.username)}&password=${encodeURIComponent(this.state.password)}`);
        const loginData = await loginResponse.text();
            
        if (loginData === 'Login success!') {
            this.setState({ success_login: 'Successfully logged in! ', error_string: null });
        } else {
            this.setState({ error_string: 'Login failed! ', success_login: null });
        }
    
        const authResponse = await fetch(`/checkAuthentication`);
        const authData = await authResponse.json();
        
        if (authData.authenticated) {
            this.setState({ success_login: 'Successfully logged in! ', error_string: null });
        } else {
            this.setState({ error_string: 'Login failed! ', success_login: null });
        }
    } 
    
    

    render() {
        return (
            <main className="page contact-us-page">
                <section className="clean-block clean-form dark">
                    <div className="container">
                        <div className="block-heading">
                            <h2 className="text-info">Sign-in</h2>
                            <p>Come and utilize our services!</p>
                        </div>

                        {this.state.error_string && (
                            <div className="alert alert-danger">
                                {this.state.error_string}
                                Click here to <Link to="/Register"> Register</Link>
                            </div>
                        )}

                        {this.state.success_login && (
                            <div className="alert alert-success">
                                {this.state.success_login}
                                Click here to navigate to <Link to="/"> Home</Link>
                            </div>
                        )}

                        {this.state.success_logout && (
                            <div className="alert alert-success">
                                {this.state.success_logout}
                                Click here to <Link to="/login">Login</Link>
                            </div>
                        )}

                        {(!this.state.success_login && !this.state.success_logout) && (
                            <form onSubmit={this.handleSubmit} className="was-validated">
                                <div className="mb-3 mt-3">
                                    <label htmlFor="username" className="form-label">User name:</label>
                                    <input type="text" className="form-control" id="userName" 
                                           placeholder="Enter username" name="username" value={this.state.userName}
                                           onChange={this.handleInputChange} required />
                                </div>
                                <div className="mb-3">
                                    <label htmlFor="password" className="form-label">Password:</label>
                                    <input type="password" className="form-control" id="password"
                                           placeholder="Enter password" name="password" value={this.state.password}
                                           onChange={this.handleInputChange} required />
                                </div>
                                
                                
                                <input type="submit" name="Login" value="Sign In"  className="btn btn-primary"  />
                                <p>   </p>
                                <Link to="/Register" className="btn btn-primary">Register</Link>
                                <p>   </p>
                            </form>
                        )}
                        
                        <div style={{margin: '80px'}}></div>
                    </div>
                </section>
            </main>
        );
    }
}

export default Login;
