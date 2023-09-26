<%@page import="java.util.List"%>
<%@page import="com.Modelo.EstudianteDao"%>
<%@page import="com.Modelo.Estudiante"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>  
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <title>JSP Page</title>

    </head> 
    <body>
        <%
          EstudianteDao daoEstudiante = new EstudianteDao();
          List<Estudiante> listaEstudiante = daoEstudiante.ListarEstudiantes();
         
        %>


    </body>
    <!DOCTYPE html>
    <html lang="en">
        <head>
            <title>Bootstrap Example</title>
            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

        <body>

            <div class="container">
                <h2>Filterable Table</h2>
                <p>Type something in the input field to search the table for first names, last names or emails:</p>  
                <input class="form-control" id="myInput" type="text" placeholder="Search..">
                <br>
                <table class="table table-bordered table-striped">
                    <thead>
                        <tr>
                            <th>id</th>
                            <th>nombres</th>
                            <th>apellido</th>
                            <th>celular</th>
                            <th>documento</th>
                            <th>FechaCreacion</th>
                        </tr>
                    </thead>
                    <%
                        for(Estudiante e : listaEstudiante){
                    %>
                    <tbody id="myTable">
                    <td><%=e.getId()%></td>
                    <td><%=e.getNombres()%></td>
                    <td><%=e.getApellido()%></td>
                    <td><%=e.getCelular()%></td>
                    <td><%=e.getDocumento()%></td>
                    <td><%=e.getFechaCreacion()%></td>
                    </tr>
                    </tbody><%
                                }
                    %>
                </table>

                <p>Note that we start the search in tbody, to prevent filtering the table headers.</p>
            </div>

            <script>
                $(document).ready(function () {
                    $("#myInput").on("keyup", function () {
                        var value = $(this).val().toLowerCase();
                        $("#myTable tr").filter(function () {
                            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                        });
                    });
                });
            </script>

        </body>
    </html>
