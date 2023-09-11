import React from "react";
import { Link } from "react-router-dom";
import companyLogo from "../../assets/images/merryOnwheels (2).png";

class Header extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      isLoggedIn: false, // Initially assume user is not logged in
      roleName: "", // Initially set role as an empty string
      isScrolled: false // Track whether the page is scrolled or not
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
      document.body.scrollTop > 50 ||
      document.documentElement.scrollTop > 50
    ) {
      this.setState({ isScrolled: true });
    } else {
      this.setState({ isScrolled: false });
    }
  };

  handleLogout = () => {
    localStorage.clear();
    window.location.href = "/";
  };

  render() {
    const { isLoggedIn, roleName, isScrolled } = this.state;

    return (
      <nav
        style={{
          marginLeft: "20%",
          color: isScrolled ? "white" : "black",
          transition: "0.4s",
          backgroundColor: isScrolled ? "rgba(0, 0, 0, 0.8)" : "rgba(0, 0, 0, 0)"
        }}
        className="navbar navbar-expand-lg fixed-top text-uppercase custom-font-header"
        id="mainNav"
      >
        <div className="container" style={{ color: "black" }}>
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
            <ul className="navbar-nav ms-auto" id="colorlink">
              {!isLoggedIn && (
                <>
                  <li className="nav-item mx-0 mx-lg-1">
                    <Link
                      to="/login"
                      className={`nav-link py-3 px-0 px-lg-3 rounded ${
                        isScrolled ? "text-white" : ""
                      }`}
                      id="navcolor"
                    >
                      Login
                    </Link>
                  </li>
                  <li className="nav-item mx-0 mx-lg-1">
                    <Link
                      to="/register"
                      className={`nav-link py-3 px-0 px-lg-3 rounded ${
                        isScrolled ? "text-white" : ""
                      }`}
                      id="navcolor"
                    >
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
                        <Link
                          to="/member/dashboard"
                          className={`nav-link py-3 px-0 px-lg-3 rounded ${
                            isScrolled ? "text-white" : ""
                          }`}
                          id="navcolor"
                        >
                          Home
                        </Link>
                      </li>
                      <li className="nav-item mx-0 mx-lg-1">
                        <Link
                          to="/member/menu"
                          className={`nav-link py-3 px-0 px-lg-3 rounded ${
                            isScrolled ? "text-white" : ""
                          }`}
                          id="navcolor"
                        >
                          Menu
                        </Link>
                      </li>
                      <li className="nav-item mx-0 mx-lg-1">
                        <Link
                          to="/member/search"
                          className={`nav-link py-3 px-0 px-lg-3 rounded ${
                            isScrolled ? "text-white" : ""
                          }`}
                          id="navcolor"
                        >
                          Search
                        </Link>
                      </li>
                      <li className="nav-item mx-0 mx-lg-1">
                        <Link
                          to="/donor/dashboard"
                          className={`nav-link py-3 px-0 px-lg-3 rounded ${
                            isScrolled ? "text-white" : ""
                          }`}
                          id="navcolor"
                        >
                          Donate
                        </Link>
                      </li>
                    </>
                  )}
                  <li className="nav-item mx-0 mx-lg-1">
                    <button
                      className={`nav-link btn border-0 mt-2 px-0 px-lg-3 rounded text-uppercase ${
                        isScrolled ? "text-white" : ""
                      }`}
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
