package com.conexion.mysql.democonexionmyql.controller;

import com.conexion.mysql.democonexionmyql.Repository.Tabla1Repository;
import com.conexion.mysql.democonexionmyql.ResourceNotFoundException;
import com.conexion.mysql.democonexionmyql.entity.Tabla1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Tabla1Controller {
    @Autowired
    //This annotation allows Spring to resolve and inject collaborating beans into your bean.
    Tabla1Repository tabla1Repository;
    @GetMapping("/datos")
    public List<Tabla1> getAllDatos() {
        return tabla1Repository.findAll();
    }
    @PostMapping("/datos")
    public Tabla1 createNote(@Valid @RequestBody Tabla1 tabla1) {
        return tabla1Repository.save(tabla1);
    }

    @GetMapping("/datos/{id}")
    public Tabla1 getDatoById(@PathVariable(value = "id") Integer campo1) {
        return tabla1Repository.findById(campo1)
                .orElseThrow(() -> new ResourceNotFoundException("Dato", "id", campo1));
    }


    @PutMapping("/datos/{id}")
    public Tabla1 updateDato(@PathVariable(value = "id") Integer campo1,
                           @Valid @RequestBody Tabla1 datoDetails) {

        Tabla1 dato = tabla1Repository.findById(campo1)
                .orElseThrow(() -> new ResourceNotFoundException("Dato", "id", campo1));

        dato.setCampo2(dato.getCampo2());
        dato.setCampo3(dato.getCampo3());

        Tabla1 updatedDato = tabla1Repository.save(dato);
        return updatedDato;
    }

    @DeleteMapping("/datos/{id}")
    public ResponseEntity<?> deleteDato(@PathVariable(value = "id") Integer campo1) {
        Tabla1 dato = tabla1Repository.findById(campo1)
                .orElseThrow(() -> new ResourceNotFoundException("Dato", "id", campo1));

        tabla1Repository.delete(dato);

        return ResponseEntity.ok().build();
    }

    /*
    https://www.callicoder.com/spring-boot-rest-api-tutorial-with-mysql-jpa-hibernate/
    http://localhost:8080/api/datos get y post
    http://localhost:8080/api/datos/2

     */
}
