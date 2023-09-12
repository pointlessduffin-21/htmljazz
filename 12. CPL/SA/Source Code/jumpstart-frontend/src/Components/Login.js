import Register from './register';
import React,  { Component } from 'react';
import { Link } from 'react-router-dom';

class Login extends Component {
    constructor(props) {
        super(props);
        this.state = {
            email: '',
            password: ''
        };

        this.handleInputChange = this.handleInputChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleInputChange(event) {
        this.setState({
            [event.target.id]: event.target.value
        });
    }

    handleSubmit(event) {
        event.preventDefault();
    
        const data = {
            email: this.state.email,
            password: this.state.password
        };
    
        fetch('http://localhost:9583/api/user/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        })
        .then(response => {
            if (response.ok) {
                // Login successful
                console.log('Login successful');
            } else {
                // Login failed
                console.log('Login failed');
            }
        })
        .catch((error) => {
          console.error('Error:', error);
        });
    }

    render() {
        return (
            <main className="page contact-us-page">
                <section className="clean-block clean-form dark">
                    <div className="container">
                        <div className="block-heading">
                            <h2 className="text-info text-black">Login</h2>
                            <p className="text-black">Access your account</p>
                        </div>
                        <form onSubmit={this.handleSubmit} className="was-validated">
                            <div className="form-group">
                                <label htmlFor="email">Email:</label>
                                <input type="email" className="form-control" id="email" placeholder="Email" required onChange={this.handleInputChange}/>
                            </div>
                            <br />
                            <div className="form-group">
                                <label htmlFor="password">Password:</label>
                                <input type="password" className="form-control" id="password" placeholder="Password" required onChange={this.handleInputChange}/>
                            </div>
                            <br />
                            <input type="submit" value="Login" className="btn btn-primary"/>
                            <a>              </a>
                            <Link to="/Register" className="btn btn-primary">Register</Link>
                        </form>
                        <div style={{margin: '80px'}}></div>
                    </div>
                </section>
            </main>
        );
    }
}

export default Login;
