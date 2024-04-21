# PAC Desarrollo Acceso a Datos

Bienvenidos a la PAC de Desarrollo de Ángel Cazorla

En esta PAC vamos a desarrollar una aplicación para la gestión de una Biblioteca.





## Tecnología Utilizada

* Java
* Hibernate
* PhpMyAdmin (MySQL)



## Aplicaciones Utilizada

* Intellij
* XAMPP


## Instalación

Intalación del Proyecto

Para la instalación del proyecto primeramente nos descargaremos los archivos del mismo, y seguidamente configuraremos la base de datos y la aplicacion, con los siguientes pasos.

* Descargaremos, instalaremos y configuramos XAMPP, e iniciamos los servicios Apache y MySQL.

  ![Captura de pantalla 2024-04-21 a las 16 28 29](https://github.com/biper1985/PAC_ACCESO_DATOS/assets/121583659/72731f4e-d500-43aa-8bf6-b27a919351b6)


* Configuración de la aplicacion mediante hibernate. Editaremos la ruta de la base de datos, el usuario y la contraseña

  
![Captura de pantalla 2024-04-21 a las 16 14 06](https://github.com/biper1985/PAC_ACCESO_DATOS/assets/121583659/8b62feaf-8804-4ca7-a6f8-1a006ec84cbd)

* Creamos la base de datos de PhpmyAdmin (acceso_datos) y sus tablas.

  ![Captura de pantalla 2024-04-21 a las 16 16 49](https://github.com/biper1985/PAC_ACCESO_DATOS/assets/121583659/f2518fbf-5574-40bc-ab79-ead2acd3c08a)

## Pruebas y puesta en marcha del proyecto

Para ejecutar nuestro proyecto ejecutaremos el archivo Main que esta dentro de nuestra carpeta src/main , seguidamente nuestro proyectos se conectara a nuestra base de datos y mostrara el siguiente menú principal:


   ![Captura de pantalla 2024-04-21 a las 16 36 20](https://github.com/biper1985/PAC_ACCESO_DATOS/assets/121583659/a0e78000-a43a-477c-be0c-aa175fa4cf33)


* Insertar un libro

  ![Captura de pantalla 2024-04-21 a las 16 39 06](https://github.com/biper1985/PAC_ACCESO_DATOS/assets/121583659/1b13f92f-336e-4a05-8f7b-f8e315c08053)

* Insertar Lector

  ![Captura de pantalla 2024-04-21 a las 16 40 28](https://github.com/biper1985/PAC_ACCESO_DATOS/assets/121583659/7c750095-ee83-4bd1-8a78-80fe81c49162)

* Listado Libros
  
  ![Captura de pantalla 2024-04-21 a las 16 45 06](https://github.com/biper1985/PAC_ACCESO_DATOS/assets/121583659/c7deec79-654d-4105-b974-6c2ef4df8954)
  ![Captura de pantalla 2024-04-21 a las 16 45 27](https://github.com/biper1985/PAC_ACCESO_DATOS/assets/121583659/4d998394-2bec-4e82-bf02-bfe7488ad036)

  En este apartado he insertado un CRUD para poder Actualizar la información del Libro o borrar dicho libro.

  ![Captura de pantalla 2024-04-21 a las 16 47 55](https://github.com/biper1985/PAC_ACCESO_DATOS/assets/121583659/b61dc194-7a68-4e46-ac9e-e27dc0d6a1c1)
  
  ![Captura de pantalla 2024-04-21 a las 16 48 32](https://github.com/biper1985/PAC_ACCESO_DATOS/assets/121583659/1e8c5256-a02f-44f4-97a8-8f5717d3f6c0)

  Borramos el libro

  ![Captura de pantalla 2024-04-21 a las 16 49 26](https://github.com/biper1985/PAC_ACCESO_DATOS/assets/121583659/17737023-4f80-4c4d-89bb-71c0cc3f3330)
  
  ![Captura de pantalla 2024-04-21 a las 16 49 51](https://github.com/biper1985/PAC_ACCESO_DATOS/assets/121583659/0b55166f-08e9-4b15-8080-4a3a7f475296)


* Listado Lectores

  ![Captura de pantalla 2024-04-21 a las 16 51 20](https://github.com/biper1985/PAC_ACCESO_DATOS/assets/121583659/55c3491b-4ac7-4d76-b139-511b460a8b1b)

  ![Captura de pantalla 2024-04-21 a las 16 52 06](https://github.com/biper1985/PAC_ACCESO_DATOS/assets/121583659/df5abfde-17b6-4b7d-98d7-d7920403fef5)

  Aquí como hicimos con los Libros insertados hemos insertado un CRUD para poder Actualizar o Borrar un Lector.

  ![Captura de pantalla 2024-04-21 a las 16 53 37](https://github.com/biper1985/PAC_ACCESO_DATOS/assets/121583659/c8d5c5ba-356e-4577-8923-b877db6ffd05)

  ![Captura de pantalla 2024-04-21 a las 16 54 13](https://github.com/biper1985/PAC_ACCESO_DATOS/assets/121583659/26535857-9e4b-46cc-a984-6111e93e1837)

  Borramos al Lector

  ![Captura de pantalla 2024-04-21 a las 16 54 50](https://github.com/biper1985/PAC_ACCESO_DATOS/assets/121583659/80aadd0a-2757-4874-bdf0-21b45dbda381)

  ![Captura de pantalla 2024-04-21 a las 16 55 17](https://github.com/biper1985/PAC_ACCESO_DATOS/assets/121583659/d03ab9db-a735-4aa5-961a-7d94feab17ba)


* Préstamo de Libro

  ![Captura de pantalla 2024-04-21 a las 16 56 27](https://github.com/biper1985/PAC_ACCESO_DATOS/assets/121583659/5d80ffa9-5f5e-4c03-9a23-980ca7dbafea)

  Nos muestra los Libros Disponibles y los Lectores que hay en la base de datos, para poder asociar el libro al lector.

  ![Captura de pantalla 2024-04-21 a las 16 57 19](https://github.com/biper1985/PAC_ACCESO_DATOS/assets/121583659/94f9925d-5628-41fa-9761-e4c268a10ef9)

  ![Captura de pantalla 2024-04-21 a las 16 58 58](https://github.com/biper1985/PAC_ACCESO_DATOS/assets/121583659/d83a741e-df1f-4cb6-96fa-44fa223158bc)


* Devolución de préstamo Libro

  ![Captura de pantalla 2024-04-21 a las 17 07 55](https://github.com/biper1985/PAC_ACCESO_DATOS/assets/121583659/2cf03615-b53b-48ae-bdcb-a992c42d846f)

  ![Captura de pantalla 2024-04-21 a las 17 08 37](https://github.com/biper1985/PAC_ACCESO_DATOS/assets/121583659/34f01760-fdfd-4398-aa7c-68300171f7d2)

  ![Captura de pantalla 2024-04-21 a las 17 09 03](https://github.com/biper1985/PAC_ACCESO_DATOS/assets/121583659/28f5f06a-62b9-4645-9376-fafa73711418)


* Ver libro por ID

  ![Captura de pantalla 2024-04-21 a las 17 10 18](https://github.com/biper1985/PAC_ACCESO_DATOS/assets/121583659/b878eebb-bed9-4c7c-b168-4773376c8f8d)

  ![Captura de pantalla 2024-04-21 a las 17 10 54](https://github.com/biper1985/PAC_ACCESO_DATOS/assets/121583659/bf92a69d-5ea1-43c3-8b6f-18c318db10aa)

* Ver lector por ID

  ![Captura de pantalla 2024-04-21 a las 17 11 47](https://github.com/biper1985/PAC_ACCESO_DATOS/assets/121583659/b44576c3-74aa-4e10-8a67-e6fa0eae75d5)

  ![Captura de pantalla 2024-04-21 a las 17 12 06](https://github.com/biper1985/PAC_ACCESO_DATOS/assets/121583659/7a16828e-a46d-47d1-885f-cd5dff97ac2a)


* Salir

  ![Captura de pantalla 2024-04-21 a las 17 12 42](https://github.com/biper1985/PAC_ACCESO_DATOS/assets/121583659/fbe657e8-259e-43ed-ad74-0ab7e19fa1de)









  





  



