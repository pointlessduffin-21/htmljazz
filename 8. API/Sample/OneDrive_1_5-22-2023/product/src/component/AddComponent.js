
import axios from 'axios';
import React,{Component } from 'react';


class AddComponent extends Component{
    //attibutes & methods 
    constructor(){
        super();
        this.state={
            "prodId":'',
            "prodName":'',
             "prodPrice":'',
             "prodCategory":''
        }
    }

idChange=(event)=>{
   //alert(event.target.value);
    this.setState({
        prodId:event.target.value
    })
}

nameChange=(event)=>{
    this.setState({
        prodName:event.target.value
    })
}
pricechange=(event)=>{
    this.setState({
        prodPrice:event.target.value
    })
}

categoryChange=(event)=>{
this.setState({
    prodCategory:event.target.value
})
}

addProduct=(event)=>{
    alert(this.state.prodId+" "+this.state.prodName+" "+this.state.prodPrice+" "+this.state.prodCategory);
    axios.post('addData',this.state)
    .then(res=>{
        console.log(res.data);
    })
    .catch(error=>{
        console.log(error);
    })
}
    //View --HTML

    render(){
        return (
            <div>
                <h1>Add Product </h1>
                <form onSubmit={this.addProduct}> 
                    Product Id<input type="text" value={this.state.prodId} onChange={this.idChange}></input><br/>
                    Product Name<input type="text" value={this.state.prodName} onChange={this.nameChange}></input><br/>
                    Product Price<input type="text" value={this.state.prodPrice} onChange={this.pricechange}></input><br/>
                    Product Category<select value={this.state.prodCategory} onChange={this.categoryChange}>
                        <option  >Select</option>
                        <option >Grocery</option>
                        <option >Stationary</option>
                        <option >Electronics</option>
                    </select>
                    <br/>
                    <button type="submit">Add Product</button>
                </form>
            </div>
        )
    }
}

export default AddComponent;