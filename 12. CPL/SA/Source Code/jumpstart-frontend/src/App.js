import logo from './logo.svg';
import './App.css';
import { BrowserRouter as Router, Routes, Route, Switch } from 'react-router-dom';
import Home from './Components/Home';
import Login from './Components/Login';
import Register from './Components/Register';
import Chat from './Components/Chat';
import Product from './Components/Product';
import Header from './Components/Header';
import Feedback from './Components/Feedback';


function App() {
  return (
    <Router>
      <div className="App">
        <Header />
        <Routes>
          <Route exact path="/" element={<Home />} component={Home}/>
          <Route exact path="/login" element={<Login />} component={Login}/>
          <Route exact path="/register" element={<Register />} component={Register}/>
          <Route exact path="/chat" element={<Chat />} component={Chat}/>
          <Route exact path="/feedback" element={<Feedback />} component={Feedback}/>
          <Route path="/product/:id" component={Product} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
