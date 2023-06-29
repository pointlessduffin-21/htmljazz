import React, {Component} from 'react';
import {Link} from 'react-router-dom';

class Terms extends Component {
    render() {
        return (
            <section class="clean-block features">
            <div class="container">
                <div class="block-heading">
                    <h2 class="text-info">Terms and Conditions</h2>
                    <p>Welcome to Know Your Neighborhood!</p>
                    <p>By using our website, you agree to the following terms and conditions:</p>
                    <p>You may use our website to search for businesses in your area.</p>
                    <p>You may not use our website for any illegal or unauthorized purpose.</p>
                    <p>We do not guarantee the accuracy or completeness of the information provided on our website.</p>
                    <p>We are not responsible for any errors or omissions in the information provided on our website.</p>
                    <p>We reserve the right to modify or discontinue our website at any time without notice.</p>
                    <p>We reserve the right to refuse service to anyone for any reason at any time.</p>
                    <p>Your use of our website is at your sole risk. We are not liable for any damages arising from your use of our website.</p>
                    <p className="terms-text">By using our website, you agree to these terms and conditions. If you do not agree to these terms and conditions, you may not use our website.</p>
                <Link to="/" className="terms-link">Go back to home page</Link>
                </div>
            </div>
        </section>
        );
    }
}

export default Terms;