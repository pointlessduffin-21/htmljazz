import axios from 'axios';
import React, { Component } from 'react';
import { Link } from 'react-router-dom';

class Message extends Component {
    constructor() {
        super();
        this.state = {
            userName: "xyzcars",
            textMessage: "",
            messageSent: false,
        }
    }

    setMessage = (event) => {
        this.setState({
            textMessage: event.target.value
        });
    }

    message = (event) => {
        event.preventDefault();
        const { userName, textMessage } = this.state;
    
        const message = {
            text: textMessage
        };
    
        if (!textMessage) {
            alert("Please enter a message!");
            return;
        }
    
        axios.post(`messages/${userName}`, message)
    .then(res => {
        console.log(res);
        console.log(res.data);
        if (res.data === "Message sent!") {
            this.setState({ messageSent: true });
        }
    })

    .catch(error => {
        console.log(error);
    });

    }
    
    render() {
        return (
            <main className="page contact-us-page">
                <section className="clean-block clean-form dark">
                    <div className="container">
                        <div className="block-heading">
                            <h2 className="text-info">Message Us!</h2>
                            <p>We would like to hear from you!</p>
                        </div>
                        {this.state.messageSent && (
                            <div className="alert alert-success">
                                Message has been sent successfully!
                                Click here to go back <Link to="/"> Home</Link>
                            </div>
                        )}
                        {!this.state.messageSent && (
                            <form onSubmit={this.message} className="was-validated">
                                <div className="mb-3 mt-3">
                                    <label htmlFor="username" className="form-label">Message:</label>
                                    <input type="text" className="form-control" id="userName" 
                                           placeholder="Enter your message" name="textMessage" value={this.state.textMessage}
                                           onChange={this.setMessage} required />
                                </div>
                                
                                
                                <input type="submit" name="Send" value="Send"  className="btn btn-primary"  />
                            </form>
                        )}
                        
                        <div style={{margin: '80px'}}></div>
                    </div>
                </section>
            </main>
        );
    }
}

export default Message;
