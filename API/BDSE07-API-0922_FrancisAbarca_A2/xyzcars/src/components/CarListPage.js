import React, {Component} from 'react';

class CarListPage extends Component {
    render() {
        return (
            <div>
                <h1>Car List</h1>
                <table className="table table-striped">
                    <thead>
                        <tr>
                            <th>Make</th>
                            <th>Model</th>
                            <th>Year</th>
                            <th>Price</th>
                            <th>Description</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Toyota</td>
                            <td>Camry</td>
                            <td>2018</td>
                            <td>$25,000</td>
                            <td>Great car!</td>
                        </tr>
                        <tr>
                            <td>Toyota</td>
                            <td>Camry</td>
                            <td>2018</td>
                            <td>$25,000</td>
                            <td>Great car!</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        )
    }
}

export default CarListPage;