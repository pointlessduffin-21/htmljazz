import React, { Component } from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faBars } from '@fortawesome/free-solid-svg-icons';

class Yeems214 extends Component {
    render() {
        return (
            <div id="page-top">
                <a className="menu-toggle rounded" href="#"><FontAwesomeIcon icon={faBars} /></a>
                <nav className="navbar navbar-light navbar-expand deez" id="sidebar-wrapper">
                    <div className="container">
                        <div className="collapse navbar-collapse">
                            <ul className="navbar-nav sidebar-nav" id="sidebar-nav">
                                <li className="nav-item sidebar-brand"><a className="nav-link active js-scroll-trigger" href="#page-top">yeems214</a></li>
                                <li className="nav-item sidebar-nav-item"><a className="nav-link js-scroll-trigger" href="#page-top">Home</a></li>
                                <li className="nav-item sidebar-nav-item"><a className="nav-link js-scroll-trigger" href="#about">About</a></li>
                                <li className="nav-item sidebar-nav-item"><a className="nav-link js-scroll-trigger" href="#services">Services</a></li>
                            </ul>
                        </div>
                    </div>
                </nav>

                <header className="d-flex masthead">
                    <div className="container my-auto text-center text-black" style={{zIndex: 0}}>
                        <h1 className="mb-1">yeems214</h1>
                        <h3 className="mb-5"><em>Developer | System Engineer | Video Editor | Audio Editor | Nerd</em></h3>
                        <a className="btn btn-primary btn-xl js-scroll-trigger" role="button" href="#about">More Info</a>
                    </div>
                </header>
                
            </div>
        );
    }
};

export default Yeems214; // This line exports the yeems214 component
