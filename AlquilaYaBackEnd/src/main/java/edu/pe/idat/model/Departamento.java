package edu.pe.idat.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "departamento")
public class Departamento {
	
	@Id
    @GeneratedValue()
    private int id;

    private String titulo;

    private String direccion;

    private String distrito;

    private BigDecimal precio;
    
    @ManyToOne
    private User usuario; 

    @Builder.Default
    private boolean disponible = true;

    private String imagen1;

}
