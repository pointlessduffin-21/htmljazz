import React from "react";
import { Link } from "react-router-dom";
import companyLogo from "../../assets/images/merryOnwheels (2).png";


class Header extends React.Component {


  
  constructor(props) {
    super(props);
    this.state = {
      isLoggedIn: false, // Initially assume user is not logged in
      roleName: "", // Initially set role as an empty string
    };
  }





  componentDidMount() {
    // Check if user is logged in by checking localStorage or session storage
    const isLoggedIn = localStorage.getItem("accessToken") !== null;
    const roleName = localStorage.getItem("roleName") || "";
    this.setState({ isLoggedIn, roleName });

    // Add scroll event listener
    window.addEventListener("scroll", this.scrollFunction);
  }

  componentWillUnmount() {
    // Remove scroll event listener when component unmounts
    window.removeEventListener("scroll", this.scrollFunction);
  }

  scrollFunction = () => {
    if (
      document.body.scrollTop > 250 ||
      document.documentElement.scrollTop > 250
    ) {
      document.getElementById("mainNav").style.backgroundColor =
        "rgba(0, 0, 0, 0.85)";
    } else {
      document.getElementById("mainNav").style.backgroundColor = "rgba(0, 0, 0, 0)";
    }
  };


  
  handleLogout = () => {
    // localStorage.removeItem("auth"); // Remove the 'auth' key from localStorage
    // localStorage.removeItem("accessToken"); // Remove the 'accessToken' key from localStorage
    // localStorage.removeItem("roleName"); // Remove the 'role' key from localStorage
    localStorage.clear();
    window.location.href = "/";
  };

  render() {
    const { isLoggedIn, roleName } = this.state;
    // console.log("in render "+ isLoggedIn);
    // console.log("in render "+ roleName);
    return (
      <nav className="navbar navbar-expand-lg fixed-top text-uppercase custom-font-header " id="mainNav" style={{transition: "0.4s"}}>
        <div className="container">
          <Link className="navbar-brand d-flex align-items-center" to="/">
            <img
              src={companyLogo}
              alt="Meals on Wheels"
              className="me-2"
              style={{ width: "150px", height: "auto" }}
            />
          </Link>
          <button
            className="navbar-toggler text-uppercase font-weight-bold bg-white text-white rounded"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarResponsive"
            aria-controls="navbarResponsive"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <i className="fa fa-bars" aria-hidden="true"></i>
          </button>
          <div className="collapse navbar-collapse" id="navbarResponsive">
            <ul className="navbar-nav ms-auto">
              {!isLoggedIn && (
                <>
                  <li className="nav-item mx-0 mx-lg-1">
                    <Link to="/login" className="nav-link py-3 px-0 px-lg-3 rounded text-white">
                      Login
                    </Link>
                  </li>
                  <li className="nav-item mx-0 mx-lg-1">
                    <Link to="/register" className="nav-link py-3 px-0 px-lg-3 rounded text-white">
                      Register
                    </Link>
                  </li>
                </>
              )}
              {isLoggedIn && (
                <>
                  {roleName === "ROLE_MEMBER" && (
                    <>
                      <li className="nav-item mx-0 mx-lg-1">
                        <Link to="/member/dashboard" className="nav-link py-3 px-0 px-lg-3 rounded text-white">
                          Home
                        </Link>
                      </li>
                      <li className="nav-item mx-0 mx-lg-1">
                        <Link to="/member/menu" className="nav-link py-3 px-0 px-lg-3 rounded text-white">
                          Menu
                        </Link>
                      </li>
                      <li className="nav-item mx-0 mx-lg-1">
                        <Link to="/member/search" className="nav-link py-3 px-0 px-lg-3 rounded text-white">
                          Search
                        </Link>
                      </li>
                      <li className="nav-item mx-0 mx-lg-1">
                        <Link to="/donor/dashboard" className="nav-link py-3 px-0 px-lg-3 rounded text-white">
                          Donate
                        </Link>
                      </li>
                    </>
                  )}
                  <li className="nav-item mx-0 mx-lg-1">
                    <button
                      className="nav-link btn border-0 mt-2 px-0 px-lg-3 rounded text-uppercase text-white"
                      onClick={this.handleLogout}
                    >
                      Logout
                    </button>
                  </li>
                </>
              )}
            </ul>
          </div>
        </div>


        
      </nav>
    );
  }
}

export default Header;