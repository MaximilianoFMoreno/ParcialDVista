
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Altas</title>

<h1>Nuevo Camion</h1>
</head>
<body>

<form action="Sv_Camiones"  method="POST">
<label>Dominioo del mionca: </label>
<input type="text" name="dominio_camion"><br>
<br>
<label>Marca del mionca: </label>
<input type="text" name="marca_camion"><br>
<br>
<label>Toneladas Maximas </label>
<input type="number" name="toneladas_camion"><br>
<br>
<label>Litros por Tanque: </label>
<input type="number" name="litros_camion"><br>
<br>
<label>Consumo del mionca:  </label>
<input type="number" name="consumo_camion"><br>
<br>
<label>Categoria del mionca: </label>
<input type="text" name="categoria_camion"><br>
<h4 style="color: red;">(Recuerde que la cateria es A1 para camiones grandes y B1 para camiones chicos)</h4>
<br>

<input type="submit" value="Cargar">
</form>

</body>
</html>