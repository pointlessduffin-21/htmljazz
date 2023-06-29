import React, { Component } from 'react';

class SearchResult extends Component {
    constructor(props) {
        super(props);
        this.state = {
            searchTerm: '',
            searchResults: [],
        };
    }

    handleInputChange = (event) => {
        this.setState({
            searchTerm: event.target.value
        });
    }

    handleSubmit = async (event) => {
        event.preventDefault();

        const response = await fetch(`/searchUser?key=${encodeURIComponent(this.state.searchTerm)}`);
        const data = await response.json();
        
        this.setState({ searchResults: data });
    }

    render() {
        return (
            <main className="page contact-us-page">
                <section className="clean-block clean-form dark">
                    <div className="container">
                        <div className="block-heading">
                            <h2 className="text-info">Search</h2>
                            <p>Come and utilize our services!</p>
                        </div>

                        <form onSubmit={this.handleSubmit} className="mb-3">
                            <input type="text" placeholder="Search term" value={this.state.searchTerm} onChange={this.handleInputChange} />
                            <input type="submit" value="Search" className="btn btn-primary" />
                        </form>

                        <table className="table table-striped">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>First Name</th>
                                    <th>Last Name</th>
                                    <th>Username</th>
                                    <th>Email</th>
                                    <th>Phone</th>
                                </tr>
                            </thead>
                            <tbody>
                                {this.state.searchResults.map((user, index) => (
                                    <tr key={index}>
                                        <td>{user.userId}</td>
                                        <td>{user.firstName}</td>
                                        <td>{user.lastName}</td>
                                        <td>{user.userName}</td>
                                        <td>{user.userEmail}</td>
                                        <td>{user.phoneNumber}</td>
                                    </tr>
                                ))}
                            </tbody>
                        </table>
                    </div>
                </section>
            </main>
        );
    }
}

export default SearchResult;
