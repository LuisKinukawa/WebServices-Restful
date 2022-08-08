package br.com.fiap.springboot.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@SequenceGenerator(name = "categoria", sequenceName = "SQ_CATEGORIA", allocationSize = 1)
public class PontosColeta {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categoria")
	private int codigo;

	@NotBlank(message = "Nome obrigatório!")
	@Size(max = 50)
	private String nome;
	
	@NotBlank(message = "Endereço obrigatório!")
	@Size(max = 50)
	private String endereco;

	@Column(name="tp_material",length=30)
	private String material;

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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	
	
}	
	
	
	
