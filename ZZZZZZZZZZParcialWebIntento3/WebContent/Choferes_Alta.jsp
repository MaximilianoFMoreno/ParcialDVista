
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Alta</title>

<h1>Nuevo Chofer</h1>
</head>
<body>

<form action="ServletChofer"  method="POST">
<label>Nombre: </label>
<input type="text" name="nombre_chofer"><br>
<br>
<label>Apellido: </label>
<input type="text" name="apellido_chofer"><br>
<br>
<label>DNI: </label>
<input type="number" name="dni_chofer"><br>
<br>
<label>Telefono:  </label>
<input type="text" name="telefono_chofer"><br>
<br>
<label>Usuario: </label>
<input type="text" name="usuario_chofer"><br>
<br>
<label>Contraseña: </label>
<input type="text" name="contraseña_chofer"><br>
<br>
<label>Categoria: </label>
<input type="text" name="categoria_chofer"><br>
<br>
<h4>Las categorias pueden ser A1 o B1</h4>

<input type="submit" value="Cargar">
</form>

</body>
</html>