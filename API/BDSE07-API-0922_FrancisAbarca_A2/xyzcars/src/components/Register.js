import React, {Component} from 'react';

class Register extends Component {
    render() {
        return (
            <><div>
                <h1>Register</h1>
                <p>Register here.</p>
            </div><form>
                    <div className="form-group">
                        <label htmlFor="firstName">First Name:</label>
                        <input type="text" className="form-control" id="firstName" placeholder="First Name" required/>
                    </div>
                    <div className="form-group">
                        <label htmlFor="lastName">Last Name:</label>
                        <input type="text" className="form-control" id="lastName" placeholder="Last Name" required/>
                    </div>
                    <div className="form-group">
                        <label htmlFor="address">Address:</label>
                        <input type="text" className="form-control" id="address" placeholder="Address" required/>
                    </div>
                    <div className="form-group">
                        <label htmlFor="username">Username:</label>
                        <input type="text" className="form-control" id="username" placeholder="Username" required/>
                    </div>
                    <div className="form-group">
                        <label htmlFor="email">Email:</label>
                        <input type="text" className="form-control" id="email" placeholder="Email" required/>
                    </div>
                    <div className="form-group">
                        <label htmlFor="phone">Phone Number:</label>
                        <input type="text" className="form-control" id="phone" placeholder="Phone" required/>
                    </div>
                    <div className="form-group">
                        <label htmlFor="password">Password:</label>
                        <input type="text" className="form-control" id="password" placeholder="Password" required/>
                    </div>
                    <div className="form-group">
                        <label htmlFor="password">Confirm Password:</label>
                        <input type="text" className="form-control" id="password" placeholder="Password" required/>
                    </div>
                    <div className="form-group">
                        <label htmlFor="button">Register</label>
                        <button type="submit" className="btn btn-primary">Register</button>
                    </div>
                </form></>
        )
    }
}

export default Register;