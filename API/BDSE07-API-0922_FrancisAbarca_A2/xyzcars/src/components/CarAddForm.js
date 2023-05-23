import React, {Component} from 'react';

class CarAddForm extends Component {
    render() {
        return (
            <div>
                <h1>Add a Car</h1>
                <form>
                    <div className="form-group">
                        <label htmlFor="make">Make</label>
                        <input type="text" className="form-control" id="make" placeholder="Make" />
                    </div>
                    <div className="form-group">
                        <label htmlFor="model">Model</label>
                        <input type="text" className="form-control" id="model" placeholder="Model" />
                    </div>
                    <div className="form-group">
                        <label htmlFor="year">Year</label>
                        <input type="text" className="form-control" id="year" placeholder="Year" />
                    </div>
                    <div className="form-group">
                        <label htmlFor="price">Price</label>
                        <input type="text" className="form-control" id="price" placeholder="Price" />
                    </div>
                    <div className="form-group">
                        <label htmlFor="description">Description</label>
                        <textarea className="form-control" id="description" rows="3"></textarea>
                    </div>
                    <div className="form-group">
                        <label htmlFor="button">Add Car</label>
                        <button type="submit" className="btn btn-primary">Add Car</button>
                    </div>
                </form>
            </div>
        )
    }
}