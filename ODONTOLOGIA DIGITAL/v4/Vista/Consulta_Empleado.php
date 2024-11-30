<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <!-- Iconos -->
        <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
        <title>Odontologia Digital</title>
        <link rel="icon" type="image/x-icon" href="../Public/img/odo.jpg" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet" />
        <link href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="../Vista/css/styles.css" rel="stylesheet" />
    </head>
    <body>
        <header>
            <h1 class="site-heading text-center text-faded d-none d-lg-block">
                <span class="site-heading-upper text-primary mb-3">De todos, para todos</span>
                <span class="site-heading-lower">Odontologia Digital</span>
            </h1>
        </header>

        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-dark py-lg-4" id="mainNav">
            <div class="container">
			<a class="navbar-brand" href="../Vista/pagina_inicio_sesion.html">
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mx-auto">
                        <li class="nav-item px-lg-4"><a class="nav-link text-uppercase" href="pagina_inicio_sesion.html">Home</a></li>
                    </ul>
                </div>
            </div>
        </nav>
  <div class="container-fluid">
	<!-- Tabla -->
	<table class="table table-secondary">

	<tr>
		<td>idempleado</td>
		<td>numDocEmpleado</td>
		<td>tipoDocEmpleado</td>
		<td>nombreEmpleado</td>
		<td>apellidoEmpleado</td>
		<td>telefono</td>
        <td>direccion</td>
        <td>estado</td>
        <td>idusuarioFK</td>
        <td>idRolFK</td>
        <td>consultas</td>
		
	</tr>
	<?php
		require_once('../Modelo/cls_Empleado2.php');
		$objeto=new Empleado();
		$filas=$objeto->consultar_todos();

		foreach($filas as $fila){
		?>
			<tr>
			<td><?php echo $fila['idempleado'];?></td>
			<td><?php echo $fila['numDocEmpleado'];?></td>
			<td><?php echo $fila['tipoDocEmpleado'];?></td>
			<td><?php echo $fila['nombreEmpleado'];?></td>
			<td><?php echo $fila['apellidoEmpleado'];?></td>
            <td><?php echo $fila['telefono'];?></td>
            <td><?php echo $fila['direccion'];?></td>
            <td><?php echo $fila['estado'];?></td>
            <td><?php echo $fila['idusuarioFK'];?></td>
            <td><?php echo $fila['idRolFK'];?></td>
	        <td><a class="btn btn-outline-primary" href="editar_datos.php">editar</a></td> 

			                                                                                                                          
		</tr>                 
		<?php
		}
	?>

	</table>
</div>	
				
<footer class="footer text-faded text-center py-5">
            <div class="container"><p class="m-0 small"> © 2024 odontologia digital   &copy;  </p></div>
            <!-- Section: Social media -->
            <section class="mb-4">
                <!-- Facebook -->
                <a class="btn btn-outline-light btn-floating m-1" href="" role="button"><i class="fab fa-facebook-f"></i></a>
                <!-- Instagram -->
                <a class="btn btn-outline-light btn-floating m-1" href="" role="button"><i class="fab fa-instagram"></i></a>
              </section>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="../Vista/js/scripts.js"></script>
          </div>
    </body>
</html>
