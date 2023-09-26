import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';
import $ from 'jquery';

const Login = ({ login, loggedIn, setLoggedIn }) => {  // receive onLogin as a prop from App.js
    const [userName, setUserName] = useState('');
    const [password, setPassword] = useState('');
    const [userDetails, setUserDetails] = useState({});

    const [success, setSuccess] = useState(() => {
        try {
            return JSON.parse(localStorage.getItem('success')) || false;
        } catch {
            return false;
        }
    });

    const [name, setName] = useState(() => {
        try {
            return JSON.parse(localStorage.getItem('name')) || "";
        } catch {
            return "";
        }
    });

    const [state, setState] = useState({
        username: '',
        password: '',
        error_string: null,
        success_login: null,
        success_logout: null,
    });

    const redirectToFBLogin = () => {
        window.location.href = "http://localhost:9584/login";
        setLoggedIn(true);
        setSuccess(true);
        setName(userDetails.name);
    };

    const redirectToGoogleLogin = () => {
        window.location.href = "http://localhost:8546/oauth2/authorization/google";
    };

    const redirectToGitHubLogin = () => {
        window.location.href = "http://localhost:8546/oauth2/authorization/github";
    };

    useEffect(() => {
        try {
            const name = JSON.parse(localStorage.getItem('name'));
            if (name) {
                setName(name);
            }
        } catch (error) {
            console.error('Error parsing name from localStorage:', error);
        }

        try {
            const success = JSON.parse(localStorage.getItem('success'));
            if (typeof success === 'boolean') {
                setSuccess(success);
            }
        } catch (error) {
            console.error('Error parsing success from localStorage:', error);
        }
    }, []);

    useEffect(() => {
        try {
            localStorage.setItem('success', JSON.stringify(success));
            localStorage.setItem('name', JSON.stringify(name));
        } catch (error) {
            console.error('Error setting localStorage:', error);
        }
    }, [success, name]);
    

    const handleInputChange = (event) => {
        const { name, value } = event.target;
        setState({
          ...state,
          [name]: value,
        });
      };

    const handleSubmit = async (event) => {
        event.preventDefault();
        
        try {
            const user = { userName: state.username, password: state.password };
            const loginResponse = await axios.post(`http://localhost:8546/internalLogin`, user, { withCredentials: true });
            const loginData = loginResponse.data;
    
            if (loginData === 'Login success!') {
                handleLogin(state.username, state.password);
                localStorage.setItem('success', JSON.stringify(success));
                localStorage.setItem('name', JSON.stringify(name));
                setState({ ...state, success_login: 'Successfully logged in as ${state.username}! ', error_string: null , success_login: true});
                login(state.username, state.password); // Use the login function passed in props
                setLoggedIn(true);  // Set loggedIn to true when a user successfully logs in
            } else {
                setState({ ...state, error_string: 'Login failed! Check your user name or password! ', success_login: null });
                setLoggedIn(false);  // Set loggedIn to false when a user fails to log in
            }
        } catch (error) {
            console.error("An error occurred during login:", error);
            setState({ ...state, error_string: 'An error occurred during login.' });
            setLoggedIn(false);  // Set loggedIn to false when an error occurs
        }
    };

    const handleLogout = async () => {
        // Make an API request to log out from the server. This is an example, and it
        // depends on how your server handles logout.
        try {
          await axios.post('http://localhost:8546/logout');
        } catch (error) {
          console.error("An error occurred during logout:", error);
        }
      
        // Update the loggedIn state to false after logging out
        setLoggedIn(false);
        localStorage.removeItem('loggedIn'); // Remove the loggedIn key from localStorage
      };
      
      const handleLogin = (username, password) => {
        login(username, password);
        const isLoggedIn = localStorage.getItem('loggedIn');
        if (!isLoggedIn) {
          setLoggedIn(true);
          localStorage.setItem('loggedIn', true);
        }
      };

            return (
                <main className="page contact-us-page">
                    <section className="clean-block clean-form dark">
                        <div className="container">
                            <div className="block-heading">
                                <h2 className="text-info">Sign-in</h2>
                                <p>Come and utilize our services!</p>
                            </div>

                            {state.error_string && (
                                state.error_string && (
                                    <div className="alert alert-danger">
                                        {state.error_string}
                                        Click here to <Link to="/Register"> Register</Link>
                                    </div>
                                )
                            )}

                            {userDetails.name && (
                                <div className="alert alert-success">
                                    Successfully logged in as {userDetails.name}!
                                    Click here to navigate to <a href="http://localhost:3000">Home</a>
                                </div>
                            )}

                            {state.success_login && (
                                <div className="alert alert-success">
                                    {state.success_login}
                                    Successfully logged in as {state.username} {userDetails.name}!
                                    Click here to navigate to <Link to={{ pathname: '/', state: { username: state.username } }}>Home</Link>
                                </div>
                            )}

                            {state.success_logout && (
                                <div className="alert alert-success">
                                    {state.success_logout}
                                    Click here to <Link to="/login">Login</Link>
                                </div>
                            )}

                            {(!state.success_login && !state.success_logout) && (
                                <form onSubmit={handleSubmit} className="was-validated ordinaryauth">
                                    <div className="mb-3 mt-3">
                                        <label htmlFor="username" className="form-label">User name:</label>
                                        <input type="text" className="form-control" id="username" 
                                                     placeholder="Enter username" name="username" value={state.username}
                                                     onChange={handleInputChange} required />
                                    </div>
                                    <div className="mb-3">
                                        <label htmlFor="password" className="form-label">Password:</label>
                                        <input type="password" className="form-control" id="password"
                                                     placeholder="Enter password" name="password" value={state.password}
                                                     onChange={handleInputChange} required />
                                    </div>
                                    
                                    
                                    <input type="submit" name="Login" value="Sign In"  className="btn btn-primary"  />
                                    <p>   </p>
                                    <Link to="/Register" className="btn btn-primary">Register</Link>
                                    <p>   </p>
                                    <div className="flex-row">
                                        <button className="btn btn-primary " onClick={redirectToFBLogin}>
                                            <i className="bi bi-facebook"></i> Login with
                                            Facebook
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

export default Login;
