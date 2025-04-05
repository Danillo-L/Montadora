package br.com.montadora.teste;

import java.sql.Connection;

import br.com.montadora.conexao.Conexao;
import br.com.montadora.dao.CarroDAO;
import br.com.montadora.model.Carro;

public class CarroAlterar {
	public static void main(String[] args) {
		Connection con = Conexao.abrirConexao();
			
		Carro carro = new Carro();
		CarroDAO carroDAO = new CarroDAO(con);		
		
		carro.setNomeCarro("Urus");
		carro.setMontadora("Peugeot");
		carro.setQuantidadePortas(2);		
		System.out.println(carroDAO.alterar(carro));
		
		Conexao.fecharConexao(con);
	}

}
