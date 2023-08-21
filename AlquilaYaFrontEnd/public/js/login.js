$(document).ready(function () {
    $('#btn-login').click(function(){

        let email = $("#ipt-username").val();
        let password = $("#ipt-password").val();

        const data = {
        email,
        password
        };

        $.ajax({
            url: "http://localhost:8080/api/v1/auth/authenticate",
            method: "POST",
            headers: {
                'Access-Control-Allow-Origin': '*',
                'Content-Type':'application/json'
            },
            dataType: 'json',
            data: JSON.stringify(data),
            success: function (resp) {
                //let token = request.getResponseHeader("authorization");

                let token = resp.access_token;

                if (!token) {
                  alert("No ha sido posible autenticar al usuario ingresado.");
                  return;
                }

                if (!localStorage) {
                  alert("El navegador no soporta LocalStorage.");
                  return;
                }

                localStorage.setItem("at", token);

                setTimeout(() => {
                    window.location.replace("./views/user/home.html");
                });

            },
            error: function (jqXHR) {
                
              alert("Error: " + jqXHR.status);

              if (jqXHR.status == 401 || jqXHR.status == 403) {
                alert("Usuario y/o Contraseña incorrectas");
                return;
              }
                
            }
        });
    });
});