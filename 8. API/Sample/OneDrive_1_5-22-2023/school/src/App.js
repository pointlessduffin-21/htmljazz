import React,{Component } from 'react';
import './App.css';
import Home from './Comp/Home';
import About from './Comp/About';
import {BrowserRouter as Router,Route,Link} from "react-router-dom";

class App extends Component {
  render(){
  return (
    <div>
<Home></Home>
</div>
  );
}

}

export default App;
