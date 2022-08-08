package br.com.fiap.springboot.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
@SequenceGenerator(name = "produto", sequenceName = "SQ_PRODUTO", allocationSize = 1)
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto")
	private int codigo;

	@NotBlank(message = "Nome obrigatório!")
	@Size(max = 50)
	private String nome;

	@Min(value = 0, message = "Peso não pode ser negativo")
	private double peso;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="codigo", nullable = false, insertable = false, updatable = false)
	private Categoria categoria;
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	
	
	

}
