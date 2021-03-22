$(window).resize(function() {
    if( $(this).width() > 900 ) {
      document.getElementById('menu-list').removeAttribute("style");
      $(".shop-naslov").css("margin-top", "100px");
    }
  });

function maxValue(value) {
    
    if ((value <= 10 && value >= 1 && !isNaN(value)) || value == "") {
        
       
       }
    else {
        $("#kolicina").val(1);
    }
    

}