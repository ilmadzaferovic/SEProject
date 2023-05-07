var UserService = {
    init: function(){
      var token = localStorage.getItem("token");
      if (token){
        window.location.replace("index.html");
      }
      $('#loginForm').validate({
        submitHandler: function(form) {
          var entity = Object.fromEntries((new FormData(form)).entries());
          UserService.login(entity);
        }
      });
    },

    test: function(a, b, c){
        console.log("here");
        var formData = $("#loginForm")[0];
        var entity = Object.fromEntries((new FormData(formData)).entries());
        UserService.login(entity);
    
      },

    login: function(entity){
      $.ajax({
        url: 'rest/login',
        type: 'POST',
        data: JSON.stringify(entity),
        contentType: "application/json",
        dataType: "json",
        success: function(result) {
          console.log(result);
          localStorage.setItem("token", result.token);
          window.location.replace("index.html");
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
          toastr.error(XMLHttpRequest.responseJSON.message);
        }
      });
    },
  
    logout: function(){
      localStorage.clear();
      window.location.replace("login.html");
    },

    register: function(){
        
      window.location="register.html";
    },
  }