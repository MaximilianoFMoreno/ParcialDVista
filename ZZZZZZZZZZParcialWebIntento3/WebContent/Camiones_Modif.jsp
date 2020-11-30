
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Modificaciones</title>
<h1>Modificar Camion</h1>
</head>
<body>

<form action="ServletMCamion"  method="POST">
<label>Dominioo del camion a modificar: </label>
<input type="text" name="domi_camion"><br>
<br>
<label>Ingrese las nuevas Toneladas Maximas: </label>
<input type="number" name="tone_camion"><br>
<br>
<label>Ingrese los nuevos Litros por Tanque: </label>
<input type="number" name="lit_camion"><br>
<br>
<label>Ingrese el nuevo Consumo del camion:  </label>
<input type="number" name="cons_camion"><br>
<br>
<label>Ingrese la nueva Categoria: </label>
<input type="text" name="cate_camion"><br>
<h4 style="color: red;">(Recuerde que la cateria es A1 para camiones grandes y B1 para camiones chicos)</h4>
<br>

<input type="submit" value="Actualizar">
</form>


</body>
</html>