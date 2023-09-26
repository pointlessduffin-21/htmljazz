import React, { Component } from 'react'
import GoogleLogin from 'react-google-login';
import AddComponent from './AddComponent';


export class Googlelogin extends Component {
    state={
        isLoggedIn:false,
        userID:"",
        name:"",
        email:"",
        picture:""
    }
    render() {
        let googleContent;
        const responseGoogle=(response)=>{
           // console.log(response);
           //console.log(response.Iw.Ju.Zv);
            this.setState({
              isLoggedIn:true,
              userID:response.userID,
              name:response.name,
              email:"data"
        })
        }
        if(this.state.isLoggedIn){
            console.log("Data");
            googleContent=(
            <div>
           <AddComponent></AddComponent>
            
            </div>)
        }else{
           googleContent=(
            <GoogleLogin
            clientId="30200858852-jjdmejdfsid0m1v3uj25nupfqr7vbsm9.apps.googleusercontent.com" //its ur client 
            buttonText="Login with Google"
            onSuccess={responseGoogle}
            onFailure={responseGoogle}
          />
           )
        }
        return (
            <div>
              {googleContent}
            </div>
        )
    }
}

export default Googlelogin
