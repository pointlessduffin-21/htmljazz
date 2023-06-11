import React, { Component } from 'react';
import axios from 'axios';

class Register extends Component {
    constructor(props) {
        super(props);
        this.state = {
            firstName: '',
            lastName: '',
            address: '',
            userName: '',
            userEmail: '',
            phoneNumber: '',
            password: '',
            confirmPassword: ''
        };
    }

    handleInputChange = (event) => {
        this.setState({
            [event.target.id]: event.target.value
        });
    }

    handleSubmit = async (event) => {
        event.preventDefault();
        if (this.state.password !== this.state.confirmPassword) {
            alert("Passwords do not match!");
            return;
        }
        
        const { confirmPassword, ...userData } = this.state;

        try {
            const response = await axios.post('http://localhost:8546/addUser', userData);
            if (response.status === 200) {
                alert('User registered successfully!');
            } else {
                console.error('Failed to register user, response status:', response.status);
                alert('Failed to register user. Please try again.');
            }
        } catch (error) {
            console.error('An error occurred while registering the user:', error);
            alert('An error occurred while registering. Please try again.');
        }
    }
    
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
                                <label htmlFor="userName">Username:</label>
                                <input type="text" className="form-control" id="userName" placeholder="userName" required onChange={this.handleInputChange}/>
                            </div>
                            <br />
                            <div className="form-group">
                                <label htmlFor="userEmail">Email Address:</label>
                                <input type="text" className="form-control" id="userEmail" placeholder="Email Address" required onChange={this.handleInputChange}/>
                            </div>
                            <br />
                            <div className="form-group">
                                <label htmlFor="phoneNumber">Phone Number:</label>
                                <input type="text" className="form-control" id="phoneNumber" placeholder="Phone Number" required onChange={this.handleInputChange}/>
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
