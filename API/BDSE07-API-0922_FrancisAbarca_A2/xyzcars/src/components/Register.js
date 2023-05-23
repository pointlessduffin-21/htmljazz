import React, { Component } from 'react';
import { Link } from 'react-router-dom';

class Register extends Component {
    constructor(props) {
        super(props);

        this.state = {
            form: {
                firstName: '',
                lastName: '',
                address: '',
                username: '',
                email: '',
                phone: '',
                password: '',
                confirmPassword: ''
            },
        };
    }

    handleInputChange = (event) => {
        this.setState({
            form: {
                ...this.state.form,
                [event.target.id]: event.target.value,
            }
        });
    }

    handleSubmit = (event) => {
        event.preventDefault();
        console.log(this.state.form);
        // submit the form here
    };

    render() {
        return (
            <main className="page contact-us-page">
                <section className="clean-block clean-form dark">
                    <div className="container">
                        <div className="block-heading">
                            <h2 className="text-info">Register</h2>
                            <p>Come and utilize our services!</p>
                        </div>

                        <form onSubmit={this.handleSubmit} className="was-validated">
                            <div className="form-group">
                                <label htmlFor="firstName">First Name:</label>
                                <input type="text" className="form-control" id="firstName" placeholder="First Name" required onChange={this.handleInputChange}/>
                            </div>
                            <br />
                            <div className="form-group">
                                <label htmlFor="lastName">Last Name:</label>
                                <input type="text" className="form-control" id="lastName" placeholder="Last Name" required onChange={this.handleInputChange}/>
                            </div>
                            <br />
                            <div className="form-group">
                                <label htmlFor="address">Address:</label>
                                <input type="text" className="form-control" id="address" placeholder="Address" required onChange={this.handleInputChange}/>
                            </div>
                            <br />
                            <div className="form-group">
                                <label htmlFor="username">Username:</label>
                                <input type="text" className="form-control" id="address" placeholder="Username" required onChange={this.handleInputChange}/>
                            </div>
                            <br />
                            <div className="form-group">
                                <label htmlFor="email">Email Address:</label>
                                <input type="text" className="form-control" id="email" placeholder="Email Address" required onChange={this.handleInputChange}/>
                            </div>
                            <br />
                            <div className="form-group">
                                <label htmlFor="phone">Phone Number:</label>
                                <input type="text" className="form-control" id="phone" placeholder="Phone Number" required onChange={this.handleInputChange}/>
                            </div>
                            <br />
                            <div className="form-group">
                                <label htmlFor="password">Password:</label>
                                <input type="password" className="form-control" id="password" placeholder="Password" required onChange={this.handleInputChange}/>
                            </div>
                            <br />
                            <div className="form-group">
                                <label htmlFor="confirmPassword">Confirm Password:</label>
                                <input type="password" className="form-control" id="confirmPassword" placeholder="Confirm Password" required onChange={this.handleInputChange}/>
                            </div>
                            <br />
                            <input type="submit" value="Register" className="btn btn-primary" />
                        </form>
                        
                        <div style={{margin: '80px'}}></div>
                    </div>
                </section>
            </main>
        );
    }
}

export default Register;
