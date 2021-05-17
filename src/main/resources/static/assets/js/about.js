$(window).resize(function() {
    if( $(this).width() > 990 ) {
      document.getElementById('menu-list').removeAttribute("style");
      $(".shop-naslov").css("margin-top", "100px");
    }
  });