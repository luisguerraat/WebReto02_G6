$(document).ready(function() {
  // URL del endpoint de login
  const loginUrl = 'http://127.0.0.1:8080/api/user';

  // Manejar el envío del formulario de login
  $('#loginForm').on('submit', function(e) {
    e.preventDefault();
    const email = $('#inputEmail').val();
    const password = $('#inputPassword').val();
    $.ajax({
      url: loginUrl + "/" + email + "/" + password, 
      method: 'GET',
      success: function (response) {
        if (response.id == null)
          alert('Error al iniciar sesión');
        else {
          alert('Inicio de sesión exitoso');
          location.href= "../index2.html";
        }
        // Realizar acciones después del inicio de sesión exitoso
          
      },
      error: function() {
        // Realizar acciones en caso de error en el inicio de sesión
        alert('Error al iniciar sesión');
      }
    });
  });
});
