var default_content="";

$(document).ready(function(){

	checkURL();
	$('ul li a').click(function (e){
			checkURL(this.hash);
	});

	//filling in the default content
	default_content = $('#pageContent').html();


	setInterval("checkURL()",250);

});

var lasturl="";

function checkURL(hash)
{
	if(!hash) hash=window.location.hash;

	if(hash != lasturl)
	{
		lasturl=hash;
		// FIX - if we've used the history buttons to return to the homepage,
		// fill the pageContent with the default_content
		if(hash=="")
		$('#pageContent').html(default_content);

		else{
		 if(hash=="#products")
		 	loadProducts();
		 else
		   loadPage(hash);
		}
	}
}


function loadPage(url)
{
	url=url.replace('#page','');

	$('#loading').css('visibility','visible');

	$.ajax({
		type: "GET",
		url: "load_page.py",
		data: 'page='+url,
		dataType: "html",
		success: function(msg){

			if(parseInt(msg)!=0)
			{
				$('#pageContent').html(msg);
				$('#loading').css('visibility','hidden');
			}
		}

	});

}


// Producs

function loadProducts() {
  $('#loading').css('visibility','visible');
  var jsonURL = "products.json";

  	$('#currency_option').change(function(){

		$('#currency_option option:selected').each(function(){


			let selectedInput = $(this).text();

			$.getJSON(jsonURL, function (json)
			{
				var imgList= "<ul class=\"products\">";
				if(selectedInput === "Singaporean Dollar (SGD)"){
					$.each(json.products, function () {
						imgList += '<li><img src= "' + this.imgPath + '"><h3>' + this.name + '</h3><h3>'+ this.SGD + '</h3></li>';
						});
				} else if (selectedInput === "United States Dollar (USD)") {
					$.each(json.products, function () {
						imgList += '<li><img src= "' + this.imgPath + '"><h3>' + this.name + '</h3><h3>'+ this.USD + '</h3></li>';
						});
				} else if (selectedInput === "Philippine Peso (PHP)") {
					$.each(json.products, function () {
							imgList += '<li><img src= "' + this.imgPath + '"><h3>' + this.name + '</h3><h3>'+ this.PHP + '</h3></li>';
						});
				} else {
					$.each(json.products, function () {
						imgList += '<li><img src= "' + this.imgPath + '"><h3>' + this.name + '</h3></li>';
						});
				}
				imgList+='</ul>'
				$('#pageContent').html(imgList);
				$('#loading').css('visibility','hidden');
			 });  
		


		});

	});


	$.getJSON(jsonURL, function (json)
	{
		var imgList= "<ul class=\"products\">";
		$.each(json.products, function () {
		imgList += '<li><img src= "' + this.imgPath + '"><h3>' + this.name + '</h3></li>';
		});
		imgList+='</ul>'
		$('#pageContent').html(imgList);
		$('#loading').css('visibility','hidden');
 	});  


  
}




// Pages

$(document).ready(function(){


	$('#main-page').click(function(){

		$('#currency_option').addClass('on');

	});


	$('.page').click(function(){
		$('#currency_option').removeClass('on');
		index = $(this).index();


		$.ajax({ 
			url:"pages/page_" + (index+1) + ".html",  
			success: function(result){
				$('#pageContent').html(result);
				$('#loading').css('visibility', 'hidden');
			}
		});
	});






});



