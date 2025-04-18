package br.com.montadora.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.montadora.model.Carro;

public class CarroDAO {
	
	private Connection con = null;

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	public CarroDAO(Connection con) {
		setCon(con);
	}
	

	public String inserir(Carro carro) {
		String sql = "insert into carro(montadora, nome_carro, quantidade_portas) values (?,?,?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1,  carro.getMontadora());
			ps.setString(2, carro.getNomeCarro());
			ps.setInt(3, carro.getQuantidadePortas());
			if (ps.executeUpdate() > 0) {
				return "Carro inserido com sucesso";
			} else {
				return "Erro inserir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
		
		public String deletar(Carro carro) {
			String sql = "delete from carro where montadora = ?";
			try {
				PreparedStatement ps = getCon().prepareStatement(sql);
				ps.setString(1,  carro.getMontadora());
				if (ps.executeUpdate() > 0) {
					return "Deletado com sucesso";
				} else {
					return "Erro deletar";
				}
			} catch (SQLException e) {
				return e.getMessage();
			}
		}
		
		public String deletarWhereNome(Carro carro) {
			String sql = "delete from carro where nome_carro = ?";
			try {
				PreparedStatement ps = getCon().prepareStatement(sql);
				ps.setString(1,  carro.getNomeCarro());
				if (ps.executeUpdate() > 0) {
					return "Deletado com sucesso";
				} else {
					return "Erro deletar";
				}
			} catch (SQLException e) {
				return e.getMessage();
			}
		}
		
		public String deletarSemWhere() {
			String sql = "delete from carro";
			try {
				PreparedStatement ps = getCon().prepareStatement(sql);
				if (ps.executeUpdate() > 0) {
					return "Deletado com sucesso";
				} else {
					return "Erro deletar";
				}
			} catch (SQLException e) {
				return e.getMessage();
			}
		}
		
		public String alterar(Carro carro) {
			String sql = "update carro set montadora = ?, quantidade_portas = ? where nome_carro = ?";
			try {
				PreparedStatement ps = getCon().prepareStatement(sql);
				ps.setString(1,  carro.getMontadora());
				ps.setDouble(2,  carro.getQuantidadePortas());
				ps.setString(3,  carro.getNomeCarro());
				if (ps.executeUpdate() > 0) {
					return "Alterado com sucesso";
				} else {
					return "Erro ao alterar";
				}
			} catch (SQLException e) {
				return e.getMessage();
			}
		}
		
	}



