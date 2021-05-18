$(document).ready(function () {
  $('#button').click(function (e) {
    
    let form = $('#contact-form')
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
    if( $(this).width() > 900 ) {
      document.getElementById('menu-list').removeAttribute("style");
      $(".shop-naslov").css("margin-top", "100px");
    }
  });

function maxWords() {
    let max = 1000;
    let textArea = $(".polje");
    let currentWords = textArea.val().length;
    let wordsLeft = $('.broj-reci');
    wordsLeft.html(max-currentWords);
}

function validation() {
  let name = $('#name').val();
  let email = $('#email').val();
  let message = $('#message').val();
  let formIsValid = true;
  //alert(name +' '+ email +' '+ message);
  if (name === '') {
    $('#name').addClass('input-error');
    $('.name-error').html('<p> Obavezno polje </p>');
    formIsValid = false;
  }

  if (name != ''){
    $('#name').removeClass('input-error');
    $('.name-error').empty();
  }

  if (email === '') {
    $('#email').addClass('input-error');
    $('.email-error').html('<p> Obavezno polje </p>');
    formIsValid = false;
  }
  if (email != '') {
    $('#email').removeClass('input-error');
    $('.email-error').empty();
    let lastAtPos = email.lastIndexOf('@');
    let lastDotPos = email.lastIndexOf('.');
    
    if (!(lastAtPos < lastDotPos && lastAtPos > 0 && email.indexOf('@@') === -1 && lastDotPos > 2 && (email.length - lastDotPos) > 2)) {
      $('#email').addClass('input-error');
      $('.email-error').html('<p> Email nije ispravan </p>');  
      formIsValid = false;
    }
  }

  if (message === '') {
    $('#message').addClass('input-error');
    $('.message-error').html('<p> Obavezno polje </p>');
    formIsValid = false;
  }

  if (message != ''){
    $('#message').removeClass('input-error');
    $('.message-error').empty();
  }

  return formIsValid;
}


