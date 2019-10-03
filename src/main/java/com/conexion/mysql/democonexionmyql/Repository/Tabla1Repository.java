package com.conexion.mysql.democonexionmyql.Repository;

import com.conexion.mysql.democonexionmyql.entity.Tabla1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
Es el package que contiene las interfaces que extienden de JPA para que estas
clases se conecten a la base de datos. Estas gestionan información
ya sea de buscar, borrar, actualizar o crear un registro en la base de datos.
 */
@Repository
public interface Tabla1Repository extends JpaRepository<Tabla1, Integer> {
}
