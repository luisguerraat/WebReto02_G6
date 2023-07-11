$(document).ready(function() {
  // URL de la API
  const apiUrl = 'http://127.0.0.1:8080/api/books';

  // Agregar libro
  $('#bookForm').on('submit', function(e) {
    e.preventDefault();
    const bookData = $(this).serialize();
    $.ajax({
      url: apiUrl,
      method: 'POST',
      data: bookData,
      success: function(response) {
        alert('Libro agregado exitosamente');
        $('#bookForm')[0].reset();
      },
      error: function() {
        alert('Error al agregar el libro');
      }
    });
  });

  // Modificar libro
  $('#btnUpdate').on('click', function(e) {
    e.preventDefault();
    const bookId = $('#inputId').val();
    const bookData = $('#bookForm').serialize();
    $.ajax({
      url: apiUrl + '/' + bookId,
      method: 'PUT',
      data: bookData,
      success: function(response) {
        alert('Libro actualizado exitosamente');
        $('#bookForm')[0].reset();
      },
      error: function() {
        alert('Error al actualizar el libro');
      }
    });
  });

  // Eliminar libro
  $('#btnDelete').on('click', function(e) {
    e.preventDefault();
    const bookId = $('#inputId').val();
    $.ajax({
      url: apiUrl + '/' + bookId,
      method: 'DELETE',
      success: function(response) {
        alert('Libro eliminado exitosamente');
        $('#bookForm')[0].reset();
      },
      error: function() {
        alert('Error al eliminar el libro');
      }
    });
  });

  // Listar libros
  $('#btnList').on('click', function(e) {
    e.preventDefault();
    $.ajax({
      url: apiUrl,
      method: 'GET',
      success: function(response) {
        displayBooks(response);
      },
      error: function() {
        alert('Error al obtener la lista de libros');
      }
    });
  });

  // Mostrar libros en la tabla
  function displayBooks(books) {
    const bookTableBody = $('#bookTable tbody');
    bookTableBody.empty();
    for (const book of books) {
      const row = `
        <tr>
          <td>${book.id}</td>
          <td>${book.nombre}</td>
          <td>${book.paginas}</td>
          <td>${book.autor}</td>
          <td>${book.costo}</td>
        </tr>
      `;
      bookTableBody.append(row);
    }
  }
});
