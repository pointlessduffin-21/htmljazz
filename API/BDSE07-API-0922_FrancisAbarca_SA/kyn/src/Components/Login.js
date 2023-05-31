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

                                <div className="flex-row">
            <button className="btn google">
              <svg
                xmlSpace="preserve"
                style={{ enableBackground: "new 0 0 512 512" }}
                viewBox="0 0 512 512"
                y="0px"
                x="0px"
                xmlnsXlink="http://www.w3.org/1999/xlink"
                xmlns="http://www.w3.org/2000/svg"
                id="Layer_1"
                width="20"
                version="1.1"
              >
                <path
                  d="M113.47,309.408L95.648,375.94l-65.139,1.378C11.042,341.211,0,299.9,0,256
          c0-42.451,10.324-82.483,28.624-117.732h0.014l57.992,10.632l25.404,57.644c-5.317,15.501-8.215,32.141-8.215,49.456
          C103.821,274.792,107.225,292.797,113.47,309.408z"
                  style={{ fill: "#FBBB00" }}
                ></path>
                <path
                  d="M507.527,208.176C510.467,223.662,512,239.655,512,256c0,18.328-1.927,36.206-5.598,53.451
          c-12.462,58.683-45.025,109.925-90.134,146.187l-0.014-0.014l-73.044-3.727l-10.338-64.535
          c29.932-17.554,53.324-45.025,65.646-77.911h-136.89V208.176h138.887L507.527,208.176L507.527,208.176z"
                  style={{ fill: "#518EF8" }}
                ></path>
                <path
                  d="M416.253,455.624l0.014,0.014C372.396,490.901,316.666,512,256,512
          c-97.491,0-182.252-54.491-225.491-134.681l82.961-67.91c21.619,57.698,77.278,98.771,142.53,98.771
          c28.047,0,54.323-7.582,76.87-20.818L416.253,455.624z"
                  style={{ fill: "#28B446" }}
                ></path>
                <path
                  d="M419.404,58.936l-82.933,67.896c-23.335-14.586-50.919-23.012-80.471-23.012
          c-66.729,0-123.429,42.957-143.965,102.724l-83.397-68.276h-0.014C71.23,56.123,157.06,0,256,0
          C318.115,0,375.068,22.126,419.404,58.936z"
                  style={{ fill: "#F14336" }}
                ></path>
              </svg>

              Google
            </button>
            <button className="btn fb">
            <svg className="" xmlSpace="preserve" style={{enableBackground: "new 0 0 512 512"}} viewBox="0 0 408.788 408.788" y="0" x="0" width="20" xmlnsXlink="http://www.w3.org/1999/xlink" xmlns="http://www.w3.org/2000/svg">
                <g>
                  <path className="" data-original="#475993" fill="#475993" d="M353.701 0H55.087C24.665 0 .002 24.662.002 55.085v298.616c0 30.423 24.662 55.085 55.085 55.085h147.275l.251-146.078h-37.951a8.954 8.954 0 0 1-8.954-8.92l-.182-47.087a8.955 8.955 0 0 1 8.955-8.989h37.882v-45.498c0-52.8 32.247-81.55 79.348-81.55h38.65a8.955 8.955 0 0 1 8.955 8.955v39.704a8.955 8.955 0 0 1-8.95 8.955l-23.719.011c-25.615 0-30.575 12.172-30.575 30.035v39.389h56.285a8.955 8.955 0 0 1 8.955 8.955v47.268a8.955 8.955 0 0 1-8.955 8.955H269.112l-.251 146.079h84.84c30.423 0 55.086-24.662 55.086-55.085V55.085C408.787 24.662 384.125 0 353.701 0z"></path>
                </g>
            </svg>

              Facebook
            </button>
          </div>
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
