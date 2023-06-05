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
import axios from 'axios';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import logo from './logo.svg';
import './App.css';

function App() {

  const [success, setSuccess] = useState(
    JSON.parse(localStorage.getItem('success')) || false
  );

  // const navigate = useNavigate();


  const handleLogout = () => {
    setSuccess(false);
    localStorage.removeItem('success');
    window.location.reload();
  };

  const handleSubmit = async (username, password) => {
    // event.preventDefault();

    try {
      const response = await axios.post('http://localhost:8546/internalLogin', { username, password });

      if (response.data === 'Login success!') {
        this.setState({ success_login: 'Successfully logged in! ', error_string: null });
        // navigate('/home');
        setSuccess(true);
        localStorage.setItem('success', JSON.stringify(true));
      } else {
        this.setState({ error_string: 'Login failed! ', success_login: null });
      }
    } catch (error) {
      console.error("An error occurred during login:", error);
      this.setState({ error_string: 'An error occurred during login.' });
    }
    
  };

  return (
    <Router>
      <div className="App">
        <Header />
        <Routes>
          <Route exact path="/" element={<Home />} />
          <Route path="/about" element={<About />} />
          <Route path="/contact" element={<Contact />} />
          <Route path="/login" element={<Login />} />
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
