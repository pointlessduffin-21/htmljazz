import React, {Component} from 'react';
import {Link} from 'react-router-dom';

class Contact extends Component {
    render(){
        return (
            <main className="page contact-us-page">
        <section className="clean-block clean-form dark">
            <div className="container">
                <div className="block-heading">
                    <h2 className="text-info">Contact Us</h2>
                    <p>Need more information? Contact us through the following:</p>
                </div>
                <form>
                    <div className="mb-3">
                        <h3>Email</h3> 
                        <p>support@kyn.org</p>
                    </div>
                    <div className="mb-3">
                        <h3>Phone Number</h3> 
                        <p>+1 (855) 222-1111</p>
                    </div>
                    <div className="mb-3">
                        <h3>Address</h3> 
                        <p>123 Maple Street</p>
                         <p>   Springfield, FA 98765 </p>
                          <p>  United States</p>
                    </div>
                </form>
            </div>
        </section>
    </main>
        );
    }
}

export default Contact;