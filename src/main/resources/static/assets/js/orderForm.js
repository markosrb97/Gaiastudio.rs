var max = 500;
var textArea = $(".napomena");
var wordsLeft = $(".duzina-poruke");
var prekidac = 0;

$(window).resize(function() {
    if( $(this).width() > 1100 ) {
      $('.meni-spusten').hide();
    }
  });

function maxWords(){
    let currentWords = textArea.val().length;
    wordsLeft.html(max-currentWords);
}

function showHideMenu() {
    if (prekidac == 0) {
        $(".meni-spusten").slideDown();
        $(".strelica-gore").show();
        $(".strelica-dole").hide();
        prekidac = 1;
      } else {
        $(".meni-spusten").slideUp();
        $(".strelica-dole").show();
        $(".strelica-gore").hide();
        prekidac = 0;
      }
}