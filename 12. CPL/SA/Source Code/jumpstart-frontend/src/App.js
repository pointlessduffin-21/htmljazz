import logo from './logo.svg';
import './App.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Home from './Components/home';
import Login from './Components/login';
import Register from './Components/register';
import Chat from './Components/chat';
import Product from './Components/product';
import Header from './Components/header';


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
          <Route exact path="/product" element={<Product />} component={Product}/>
        </Routes>
      </div>
    </Router>
  );
}

export default App;
