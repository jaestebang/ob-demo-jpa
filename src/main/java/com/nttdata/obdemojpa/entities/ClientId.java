package com.nttdata.obdemojpa.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Multiple keys ID
 */
@Embeddable
public class ClientId implements Serializable {
    @Getter
    @Setter
    @Column(name = "type_dni")
    private String typeDni;

    @Getter
    @Setter
    @Column(name = "dni")
    private int dni;

    public ClientId() {
    }

    public ClientId(String type, int dni) {
        this.typeDni = type;
        this.dni = dni;
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeDni, dni);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj== null || getClass() != obj.getClass()) return false;
        return typeDni.equals(((ClientId)obj).typeDni) && dni == ((ClientId)obj).dni;
    }
}
