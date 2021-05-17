// Variables 
var banner = $("#banner");
var titleBanner = $("#title-banner");
var textBanner = $("#text-banner");
var linkBanner = $("#link-banner");
var d = 0;
var countInt = 0;

// jQuery
$(document).ready( function() {
	setTimeout(startBanner, 3000);
});

// Functions
function startBanner() {
	console.log("Usao "+d)
	switch(d) {
		case 0: titleBanner.slideDown(500);
				d = 1;
				setTimeout(startBanner, 3000);
				break;
		case 1: textBanner.slideDown(500);
				d = 2;
				setTimeout(startBanner, 3000);
				break;
		case 2: linkBanner.show();
				if ( countInt == 1 ) {
					linkBanner.animate({marginLeft:'350px'}, 1000, endBanner)
				}
				else {
					linkBanner.animate({marginLeft:'350px'}, 1000)
					d = 3;
					setTimeout(startBanner, 3000);
				}
				break;
		case 3: titleBanner.slideUp(500);
				textBanner.slideUp(500);
				linkBanner.hide().css('margin-left', '200px');
				d = 0;
				countInt++;
				setTimeout(startBanner, 3000);
				break;
	}
}

function endBanner() {
	window.location.href = "https://www.w3schools.com"
	//banner.remove();
}


var slideIndex = 0;
showSlides();

function showSlides() {
  var i;
  var slides = document.getElementsByClassName("mySlides");
  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";
  }
  slideIndex++;
  if (slideIndex > slides.length) {slideIndex = 1}
  slides[slideIndex-1].style.display = "block";
  setTimeout(showSlides, 7000); // Change image every 2 seconds
}