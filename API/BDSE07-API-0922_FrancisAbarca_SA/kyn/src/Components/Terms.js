import React, {Component} from 'react';
import {Link} from 'react-router-dom';

class Terms extends Component {
    render(){
        return (
        <div>
            <h1>Terms</h1>
            <p>This is the terms page</p>
            <Link to="/">Home</Link>
        </div>
        );
    }
}

export default Terms;