# Pruebas Técnicas

- Este es el repositorio de la primera prueba técnica de Empleados. 
- En primer lugar he creeado un proyecto Maven y configurado para que se conecte con la base de datos. 
- Despues he creado los distintos paquetes (entities, controllers y persistence), META-INF 
- He creado los archivos que me van a hacer falta para cada paquete aunqeu aun están en blanco. 
- los primeros archivos en desarrollar son pom (donde defino las dependecias), persistence (configuración para la bbdd)y configJPA ( para 
la configuración y gestión de EntityManager).
- Los siguiente que he creado ha sido mi entidad Empleado con sus atributos, constructores, getters, setters y toString
- En el archivo EmpleadoController creo una instancia de EmpleadoJPA donde desarrollaré los métodos CRUD y validaciones. Tambien incluyo el metodo create.
- En el archivo EmpleadoJPA desarrollo los métodos, empiezo por las validaciones necesarias para poder creat un objeto Empleado adecuadamente. Despues creo el método CREATE.

