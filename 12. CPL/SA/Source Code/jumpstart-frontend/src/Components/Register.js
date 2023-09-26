import React, { Component } from 'react';

class Register extends Component {

//     constructor(props) {
//         super(props);
//         this.state = {
//             name: '',
//             username: '',
//             address: '',
//             phoneNumber: '',
//             email: '',
//             password: ''
//         };
//     }

//     handleInputChange = (event) => {
//         this.setState({
//             [event.target.id]: event.target.value
//         });
//     }

//     handleSubmit(event) {
//     event.preventDefault();

//     const data = {
//         name: this.state.name,
//         username: this.state.username,
//         address: this.state.address,
//         phoneNumber: this.state.phoneNumber,
//         email: this.state.email,
//         password: this.state.password,
//         confirmPassword: this.state.confirmPassword
//     };

//     fetch('http://localhost:9583/api/user/register', {
//         method: 'POST',
//         headers: {
//             'Content-Type': 'application/json'
//         },
//         body: JSON.stringify(data)
//     })
//     .then(response => response.json())
//     .then(data => console.log(data))
//     .catch((error) => {
//       console.error('Error:', error);
//     });
// }

    render() {
        return (
            <main className="page contact-us-page">
                <section className="clean-block clean-form dark">
                    <div className="container">
                        <div className="block-heading">
                            <h2 className="text-info text-black">Register</h2>
                            <p className="text-black">Come and utilize our services!</p>
                        </div>
                        <form onSubmit={this.handleSubmit} className="was-validated">
                            <div className="form-group">
                                <label htmlFor="name">Name:</label>
                                <input type="text" className="form-control" id="name" placeholder="Name" required onChange={this.handleInputChange}/>
                            </div>
                            <br />
                            <div className="form-group">
                                <label htmlFor="username">Username:</label>
                                <input type="text" className="form-control" id="username" placeholder="Username" required onChange={this.handleInputChange}/>
                            </div>
                            <br />
                            <div className="form-group">
                                <label htmlFor="address">Address:</label>
                                <input type="text" className="form-control" id="address" placeholder="Address" required onChange={this.handleInputChange}/>
                            </div>
                            <br />
                            <div className="form-group">
                                <label htmlFor="phoneNumber">Phone Number:</label>
                                <input type="text" className="form-control" id="phoneNumber" placeholder="Phone Number" required onChange={this.handleInputChange}/>
                            </div>
                            <br />
                            <div className="form-group">
                                <label htmlFor="email">Email Address:</label>
                                <input type="text" className="form-control" id="email" placeholder="Email Address" required onChange={this.handleInputChange}/>
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
                            <input type="submit" value="Register" className="btn btn-primary"/>
                        </form>
                        <div style={{margin: '80px'}}></div>
                    </div>
                </section>
            </main>
        );
    }
    
}

export default Register;
