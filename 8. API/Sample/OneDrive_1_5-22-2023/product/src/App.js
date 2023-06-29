import axios from 'axios';
import React,{Component} from 'react';
import AddComponent from './component/AddComponent';
import ShowProduct from './component/ShowProduct';
import {BrowserRouter as Router,Route,Link} from "react-router-dom";
import SearchProduct from './component/SearchProduct';

/*
 */
class App extends Component{
  
  constructor(){
    super();
   this.state={
    products:[]
    
}}

componentDidMount(){
  axios.get('showData')
  .then(res=>{   
   this.setState({
     products:res.data
   })
  })
  .catch(error=>{
    console.log(error);
  })
}
  
    render(){
      return(
       <Router>
         
       <div>
       <h1>Product Managment System</h1> 
       <Link to="/add">ADD Product</Link>&nbsp; &nbsp;&nbsp;&nbsp;
       <Link to="/show">Show Product</Link>&nbsp; &nbsp;&nbsp;&nbsp;
       <Link to="/search">Search Product</Link>&nbsp; &nbsp;&nbsp;&nbsp;
        
        <Route path="/add">
            <AddComponent></AddComponent>
        </Route>
        <Route path="/show">
            <ShowProduct alldata={this.state.products}></ShowProduct>
        </Route>
        <Route path="/search">
           <SearchProduct></SearchProduct>
        </Route>
       </div>

       </Router>

        
      )
    }
}

export default App;