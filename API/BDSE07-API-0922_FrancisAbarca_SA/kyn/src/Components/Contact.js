import React, {Component} from 'react';
import {Link} from 'react-router-dom';

class Contact extends Component {
    render(){
        return (
        <div>
            <h1>Contact</h1>
            <p>This is the contact page</p>
            <Link to="/">Home</Link>
        </div>
        );
    }
}

export default Contact;