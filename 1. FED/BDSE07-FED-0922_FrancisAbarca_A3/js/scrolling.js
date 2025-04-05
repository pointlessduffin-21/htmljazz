window.onscroll = function() {myFunction()};

var header = document.getElementById("myHeader");
var sticky = header.offsetTop;

function myFunction() {
  if (window.pageYOffset > sticky) {
    header.classList.add("sticky");
  } else {
    header.classList.remove("sticky");
  }
}


window.onscroll = function(){
  scroll();
};

function scroll() {
  if (document.body.scrollTop >20 || document.documentElement.scrollTop > )
}