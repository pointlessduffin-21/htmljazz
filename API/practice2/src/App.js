import logo from './logo.svg';
import './App.css';
import Home from './Component/Home';
import About from './Component/About';
import { BrowserRouter as Router,Routes,Route,Link } from 'react-router-dom';

function App() {
  return (
    <Router>
    <h1>Practice 2</h1>
    <div className="App">
      <Link to="/myhome">Home</Link> 
      <Link to="/myabout">About</Link>
    </div>

    <Routes>
      <Route path="/myhome" element={<Home />} />
      <Route path="/myabout" element={<About />} />
    </Routes>
  </Router>
    
  );
}

export default App;