package com.br.applica.entidades;

public class Reserva {
	
	String nome_produto, data_retirada;
	int id_img;
	
	public Reserva(){
		}

	public String getNome_produto() {
		return nome_produto;
	}

	public void setNome_produto(String nome_produto) {
		this.nome_produto = nome_produto;
	}

	public String getData_retirada() {
		return data_retirada;
	}

	public void setData_retirada(String data_retirada) {
		this.data_retirada = data_retirada;
	}

	public int getId_img() {
		return id_img;
	}

	public void setId_img(int id_img) {
		this.id_img = id_img;
	}

	

}
