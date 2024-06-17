/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function filaSeleccionada(fila){
    var idpersona = $(fila).find(".idpersona").text();
    var documento = $(fila).find(".documento").text();
    var nombres = $(fila).find(".nombres").text();
    var apPaterno = $(fila).find(".apePaterno").text();
    var apMaterno = $(fila).find(".apeMaterno").text();
    var telefono = $(fila).find(".telefono").text();
    var correo = $(fila).find(".correo").text();
    
    $("#idpasado").val(idpersona);
    
    $(document).ready(function(){
       $(document).on('click', '.btnEliminar', function(){
           filaSeleccionada($(this).closest('tr'));
       }); 
    });
}