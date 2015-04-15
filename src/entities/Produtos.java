package entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/*
 --DDL from Entity
 CREATE TABLE PRODUTOS(
	ID integer primary key auto_increment,
	NOME VARCHAR(20),
	PRECO DECIMAL(10,2),
	DATA_CAD DATE
);
 * */

/**
 * entity produtos "products"
 * @author Solutionbto
 *
 */
@Entity
public class Produtos {
	
	@Id
	@GeneratedValue
	private int id;
	private String nome;
	private double preco;
	private Date data_cad;
	
	public int getId() {
		return id;
	}
	
	//sem acesso pois é generator
	private void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public Date getData_cad() {
		return data_cad;
	}
	public void setData_cad(Date data_cad) {
		this.data_cad = data_cad;
	}
}