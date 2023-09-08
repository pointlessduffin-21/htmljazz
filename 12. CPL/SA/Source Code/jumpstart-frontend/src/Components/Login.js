import React, { Component } from 'react';

class Login extends Component {
    render() {
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
}

export default Login;