import React, { Component } from 'react';

class Chat extends Component {
    render() {
        return (
            <div className="llama2" style={{height: '90vh', width: '100vw'}}>
                <iframe src="http://localhost:8008/chat/d4219a97-ac5f-426d-9aa5-45096731c650" title="Chat with JumpBot" style={{height: '100%', width: '100%'}} />
            </div>
        );
    }
}

export default Chat;
