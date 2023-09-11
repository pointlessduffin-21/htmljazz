import React,{Component } from 'react';

//Data from other Component {datafromap}
class ShowProduct extends Component{

    render(){
        const mydata=this.props.alldata;
        const pheader=<tr><th>Product Id</th> <th>Product Name</th> <th>Product Price</th><th>Product category</th></tr>;

       const pdata=mydata.map((prod,key)=><tr><td>{prod.prodId}</td><td>{prod.prodName}</td><td>{prod.prodPrice}</td><td>{prod.prodCategory}</td></tr>);
        return (
         <div>
          <h1>Show All Products </h1>
          <table border="1">{pheader}{pdata}</table>
         </div>
        )
    }


}

export default ShowProduct;