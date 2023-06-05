import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';

class Login extends Component {
    redirectToFBLogin = () => {
        window.location.href ="http://localhost:9584/login";  // Backend-handled Facebook Login API URL
    };

    redirectToGoogleLogin = () => {
        window.location.href = "http://localhost:8546/oauth2/authorization/google";  // Backend-handled Google Login API URL
    };

    redirectToGitHubLogin = () => {
        window.location.href = "http://localhost:8546/oauth2/authorization/github";  // Backend-handled GitHub Login API URL
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
<<<<<<< HEAD
=======
        
        const loginResponse = await fetch(`/internalLogin`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                userName: this.state.username,
                password: this.state.password,
            }),
        });
        const loginData = await loginResponse.text();
            
        if (loginData === 'Login success!') {
            this.setState({ success_login: 'Successfully logged in! ', error_string: null });
        } else {
            this.setState({ error_string: 'Login failed! ', success_login: null });
        }
>>>>>>> ae4d7d62d452f92c86a7d8c6039b20afd4fa5ccc
    
        try {
            const loginResponse = await axios.get(`http://localhost:8546/oldLogin?userName=${encodeURIComponent(this.state.username)}&password=${encodeURIComponent(this.state.password)}`);
            const loginData = loginResponse.data;
    
            if (loginData === 'Login success!') {
                this.setState({ success_login: 'Successfully logged in! ', error_string: null });
            } else {
                this.setState({ error_string: 'Login failed! ', success_login: null });
            }
        } catch (error) {
            console.error("An error occurred during login:", error);
            // Optionally set an error message in the state
            this.setState({ error_string: 'An error occurred during login.' });
        }
    }
<<<<<<< HEAD
    
=======
>>>>>>> ae4d7d62d452f92c86a7d8c6039b20afd4fa5ccc

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
                            <form onSubmit={this.handleSubmit} className="was-validated ordinaryauth">
                                <div className="mb-3 mt-3">
                                    <label htmlFor="username" className="form-label">User name:</label>
                                    <input type="text" className="form-control" id="username" 
                                           placeholder="Enter username" name="username" value={this.state.username}
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
                                <div className="flex-row">
                                    <button className="btn google 3rdpartyauth" onClick={this.redirectToGoogleLogin}>
                                        <svg xmlSpace="preserve" style={{ enableBackground: "new 0 0 512 512" }} viewBox="0 0 512 512" y="0px" x="0px" xmlnsXlink="http://www.w3.org/1999/xlink" xmlns="http://www.w3.org/2000/svg" id="Layer_1" width="20" version="1.1">
                                            {/* svg code */}
                                        </svg>
                                        Google
                                    </button>
                                    <button className="btn fb" onClick={this.redirectToFBLogin}>
                                        <svg className="" xmlSpace="preserve" style={{enableBackground: "new 0 0 512 512"}} viewBox="0 0 408.788 408.788" y="0" x="0" width="20" xmlnsXlink="http://www.w3.org/1999/xlink" xmlns="http://www.w3.org/2000/svg">
                                            {/* svg code */}
                                        </svg>
                                        Facebook
                                    </button>
                                    <button className="btn github" onClick={this.redirectToGitHubLogin}>
                                        <svg className="" xmlSpace="preserve" style={{enableBackground: "new 0 0 512 512"}} viewBox="0 0 408.788 408.788" y="0" x="0" width="20" xmlnsXlink="http://www.w3.org/1999/xlink" xmlns="http://www.w3.org/2000/svg">
                                            {/* svg code */}
                                        </svg>
                                        GitHub
                                    </button>
                                </div>
                            </form>
                        )}
                    </div>
                    <div style={{margin: '80px'}}></div>
                </section>
            </main>
        );
    }
}

export default Login;
