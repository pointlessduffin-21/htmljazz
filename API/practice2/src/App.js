import logo from './logo.svg';
import './App.css';
import Home from './Component/Home';
import About from './Component/About';
import Yeems214 from './Component/yeems214';
import { BrowserRouter as Router,Routes,Route,Link } from 'react-router-dom';

function App() {
  return (
    <Router>
    <h1>Practice 2</h1>
    <div className="App">
      <Link to="/myhome">Home</Link> 
      <Link to="/myabout">About</Link>
      <Link to="/yeems214">yeems214</Link>
    </div>

    <Routes>
      <Route path="/myhome" element={<Home />} />
      <Route path="/myabout" element={<About />} />
      <Route path="/yeems214" element={<Yeems214 />} />
    </Routes>
  </Router>
    
  );
}

export default App;