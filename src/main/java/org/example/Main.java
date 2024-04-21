package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        // Crear una nueva sesión de Hibernate
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        while (!salir) {
            System.out.println("- - - - - - - - - - - - - - - - —  - - — - - -");
            System.out.println("\t\tBiblioteca");
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -");
            System.out.println("1- Insertar Libro");
            System.out.println("2- Insertar Lector");
            System.out.println("3- Listado Libros");
            System.out.println("4- Listado Lectores");
            System.out.println("5- Préstamo de Libro");
            System.out.println("6- Devolución de préstamo Libro");
            System.out.println("7- Ver Libro por ID");
            System.out.println("8- Ver Lector por ID");
            System.out.println("9- Salir");
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - -");

            int opcion;
            do {
                System.out.print("Seleccione una opción: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Por favor, ingrese un número válido.");
                    System.out.print("Seleccione una opción: ");
                    scanner.next(); // Limpiar el buffer del scanner
                }
                opcion = scanner.nextInt();
            } while (opcion <= 0);

            switch (opcion) {
                case 1:
                    // Insertar un libro
                    System.out.println("Ingrese los datos del libro:");

                    scanner.nextLine();

                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();

                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();

                    System.out.print("Año de publicación: ");
                    int anioPublicacion = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    System.out.print("¿Está disponible? (Si/No): ");
                    String disponibleStr = scanner.nextLine().toLowerCase(); // Convertir a minúsculas
                    boolean disponible = disponibleStr.equals("si");

                    // Iniciar una transacción
                    Transaction tx = session.beginTransaction();

                    // Crear un nuevo objeto Libro con los datos ingresados por el usuario
                    Libro nuevoLibro = new Libro(titulo, autor, anioPublicacion, disponible);

                    // Guardar el libro en la base de datos
                    session.save(nuevoLibro);

                    // Commit de la transacción
                    tx.commit();
                    System.out.println("Libro ingresado correctamente:");
                    System.out.println(nuevoLibro);
                    break;
                case 2:
                    // Lógica para insertar un lector
                    System.out.println("Ingrese los datos del lector:");

                    scanner.nextLine();

                    System.out.print("Nombre: ");
                    String nombreLector = scanner.nextLine();

                    System.out.print("Apellido: ");
                    String apellidoLector = scanner.nextLine();

                    System.out.print("Email: ");
                    String emailLector = scanner.nextLine();

                    // Iniciar una transacción
                    Transaction txLector = session.beginTransaction();

                    // Crear un nuevo objeto Lector con los datos ingresados por el usuario
                    Lector nuevoLector = new Lector(nombreLector, apellidoLector, emailLector);

                    // Guardar el lector en la base de datos
                    session.save(nuevoLector);

                    // Commit de la transacción
                    txLector.commit();

                    System.out.println("Lector ingresado correctamente:");
                    System.out.println(nuevoLector);
                    break;

                case 3:
                    // Listar libros
                    System.out.println("Listado de Libros:");
                    System.out.println("------------------");

                    // Consultar la base de datos para obtener todos los libros
                    Query<Libro> queryLibros = session.createQuery("FROM Libro", Libro.class);
                    List<Libro> libros = queryLibros.getResultList();

                    // Mostrar los libros en forma de tabla
                    System.out.printf("%-5s | %-30s | %-30s | %-10s | %-10s%n", "ID", "TÍTULO", "AUTOR", "AÑO", "DISPONIBLE");
                    System.out.println("-".repeat(85));
                    for (Libro libro : libros) {
                        System.out.printf("%-5d | %-30s | %-30s | %-10d | %-10s%n",
                                libro.getId(), libro.getTitulo(), libro.getAutor(), libro.getAnioPublicacion(), libro.isDisponible());
                    }

                    // Mostrar opciones de actualizar y borrar libro
                    System.out.println("Opciones:");
                    System.out.println("1- Actualizar libro");
                    System.out.println("2- Borrar libro");
                    System.out.println("0- Volver al menú principal");
                    System.out.print("Seleccione una opción: ");
                    int opcionActualizarBorrar = scanner.nextInt();

                    switch (opcionActualizarBorrar) {
                        case 1:
                            // Actualizar libro
                            System.out.print("Ingrese el ID del libro que desea actualizar: ");
                            int idActualizar = scanner.nextInt();
                            System.out.println("ID proporcionado: " + idActualizar); // Agregar esta línea para depurar
                            scanner.nextLine(); // Consumir el salto de línea

                            // Buscar el libro en la base de datos por su ID
                            Libro libroActualizar = session.get(Libro.class, idActualizar);

                            if (libroActualizar != null) {
                                // Pedir los nuevos datos del libro al usuario
                                System.out.print("Nuevo título: ");
                                String nuevoTitulo = scanner.nextLine();

                                System.out.print("Nuevo autor: ");
                                String nuevoAutor = scanner.nextLine();

                                System.out.print("Nuevo año de publicación: ");
                                int nuevoAnio = scanner.nextInt();
                                scanner.nextLine(); // Consumir el salto de línea

                                System.out.print("¿Está disponible? (Si/No): ");
                                String disponibleInput = scanner.nextLine().toLowerCase();
                                boolean nuevaDisponibilidad = disponibleInput.equals("si");

                                // Actualizar los datos del libro
                                libroActualizar.setTitulo(nuevoTitulo);
                                libroActualizar.setAutor(nuevoAutor);
                                libroActualizar.setAnioPublicacion(nuevoAnio);
                                libroActualizar.setDisponible(nuevaDisponibilidad);

                                // Iniciar una transacción para la actualización
                                Transaction txActualizar = session.beginTransaction();

                                try {
                                    // Actualizar el libro en la base de datos
                                    session.update(libroActualizar);

                                    // Commit de la transacción
                                    txActualizar.commit();

                                    System.out.println("Libro actualizado correctamente.");
                                } catch (Exception e) {
                                    // En caso de error, hacer rollback de la transacción
                                    txActualizar.rollback();
                                    System.out.println("Error al actualizar el libro: " + e.getMessage());
                                }
                            } else {
                                System.out.println("No se encontró ningún libro con el ID proporcionado.");
                            }
                            break;

                        case 2:
                            // Borrar libro
                            System.out.print("Ingrese el ID del libro que desea borrar: ");
                            int idBorrar = scanner.nextInt();
                            System.out.println("ID proporcionado para borrar: " + idBorrar); // Agregar esta línea para depurar

                            // Buscar el libro en la base de datos por su ID
                            Libro libroBorrar = session.get(Libro.class, idBorrar);

                            if (libroBorrar != null) {

                                Transaction txBorrarLibro = session.beginTransaction();
                                // Borrar el libro de la base de datos
                                session.delete(libroBorrar);

                                txBorrarLibro.commit();


                                System.out.println("Libro borrado correctamente.");
                            } else {
                                System.out.println("No se encontró ningún libro con el ID proporcionado.");
                            }
                            break;

                        case 0:
                            // Volver al menú principal
                            break;
                        default:
                            System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                            break;
                    }
                    break;


                case 4:
                    // Listar lectores
                    System.out.println("Listado de Lectores:");
                    System.out.println("--------------------");

                    // Consultar la base de datos para obtener todos los lectores
                    Query<Lector> queryLectores = session.createQuery("FROM Lector", Lector.class);
                    List<Lector> lectores = queryLectores.getResultList();

                    // Mostrar los lectores en forma de tabla
                    System.out.printf("%-5s | %-20s | %-20s | %-30s%n", "ID", "NOMBRE", "APELLIDO", "EMAIL");
                    System.out.println("-".repeat(75));
                    for (Lector lector : lectores) {
                        System.out.printf("%-5d | %-20s | %-20s | %-30s%n",
                                lector.getId(), lector.getNombre(), lector.getApellido(), lector.getEmail());
                    }

                    // Mostrar opciones de actualizar y borrar lector
                    System.out.println("Opciones:");
                    System.out.println("1- Actualizar lector");
                    System.out.println("2- Borrar lector");
                    System.out.println("0- Volver al menú principal");
                    System.out.print("Seleccione una opción: ");
                    int opcionActualizarBorrarLector = scanner.nextInt();

                    switch (opcionActualizarBorrarLector) {
                        case 1:
                            // Actualizar lector
                            System.out.print("Ingrese el ID del lector que desea actualizar: ");
                            int idActualizarLector = scanner.nextInt();
                            scanner.nextLine(); // Consumir el salto de línea

                            // Buscar el lector en la base de datos por su ID
                            Lector lectorActualizar = session.get(Lector.class, idActualizarLector);

                            if (lectorActualizar != null) {
                                // Pedir los nuevos datos del lector al usuario
                                System.out.print("Nuevo nombre: ");
                                String nuevoNombre = scanner.nextLine();

                                System.out.print("Nuevo apellido: ");
                                String nuevoApellido = scanner.nextLine();

                                System.out.print("Nuevo email: ");
                                String nuevoEmail = scanner.nextLine();

                                // Actualizar los datos del lector
                                lectorActualizar.setNombre(nuevoNombre);
                                lectorActualizar.setApellido(nuevoApellido);
                                lectorActualizar.setEmail(nuevoEmail);

                                // Iniciar una transacción
                                Transaction txActualizarLector = session.beginTransaction();

                                // Actualizar el lector en la base de datos
                                session.update(lectorActualizar);

                                // Commit de la transacción
                                txActualizarLector.commit();

                                System.out.println("Lector actualizado correctamente.");
                            } else {
                                System.out.println("No se encontró ningún lector con el ID proporcionado.");
                            }
                            break;
                        case 2:
                            // Borrar lector
                            System.out.print("Ingrese el ID del lector que desea borrar: ");
                            int idBorrarLector = scanner.nextInt();
                            scanner.nextLine(); // Consumir el salto de línea

                            // Buscar el lector en la base de datos por su ID
                            Lector lectorBorrar = session.get(Lector.class, idBorrarLector);

                            if (lectorBorrar != null) {
                                // Iniciar una transacción
                                Transaction txBorrarLector = session.beginTransaction();

                                // Borrar el lector de la base de datos
                                session.delete(lectorBorrar);

                                // Commit de la transacción
                                txBorrarLector.commit();

                                System.out.println("Lector borrado correctamente.");
                            } else {
                                System.out.println("No se encontró ningún lector con el ID proporcionado.");
                            }
                            break;
                        case 0:
                            // Volver al menú principal
                            break;
                        default:
                            System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                            break;
                    }
                    break;

                case 5:
                    // Préstamo de libro
                    System.out.println("Préstamo de Libro");

                    // Mostrar listado de libros disponibles
                    System.out.println("Listado de Libros Disponibles:");
                    System.out.println("-----------------------------");

                    // Consultar la base de datos para obtener todos los libros disponibles
                    Query<Libro> queryLibrosDisponibles = session.createQuery("FROM Libro WHERE disponible = true", Libro.class);
                    List<Libro> librosDisponibles = queryLibrosDisponibles.getResultList();

                    // Mostrar los libros disponibles en forma de tabla
                    System.out.printf("%-5s | %-30s | %-30s | %-10s%n", "ID", "TÍTULO", "AUTOR", "AÑO");
                    System.out.println("-".repeat(80));
                    for (Libro libro : librosDisponibles) {
                        System.out.printf("%-5d | %-30s | %-30s | %-10d%n",
                                libro.getId(), libro.getTitulo(), libro.getAutor(), libro.getAnioPublicacion());
                    }

                    // Mostrar listado de lectores disponibles
                    System.out.println("\nListado de Lectores Disponibles:");
                    System.out.println("--------------------------------");

                    // Consultar la base de datos para obtener todos los lectores disponibles
                    Query<Lector> queryLectoresDisponibles = session.createQuery("FROM Lector", Lector.class);
                    List<Lector> lectoresDisponibles = queryLectoresDisponibles.getResultList();

                    // Mostrar los lectores disponibles en forma de tabla
                    System.out.printf("%-5s | %-30s | %-30s | %-30s%n", "ID", "NOMBRE", "APELLIDO", "EMAIL");
                    System.out.println("-".repeat(95));
                    for (Lector lector : lectoresDisponibles) {
                        System.out.printf("%-5d | %-30s | %-30s | %-30s%n",
                                lector.getId(), lector.getNombre(), lector.getApellido(), lector.getEmail());
                    }

                    // Seleccionar un libro para el préstamo
                    System.out.print("\nIngrese el ID del libro que desea prestar: ");
                    int idLibroPrestamo = scanner.nextInt();

                    // Buscar el libro en la base de datos por su ID
                    Libro libroPrestamo = session.get(Libro.class, idLibroPrestamo);

                    if (libroPrestamo != null && libroPrestamo.isDisponible()) {
                        scanner.nextLine(); // Consumir el salto de línea
                        // Solicitar información del lector
                        System.out.print("Ingrese el ID del lector: ");
                        int idLectorPrestamo = scanner.nextInt();
                        scanner.nextLine(); // Consumir el salto de línea

                        Lector lectorPrestamo = session.get(Lector.class, idLectorPrestamo);

                        if (lectorPrestamo != null) {
                            // Guardar la información del préstamo en la tabla de préstamos
                            System.out.print("Fecha de préstamo (YYYY-MM-DD): ");
                            String fechaPrestamo = scanner.nextLine();

                            // Guardar la información del préstamo en la tabla de préstamos
                            Prestamo prestamo = new Prestamo(libroPrestamo, lectorPrestamo, fechaPrestamo);

                            // Iniciar una transacción
                            Transaction txPrestamo = session.beginTransaction();

                            // Guardar el préstamo en la base de datos
                            session.save(prestamo);

                            // Cambiar el estado del libro a no disponible
                            libroPrestamo.setDisponible(false);
                            session.update(libroPrestamo);

                            // Commit de la transacción
                            txPrestamo.commit();

                            System.out.println("Préstamo realizado correctamente.");
                        } else {
                            System.out.println("No se encontró ningún lector con el ID proporcionado.");
                        }
                    } else {
                        System.out.println("No se encontró ningún libro disponible con el ID proporcionado.");
                    }
                    break;

                case 6: // Nueva opción para devolución de préstamo
                    // Devolución de préstamo
                    System.out.println("Devolución de préstamo:");
                    System.out.println("----------------------");

                    // Consulta para obtener todos los préstamos
                    Query<Prestamo> queryPrestamos = session.createQuery("FROM Prestamo", Prestamo.class);
                    List<Prestamo> prestamos = queryPrestamos.getResultList();

// Mostrar la lista de préstamos en forma de tabla
                    System.out.printf("%-5s | %-10s | %-10s | %-20s | %-20s | %-15s%n", "ID", "ID_Libro", "ID_Lector", "Fecha_Prestamo", "Fecha_Devolucion", "Estado_Prestamo");
                    System.out.println("-".repeat(110));
                    for (Prestamo prestamo : prestamos) {
                        System.out.printf("%-5d | %-10d | %-10d | %-20s | %-20s | %-15s%n",
                                prestamo.getId(), prestamo.getLibro().getId(), prestamo.getLector().getId(), prestamo.getFechaPrestamo(), prestamo.getFechaDevolucion(), prestamo.getEstadoPrestamo());
                    }



                    // Solicitar al usuario que seleccione un préstamo para devolver
                    System.out.print("Seleccione el ID del préstamo a devolver: ");
                    int idPrestamoADevolver = scanner.nextInt();

                    // Buscar el préstamo seleccionado en la base de datos
                    Prestamo prestamoADevolver = session.get(Prestamo.class, idPrestamoADevolver);

                    if (prestamoADevolver != null) {
                        // Solicitar la fecha de devolución al usuario
                        System.out.print("Ingrese la fecha de devolución (YYYY-MM-DD): ");
                        String fechaDevolucionStr = scanner.next();
                        // Convertir la cadena de fecha a un objeto Date
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        Date fechaDevolucion = sdf.parse(fechaDevolucionStr);

                        // Actualizar el estado del préstamo y la fecha de devolución
                        prestamoADevolver.setEstadoPrestamo("Devuelto");
                        prestamoADevolver.setFechaDevolucion(fechaDevolucion);
                        // Actualizar el estado del libro a disponible
                        prestamoADevolver.getLibro().setDisponible(true);

                        // Guardar los cambios en la base de datos
                        session.update(prestamoADevolver);
                        // Confirmar la transacción existente


                        System.out.println("Préstamo devuelto correctamente.");

                    } else {
                        System.out.println("No se encontró ningún préstamo con el ID proporcionado.");
                    }
                    break;




                case 7:
                    // Ver libro por ID
                    System.out.println("Ver Libro por ID");
                    System.out.println("-----------------");

                    // Solicitar al usuario que ingrese el ID del libro a ver
                    System.out.print("Ingrese el ID del libro que desea ver: ");
                    int idLibroVer = scanner.nextInt();

                    // Buscar el libro en la base de datos por su ID
                    Libro libroVer = session.get(Libro.class, idLibroVer);

                    if (libroVer != null) {
                        // Mostrar información del libro en forma de tabla
                        System.out.println("Información del Libro:");
                        System.out.printf("%-15s | %-40s%n", "Atributo", "Valor");
                        System.out.println("-".repeat(60));
                        System.out.printf("%-15s | %-40s%n", "ID", libroVer.getId());
                        System.out.printf("%-15s | %-40s%n", "Título", libroVer.getTitulo());
                        System.out.printf("%-15s | %-40s%n", "Autor", libroVer.getAutor());
                        System.out.printf("%-15s | %-40s%n", "Año de Publicación", libroVer.getAnioPublicacion());
                        System.out.printf("%-15s | %-40s%n", "Disponible", libroVer.isDisponible() ? "Sí" : "No");

                        // Consultar la base de datos para obtener el historial de préstamos del libro
                        Query<Prestamo> queryHistorial = session.createQuery("FROM Prestamo WHERE libro.id = :libroId", Prestamo.class);
                        queryHistorial.setParameter("libroId", idLibroVer);
                        List<Prestamo> historialPrestamos = queryHistorial.getResultList();

                        // Mostrar historial de préstamos del libro en forma de tabla
                        if (!historialPrestamos.isEmpty()) {
                            System.out.println("\nHistorial de Préstamos:");
                            System.out.printf("%-10s | %-20s | %-20s | %-20s%n", "ID Préstamo", "Lector", "Fecha Préstamo", "Fecha Devolución");
                            System.out.println("-".repeat(85));
                            for (Prestamo prestamo : historialPrestamos) {
                                System.out.printf("%-10d | %-20s | %-20s | %-20s%n",
                                        prestamo.getId(), prestamo.getLector().getNombreCompleto(), prestamo.getFechaPrestamo(), prestamo.getFechaDevolucion());
                            }
                        } else {
                            System.out.println("El libro no tiene historial de préstamos.");
                        }
                    } else {
                        System.out.println("No se encontró ningún libro con el ID proporcionado.");
                    }
                    break;



                case 8:
                    // Ver lector por ID
                    System.out.println("Ver Lector por ID");
                    System.out.println("------------------");

                    // Solicitar al usuario que ingrese el ID del lector a ver
                    System.out.print("Ingrese el ID del lector que desea ver: ");
                    int idLectorVer = scanner.nextInt();

                    // Buscar el lector en la base de datos por su ID
                    Lector lectorVer = session.get(Lector.class, idLectorVer);

                    if (lectorVer != null) {
                        // Mostrar información del lector en forma de tabla
                        System.out.println("Información del Lector:");
                        System.out.printf("%-15s | %-40s%n", "Atributo", "Valor");
                        System.out.println("-".repeat(60));
                        System.out.printf("%-15s | %-40s%n", "ID", lectorVer.getId());
                        System.out.printf("%-15s | %-40s%n", "Nombre", lectorVer.getNombre());
                        System.out.printf("%-15s | %-40s%n", "Apellido", lectorVer.getApellido());
                        System.out.printf("%-15s | %-40s%n", "Email", lectorVer.getEmail());

                        // Consultar la base de datos para obtener el historial de préstamos del lector
                        Query<Prestamo> queryHistorialLector = session.createQuery("FROM Prestamo WHERE lector.id = :lectorId", Prestamo.class);
                        queryHistorialLector.setParameter("lectorId", idLectorVer);
                        List<Prestamo> historialPrestamosLector = queryHistorialLector.getResultList();

                        // Mostrar historial de préstamos del lector en forma de tabla
                        if (!historialPrestamosLector.isEmpty()) {
                            System.out.println("\nHistorial de Préstamos del Lector:");
                            System.out.printf("%-10s | %-30s | %-20s | %-20s%n", "ID Préstamo", "Libro", "Fecha Préstamo", "Fecha Devolución");
                            System.out.println("-".repeat(85));
                            for (Prestamo prestamo : historialPrestamosLector) {
                                System.out.printf("%-10d | %-30s | %-20s | %-20s%n",
                                        prestamo.getId(), prestamo.getLibro().getTitulo(), prestamo.getFechaPrestamo(), prestamo.getFechaDevolucion());
                            }
                        } else {
                            System.out.println("El lector no tiene historial de préstamos.");
                        }
                    } else {
                        System.out.println("No se encontró ningún lector con el ID proporcionado.");
                    }
                    break;

                case 9:
                    // Salir del programa
                    System.out.println("Gracias por utilizar la Biblioteca. ¡Hasta luego!");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida del menú.");
            }
        }
        scanner.close();
    }
}
