package br.com.montadora.teste;

import java.sql.Connection;

import br.com.montadora.conexao.Conexao;
import br.com.montadora.dao.MotoDAO;
import br.com.montadora.model.Moto;

public class MotoAlterar {
	public static void main(String[] args) {
		
		Connection con = Conexao.abrirConexao();
		Moto moto = new Moto();
		MotoDAO motoDAO = new MotoDAO(con);
		
		moto.setNomeCarro("XJ6");
		moto.setMontadora("Yakuza");
		moto.setQuantidadeAdesivos(20);
		System.out.println(motoDAO.alterar(moto));
		
		Conexao.fecharConexao(con);
	}
}
