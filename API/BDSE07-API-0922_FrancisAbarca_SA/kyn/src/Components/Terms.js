import React, {Component} from 'react';
import {Link} from 'react-router-dom';
import '../Styles/Terms.css';

class Terms extends Component {
    render() {
        return (
            <div className="terms-container">
                <h1 className="terms-heading">Terms and Conditions</h1>
                <p className="terms-text">Welcome to Know Your Neighborhood!</p>
                <p className="terms-text">By using our website, you agree to the following terms and conditions:</p>
                <ol className="terms-list">
                    <li>You may use our website to search for businesses in your area.</li>
                    <li>You may not use our website for any illegal or unauthorized purpose.</li>
                    <li>We do not guarantee the accuracy or completeness of the information provided on our website.</li>
                    <li>We are not responsible for any errors or omissions in the information provided on our website.</li>
                    <li>We reserve the right to modify or discontinue our website at any time without notice.</li>
                    <li>We reserve the right to refuse service to anyone for any reason at any time.</li>
                    <li>Your use of our website is at your sole risk. We are not liable for any damages arising from your use of our website.</li>
                </ol>
                <p className="terms-text">By using our website, you agree to these terms and conditions. If you do not agree to these terms and conditions, you may not use our website.</p>
                <Link to="/" className="terms-link">Go back to home page</Link>
            </div>
        );
    }
}

export default Terms;