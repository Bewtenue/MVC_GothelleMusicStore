<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Catalogo de Musica</title>
</head>
<body>
Hello, this is the music Catalog
Press Button to show<br>
		
		<td><input type="button" id="submit" value="Mostrar Catalogo"></td>
	
	
	<div id="catalogo"></div>
	
</body>

<script src="http://code.jquery.com/jquery-latest.js"></script>

<script>
	var tablaCatalogo = "<ul>"//para ir agregando elementos en una lista usando formato html
	var click = 0;
	$(document).ready(function() {
		$('#submit').click(function(event) {			
			if(click!=1){//se hace esto para mostrar los productos una sola vez
				$.ajax({
					url: 'mostrarCatalogo', //se le dice al handler mapping a donde va
					type:'GET',//con que metodo se va a resolver
					contentType: "application/json",//el tipo de contenido
					dataType:"json",
					success: function(res){
						$.each(res,function(i,obj){//te ayuda a iterar sobre un array, sirve para colecciones (lalista,function(indice,valor))		
							tablaCatalogo += "<li>The genre is "+obj.genreDiscos+"</li>";//se accede a los datos como cualquier objeto
							tablaCatalogo += "<li>The name of the disc is "+obj.nameDiscos+"</li>";
						});
						
						tablaCatalogo += "</ul>";
						
						$('#catalogo').append(tablaCatalogo);//se lo añado al div con id="catalogo"
						click = 1;
					},
					error : function(){
						alert("error en ajax");
					}
				});
			}
			
			
		});
	});
</script> 
<!-- 
	 <ul>
		<c:forEach var = "listaProductos" items="${lista}">
			<li><h2>The genre is ${listaProductos.genreDiscos}</h2></li>
			<li>The name of the disc is ${listaProductos.nameDiscos}</li>
		</c:forEach>
	</ul> -->
</html>




