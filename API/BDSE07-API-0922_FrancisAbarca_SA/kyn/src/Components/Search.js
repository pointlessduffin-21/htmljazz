import React, {Component} from 'react';
import {Link} from 'react-router-dom';

class Search extends Component {
    render(){
        return (
        <div>
            <h1>Search</h1>
            <p>This is the search page</p>
            <Link to="/">Home</Link>
        </div>
        );
    }
}

export default Search;