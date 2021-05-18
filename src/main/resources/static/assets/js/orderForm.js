var counter = 1;
$(document).ready(function () {
  $('#button').click(function (e) {
    let form = $('#order-form')
    if (validation()) {
      form.attr('method', 'post');
    }
    else {
      e.preventDefault();
      form.attr('method', '');
    }
    
  });
});

function recaptchaCallback(){
  $('#button').removeAttr('disabled');
};

$(window).resize(function() {
    if( $(this).width() > 1100 ) {
      $('.meni-spusten').hide();
    }
  });

function maxWords(){
    let max = 500;
    let textArea = $(".napomena");
    let wordsLeft = $(".duzina-poruke");
    let currentWords = textArea.val().length;
    wordsLeft.html(max-currentWords);
}

function showHideMenu() {
    if (counter == 0) {
        $(".meni-spusten").slideDown();
        $(".strelica-gore").show();
        $(".strelica-dole").hide();
        counter = 1;
      } else {
        $(".meni-spusten").slideUp();
        $(".strelica-dole").show();
        $(".strelica-gore").hide();
        counter = 0;
      }
}

function validation(){
  let name = $(".ime").val();
  let lastName = $(".prezime").val();
  let street = $(".ulica").val();
  let city = $(".grad").val();
  let zip = $(".zip-broj").val();
  let phone = $(".broj-tel").val();
  let email = $(".email").val();
  let errorMsg = $(".msg")
  let formIsValid = true;

  if(name === ''){
    $(".ime").addClass('input-error');
    formIsValid = false;
  }

  if(name != ''){
    $(".ime").removeClass('input-error');
  }

  if(lastName === ''){
    $(".prezime").addClass('input-error');
    formIsValid = false;
  }

  if(lastName != ''){
    $(".prezime").removeClass('input-error');
  }

  if(street === ''){
    $(".ulica").addClass('input-error');
    formIsValid = false;
  }

  if(street != ''){
    $(".ulica").removeClass('input-error');
  }

  if(city === ''){
    $(".grad").addClass('input-error');
    formIsValid = false;
  }

  if(city != ''){
    $(".grad").removeClass('input-error');
  }

  if(zip === ''){
    $(".zip-broj").addClass('input-error');
    formIsValid = false;
  }

  if(zip != ''){
    $(".zip-broj").removeClass('input-error');
  }

  if(phone === ''){
    $(".broj-tel").addClass('input-error');
    formIsValid = false;
  }

  if(phone != ''){
    $(".broj-tel").removeClass('input-error');
  }

  if(email === ''){
    $(".email").addClass('input-error');
    formIsValid = false;
  }

  if(email != ''){
    $(".email").removeClass('input-error');
    let lastAtPos = email.lastIndexOf('@');
    let lastDotPos = email.lastIndexOf('.');
    
    if (!(lastAtPos < lastDotPos && lastAtPos > 0 && email.indexOf('@@') === -1 && lastDotPos > 2 && (email.length - lastDotPos) > 2)) {
      $('.email').addClass('input-error');
      $('.email-error').remove();
      $('.email-div').prepend("<p class='email-error'>Email nije ispravan</p>")
      formIsValid = false;
    }
    else {
      $('.email-error').remove();
    }
  }
  if(!formIsValid){
    $('.error-msg').remove();
    errorMsg.append("<p class='error-msg'> Niste popunili sva obavezna polja </p>");
  }
  else{
    $('.error-msg').remove();
  }

return formIsValid;
}