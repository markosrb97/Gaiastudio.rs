var max = 1000;
var textArea = $(".polje");
var wordsLeft = $(".broj-reci");

$(window).resize(function() {
    if( $(this).width() > 900 ) {
      document.getElementById('menu-list').removeAttribute("style");
      $(".shop-naslov").css("margin-top", "100px");
    }
  });

function maxWords() {
    let currentWords = textArea.val().length;
    wordsLeft.html(max-currentWords);
}