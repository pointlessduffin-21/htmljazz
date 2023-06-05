import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';

class Login extends Component {

    componentDidMount() {
        const sessionToken = this.getCookie('sessionToken');
    
        if (sessionToken) {
            // If the session token cookie exists, automatically log the user in
            this.setState({ success_login: 'Successfully logged in! ', error_string: null });
        }
    }
    
    getCookie(name) {
        const cookie = document.cookie.split('; ').find(row => row.startsWith(name));
        return cookie?.split('=')[1];
    }
    

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
            success_logout: null,
            rememberMe: false
        };
    }

    handleInputChange = (event) => {
        this.setState({
            [event.target.name]: event.target.value
        });
    }

    handleSubmit = async (event) => {
        event.preventDefault();
    
        try {
            const loginResponse = await axios.get(`http://localhost:8546/oldLogin?userName=${encodeURIComponent(this.state.username)}&password=${encodeURIComponent(this.state.password)}`);
            const loginData = loginResponse.data;
    
            if (loginData === 'Login success!') {
                this.setState({ success_login: 'Successfully logged in! ', error_string: null });
    
                // After a successful login, store the session token in a cookie
                const sessionToken = loginResponse.data.sessionToken; // This depends on the actual response format
                document.cookie = `sessionToken=${sessionToken}; path=/`;
            } else {
                this.setState({ error_string: 'Login failed! ', success_login: null });
            }
        } catch (error) {
            console.error("An error occurred during login:", error);
            // Optionally set an error message in the state
            this.setState({ error_string: 'An error occurred during login.' });
        }
    }

    logout = async () => {
        try {
            // Call your server's logout endpoint
            // Assuming it's a POST request that expects the session token as a Bearer token
            const sessionToken = this.getCookie('sessionToken');
            await axios.post('http://localhost:8546/logout', {}, {
                headers: { Authorization: `Bearer ${sessionToken}` }
            });
    
            // Delete the session token cookie
            document.cookie = 'sessionToken=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;';
    
            // Update the state to reflect that the user is no longer logged in
            this.setState({ success_login: null, success_logout: 'Successfully logged out!' });
        } catch (error) {
            console.error("An error occurred during logout:", error);
            // Optionally set an error message in the state
            this.setState({ error_string: `An error occurred during logout. Error details: ${error.message}` });
        }
    }
    
    

    handleRememberMeChange = (event) => {
        this.setState({
            rememberMe: event.target.checked
        });
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
                                <button onClick={this.logout} className="btn btn-primary">Logout</button>
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
                                
                                <div className="mb-3">
                                    <label htmlFor="rememberMe" className="form-label">Remember me:</label>
                                    <input type="checkbox" id="rememberMe" name="rememberMe" 
                                    checked={this.state.rememberMe} 
                                    onChange={this.handleRememberMeChange} />
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
