import java.sql.*;
import java.util.Scanner;

public class UsuarioManager {

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Crea un nuevo usuario en la base de datos.
     *
     * @param connection La conexión activa a la base de datos.
     */
    public static void crearUsuario(Connection connection) {
        // Solicita al usuario que ingrese el nombre del nuevo usuario
        System.out.print("Ingrese el nombre del nuevo usuario: ");
        String nombre = scanner.nextLine();

        // Solicita al usuario que ingrese el correo del nuevo usuario
        System.out.print("Ingrese el correo del nuevo usuario: ");
        String correo = scanner.nextLine();

        try {
            // Prepara una sentencia SQL para insertar el nuevo usuario en la tabla 'usuarios'
            try (PreparedStatement preparedStatement = connection.prepareStatement("insert into usuario (idusuario, correoUsuario, passwordUsuario,estadoUsuario,idrolFK)  values (?, ?, ?, ?)")) {
                // Establece los valores de los parámetros en la sentencia SQL
                preparedStatement.setString(1, nombre);
                preparedStatement.setString(2, correo);

                // Ejecuta la sentencia SQL para insertar el nuevo usuario
                preparedStatement.executeUpdate();

                // Informa al usuario que el usuario se ha creado exitosamente
                System.out.println("Usuario creado exitosamente.");
            }
        } catch (SQLException e) {
            // En caso de error, imprime la traza de la pila y muestra un mensaje de error
            e.printStackTrace();
            System.out.println("Error al crear el usuario.");
        }
    }

    /**
     * Consulta y muestra un listado de usuarios en la consola.
     *
     * @param connection La conexión activa a la base de datos.
     */
    public static void consultarUsuarios(Connection connection) {
        try
            // Prepara la consulta SQL para obtener datos de la tabla 'usuarios'
            (PreparedStatement preparedStatement = connection.prepareStatement("SELECT idusuario, nombre, correoUsuario FROM usuario");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            System.out.println("Listado de usuarios:");
            System.out.println("+----------------+-------------------------+-----------------------------+");
            // Imprime los encabezados de las columnas
            System.out.printf("| %-14s | %-23s | %-27s |\n", "ID", "Nombre", "Correo");
            System.out.println("+----------------+-------------------------+-----------------------------+");

            // Itera sobre los resultados y muestra cada fila de la tabla
            while (resultSet.next()) {
                int idusuario = resultSet.getInt("id_usuario");
                String nombre = resultSet.getString("nombre");
                String correo = resultSet.getString("correoUsuario");

                // Muestra los datos de cada usuario
                System.out.printf("| %-14d | %-23s | %-27s |\n", idusuario, nombre, correo);
            }

            // Línea divisoria al final de la tabla
            System.out.println("+----------------+-------------------------+-----------------------------+");

        } catch (SQLException e) {
            // En caso de error, imprime la traza de la pila y muestra un mensaje de error
            e.printStackTrace();
            System.out.println("Error al consultar usuarios.");
        }
    }
    /**


     * @param connection La conexión a la base de datos.
     */
    public static void actualizarUsuario(Connection connection) {
        // Solicitar al usuario el ID del usuario a actualizar
        System.out.print("Ingrese el ID del usuario a actualizar: ");
        int idUsuario = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea después de nextInt()

        // Solicitar al usuario el nuevo nombre del usuario
        System.out.print("Ingrese el nuevo nombre del usuario: ");
        String nuevoNombre = scanner.nextLine();

        // Solicitar al usuario el nuevo correo del usuario
        System.out.print("Ingrese el nuevo correo del usuario: ");
        String nuevoCorreo = scanner.nextLine();

        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE usuarios SET nombre=?, correo=? WHERE id_usuario=?")) {
            // Establecer los valores en la consulta preparada
            preparedStatement.setString(1, nuevoNombre);
            preparedStatement.setString(2, nuevoCorreo);
            preparedStatement.setInt(3, idUsuario);

            // Ejecutar la consulta de actualización
            preparedStatement.executeUpdate();

            // Informar al usuario que la actualización fue exitosa
            System.out.println("Usuario actualizado exitosamente.");
        } catch (SQLException e) {
            // Imprimir detalles del error en caso de excepción
            e.printStackTrace();
            System.out.println("Error al actualizar el usuario.");
        }
    }


    /**
     * Método para eliminar un usuario de la base de datos mediante su ID.
     * Se solicita al usuario ingresar el ID del usuario a eliminar. Luego, se ejecuta
     * una consulta SQL de eliminación en la tabla de usuarios utilizando el ID proporcionado.
     *
     * @param connection La conexión a la base de datos.
     */
    public static void eliminarUsuario(Connection connection) {
        // Solicitar al usuario el ID del usuario a eliminar
        System.out.print("Ingrese el ID del usuario a eliminar: ");
        int idUsuario = scanner.nextInt();

        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM usuarios WHERE id_usuario=?")) {
            // Establecer el valor del ID en la consulta preparada
            preparedStatement.setInt(1, idUsuario);

            // Ejecutar la consulta de eliminación
            preparedStatement.executeUpdate();

            // Informar al usuario que el usuario ha sido eliminado exitosamente
            System.out.println("*************Usuario eliminado exitosamente.*************");
        } catch (SQLException e) {
            // Imprimir detalles del error en caso de excepción
            e.printStackTrace();
            System.out.println("---------------Error al eliminar el usuario.---------------");
        }
    }

}