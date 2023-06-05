// BEGIN: ed8c6549bwf9
import React, {Component} from 'react';
import {Link} from 'react-router-dom';

class Home extends Component {
    render() {
        return (
            <div>
                <main class="page landing-page">
                    <section className="clean-block clean-hero" style={{ color: 'rgba(31,28,140,0.35)', background: 'url(https://gpupv.yeems214.xyz/R%20e%20p%20o%20s%20i%20t%20o%20r%20y/neighborhood.jpg) center / cover space' }}>
                        <div className="text">
                            <h2>Know Your Neighborhood</h2>
                            <p>Unearth the Charm, Discover Your Neighborhood!</p>
                            <button className="btn btn-outline-light btn-lg" type="button">Learn More</button>
                        </div>
                    </section>
                    <section className="clean-block clean-info dark">
                        <div className="container">
                            <div className="block-heading">
                                <h2 className="text-info">Our Goal</h2>
                                <p>Our Goal for Know Your Neighborhood is to help people know the available stores and events in the area.</p>
                            </div>
                        </div>
                    </section>
        <section class="clean-block features">
            <div class="container">
                <div class="block-heading">
                    <h2 class="text-info">Our Perks</h2>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc quam urna, dignissim nec auctor in, mattis vitae leo.</p>
                </div>
                <div class="row justify-content-center">
                    <div class="col-md-5 feature-box"><i class="icon-star icon"></i>
                        <h4>Community Connection</h4>
                        <p>Knowing your neighborhood helps build a sense of community, fostering bonds with your neighbors, and creating a welcoming and secure environment.</p>
                    </div>
                    <div class="col-md-5 feature-box"><i class="icon-pencil icon"></i>
                        <h4>Local Exploration</h4>
                        <p>Discovering local shops, parks, restaurants, and historical sites can enrich your daily life and give you a greater appreciation for where you live.</p>
                    </div>
                    <div class="col-md-5 feature-box"><i class="icon-screen-smartphone icon"></i>
                        <h4>Safety Awareness</h4>
                        <p>Understanding your neighborhood's layout and typical patterns can make you more alert to any unusual activity, enhancing the overall safety of your community.</p>
                    </div>
                    <div class="col-md-5 feature-box"><i class="icon-refresh icon"></i>
                        <h4>Resource Optimization</h4>
                        <p>Familiarity with local resources and services, such as libraries, community centers, and recycling facilities, enables you to make the most of what your neighborhood has to offer.</p>
                    </div>
                </div>
            </div>
        </section>
    </main>
            </div>
        );
    }
}

export default Home;