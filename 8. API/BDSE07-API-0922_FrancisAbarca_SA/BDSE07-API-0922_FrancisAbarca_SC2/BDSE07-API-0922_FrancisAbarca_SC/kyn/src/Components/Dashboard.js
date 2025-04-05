import React, {Component} from 'react';
import {Link} from 'react-router-dom';

class Dashboard extends Component {
    render(){
        return (
        <div>
            <h1>Dashboard</h1>
            <p>This is the dashboard page</p>
            <Link to="/">Home</Link>
        </div>
        );
    }
}

export default Dashboard;