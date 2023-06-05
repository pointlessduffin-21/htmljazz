import React, {useState} from 'react';
import Header from './Components/Header';
import Footer from './Components/Footer';
import Home from './Components/Home';
import Login from './Components/Login';
import Register from './Components/Register';
import Terms from './Components/Terms';
import About from './Components/About';
import Contact from './Components/Contact';
import Search from './Components/Search';
import StoreManager from './Components/StoreManager';
import axios from 'axios';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import logo from './logo.svg';
import './App.css';

function App() {

  const [success, setSuccess] = useState(JSON.parse(localStorage.getItem('success')) || false);
  const [loggedIn, setLoggedIn] = useState(false);

  const logout = () => {
    setSuccess(false);
    setLoggedIn(false);
    localStorage.removeItem('success');
    window.location.reload();
  };

  const login = async (userName, password) => {
    try {
      const response = await axios.post('http://localhost:8546/internalLogin', { userName, password });

      if (response.data === 'Login success!') {
        console.log('Login successful');
        setSuccess(true);
        setLoggedIn(true);
        localStorage.setItem('success', JSON.stringify(true));
      } else {
        console.log('Login failed');
      }
    } catch (error) {
      console.log('Login failed:', error);
    }
  };

  return (
    <Router>
      <div className="App">
      <Header success={success} logout={logout} />
        <Routes>
          <Route exact path="/" element={<Home />} component={Home}/>
          <Route path="/about" element={<About />} />
          {/* <Route path="/storemanager" element={<StoreManager />} /> */}
          <Route path="/contact" element={<Contact />} />
          <Route path="/login" element={<Login login={login} loggedIn={loggedIn} setLoggedIn={setLoggedIn} component={Login}/>} />
          <Route path="/search" element={<Search />} />
          <Route path="/register" element={<Register />} />
          <Route path="/Terms" element={<Terms />} />
        </Routes>
        <Footer />
        </div>
      </Router>
  );
}

export default App;