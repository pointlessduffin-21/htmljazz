import React, {Component} from 'react';
import {Link} from 'react-router-dom';

class Home extends Component {
    render() {
        return (
            <main className="page contact-us-page">
            <section className="clean-block clean-hero" style={{ color: 'rgba(31,28,140,0.35)', background: 'url(https://gpupv.yeems214.xyz/R%20e%20p%20o%20s%20i%20t%20o%20r%20y/dealership.jpg) center / cover space' }}>
                <div className="text">
                    <h2>
                        <br/>
                        <span style={{ color: 'rgb(237, 235, 233)', backgroundColor: 'rgba(255, 255, 255, 0.1)' }}>ABC Cars</span>
                    </h2>
                    <p>Established with a passion for excellence, ABC Cars has been delivering Always Better Choices to our valued customers since 2021.</p>
                    <Link to="/Register">
                        <button className="btn btn-outline-light btn-lg" type="button">Join Us!</button>
                    </Link>
                </div>
            </section>
            <section className="clean-block features">
                <div className="container">
                    <div className="block-heading">
                        <h2 className="text-info">Make yourself at home.</h2>
                        <p>Here at ABC Cars, we care about your customer service.</p>
                    </div>
                    <div className="row justify-content-center">
                        <div className="col-md-5 feature-box">
                            <i className="icon-grid icon"></i>
                            <h4>Have an account? Log-in</h4>
                            <Link to="/Login" className="btn btn-primary">Login</Link>
                        </div>
                        <div className="col-md-5 feature-box">
                            <i className="icon-pencil icon"></i>
                            <h4>Don't have an account? Create one here</h4>
                            <Link to="/Register" className="btn btn-primary">Register</Link>
                        </div>
                    </div>
                </div>
            </section>
        </main>
        )
    }
}

export default Home;