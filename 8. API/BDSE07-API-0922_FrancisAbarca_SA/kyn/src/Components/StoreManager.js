import React, {Component} from 'react';

class StoreManager extends Component {
    constructor(props) {
        super(props);
        this.state = {
            stores: []
        };
    }

    componentDidMount() {
        fetch('http://localhost:8546/getAllStores')
            .then(response => response.json())
            .then(data => {
                console.log(data);
                this.setState({ stores: data })
            });
    }
    
    render() {
        return (
            <main className="page contact-us-page">
                <section className="clean-block clean-form dark">
                    <div className="container">
                        <div className="block-heading">
                            <h2 className="text-info">Store Manager</h2>
                            <p>Come and utilize our services!</p>
                        </div>
                        <table className="table table-striped">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Name</th>
                                    <th>Address</th>
                                    <th>City</th>
                                    <th>State</th>
                                    <th>Zip</th>
                                    <th>Phone</th>
                                </tr>
                            </thead>
                            <tbody>
                                {this.state.stores.map((store, index) => (
                                    <tr key={index}>
                                        <td>{store.storeId}</td>
                                        <td>{store.storeName}</td>
                                        <td>{store.storeAddress}</td>
                                        <td>{store.storeCity}</td>
                                        <td>{store.storeState}</td>
                                        <td>{store.storeZip}</td>
                                        <td>{store.storePhone}</td>
                                    </tr>
                                ))}
                            </tbody>
                        </table>
                    </div>
                </section>
            </main>
        )
    }
}

export default StoreManager;
