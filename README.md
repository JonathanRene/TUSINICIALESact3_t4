# Actividad 3: CRUD en Spring Boot con Relación @ManyToOne / @OneToMany

Proyecto desarrollado para la materia, implementando una API REST conectada a MySQL y desplegada en un servidor VPS Ubuntu.

## 🛠️ Tecnologías Utilizadas
- Java 17 / Spring Boot 4.1.2 (Spring Data JPA, Spring Web)
- Base de datos MySQL (con cotejamiento `utf8mb4_general_ci`)
- Maven (Gestión de dependencias y empaquetado `.jar`)
- Entorno de pruebas: Postman
- Servidor VPS: Ubuntu 24.04 LTS (Nginx / MySQL)

## 🗂️ Arquitectura del Proyecto
El proyecto está estructurado en capas limpias:
- **Models / Entidades:** `Escuela` y `Alumno`
- **Repositories:** `EscuelaRepository` y `AlumnoRepository`
- **Services:** `EscuelaService` y `AlumnoService`
- **Controllers:** `EscuelaController` y `AlumnoController`

---

## 📷 Evidencias y Capturas de Pantalla

### 1. Entidades Relacionadas (Escuela y Alumno)
<p align="center">
  <b>Relación Escuela y Alumno en Postman</b><br>
  <img src="./img/Captura%20de%20pantalla%202026-11-10%20195117.png" alt="Relación Escuela y Alumno" width="750">
</p>

### 2. Operaciones del CRUD Funcionando
- **Crear (POST):** Registro exitoso de escuelas y alumnos.
- **Leer (GET):** Consulta de listas e individuales.
- **Actualizar (PUT):** Modificación de registros.
- **Eliminar (DELETE):** Baja de registros.
*(Inserta tus capturas de Postman aquí)*

### 3. Relación Reflejada Correctamente
Demostración de cómo al consultar un Alumno se muestra el objeto completo de su Escuela asociada (y no solo su ID).
*(Inserta tu captura clave de Postman aquí, idéntica a la que validamos en local/VPS)*
