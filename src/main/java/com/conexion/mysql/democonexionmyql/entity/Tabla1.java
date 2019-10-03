package com.conexion.mysql.democonexionmyql.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tabla1 {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer campo1;
    private String campo2;
    private String campo3;

    public Integer getCampo1() {
        return campo1;
    }

    public String getCampo2() {
        return campo2;
    }

    public String getCampo3() {
        return campo3;
    }

    public void setCampo1(Integer campo1) {
        this.campo1 = campo1;
    }

    public void setCampo2(String campo2) {
        this.campo2 = campo2;
    }

    public void setCampo3(String campo3) {
        this.campo3 = campo3;
    }
}
