import axios from 'axios';
import React,{Component } from 'react';

class SearchProduct  extends Component{
    constructor(props){
       super(props);
       this.state={
        searchtype:'',
        searchlower:'',
        searchhigher:'',
        searchcato:'',
        displaysearchdata:[]

       }
    }

changeofInput=(event)=>{
    this.setState({
        [event.target.id]:event.target.value
    })
}

searchMyData=(event)=>{
   alert(this.state.searchhigher+" "+this.state.searchlower+" "+this.state.searchtype);
    event.preventDefault();
   if(this.state.searchtype==='price'){
       //call http://localhost:9090/searchprice/10/1000
       axios.get('searchprice/'+this.state.searchlower+'/'+this.state.searchhigher)
       .then((res)=>{
           //console.log(res.data)
           this.setState({
            displaysearchdata:res.data
           })
       })
       .catch((error)=>{
           console.log(error)
       })
   }

   if(this.state.searchtype=='cato'){
       //call http://localhost:9090/searchcategory?cato=Electronics
       alert(this.state.searchcato)
       axios.get('searchcategory?cato='+this.state.searchcato)
       .then((res)=>{
          console.log(res.data)
          this.setState({
            displaysearchdata:res.data
           })
       })
       .catch((error)=>{
           console.log(error)
       })
   }
}
    render(){
       
        const pheader=<tr><th>Product Id</th> <th>Product Name</th> <th>Product Price</th><th>Product category</th></tr>;

       const pdata =this.state.displaysearchdata.map((prod,key)=><tr><td>{prod.prodId}</td><td>{prod.prodName}</td><td>{prod.prodPrice}</td><td>{prod.prodCategory}</td></tr>);
        return (
           <div>
               <form onSubmit={this.searchMyData}>
                   Search By Price<input type="radio" id="searchtype" name="bysearch" value="price" onChange={this.changeofInput} ></input><br/>
                   Search By Catogery<input type="radio" id="searchtype" name="bysearch"  value="cato" onChange={this.changeofInput}></input><br/>
                   
                   Lower Price Limit<input type="text" id="searchlower" onChange={this.changeofInput}></input> <br/>
                   Higher Price Limit<input type="text" id="searchhigher" onChange={this.changeofInput}></input> <br/>

                   Catogery<input type="text" id="searchcato" value={this.state.searchcato} onChange={this.changeofInput}></input> <br/>
                   <button type="submit">Search Data</button>
               </form>
                  
                  <table border="1" >
                            {pheader}
                            {pdata}
                  </table>
           </div>

        )
}
}

export default SearchProduct;