import React, { Component } from 'react';

class Chat extends Component {
    render() {
        return (
            <div className="llama2" style={{height: '90vh', width: '100vw'}}>
                <iframe src="http://localhost:8008/" title="Chat with JumpBot" style={{height: '100%', width: '100%'}} />
            </div>
        );
    }
}

export default Chat;
