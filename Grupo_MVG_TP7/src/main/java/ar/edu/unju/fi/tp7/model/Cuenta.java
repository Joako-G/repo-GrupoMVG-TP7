package ar.edu.unju.fi.tp7.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "CUENTAS")
public class Cuenta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "cuen_saldo")
	private double saldo;
	
	@Column(name = "cuen_fechaCreacion")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaCreacion;
	
	@Column(name = "cuen_estado")
	private String estado;
	
	public Cuenta() {
		super();
	}

	public Cuenta(Long id, double saldo, LocalDate fechaCreacion, String estado) {
		super();
		this.id = id;
		this.saldo = saldo;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Cuenta [id=" + id + ", saldo=" + saldo + ", fechaCreacion=" + fechaCreacion + ", estado=" + estado
				+ "]";
	}
	
	
}
