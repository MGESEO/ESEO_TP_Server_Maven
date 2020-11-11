package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.config.JDBCConfiguration;
import com.dto.Ville;

@Repository
public class VilleDAOImpl implements VilleDAO {

	@Override
	public ArrayList<Ville> getInfoVille() {
		Ville ville = null;
		ArrayList<Ville> villes = new ArrayList<Ville>();

		String requete = "SELECT * FROM ville_france";

		try(
			Connection con = JDBCConfiguration.getConnexionBDD();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(requete)
		)
		{
			while (rs.next()) {
				ville = new Ville();
				ville.setCodeCommune(rs.getString(1));
				ville.setCodePostal(rs.getString(3));
				ville.setNomCommune(rs.getString(2));
				ville.setLibelleAcheminement(rs.getString(4));
				ville.setLigne(rs.getString(5));
				ville.setLatitude(rs.getString(6));
				ville.setLongitude(rs.getString(7));
				villes.add(ville);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return villes;
	}

	@Override
	public void setVille(Ville ville) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Ville> getInfoVilles(String param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void mettreAJour(Ville ville) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerLigne(String code_commune_INSEE) {
		// TODO Auto-generated method stub
		
	}

	/*
	@Override
	public ArrayList<Ville> findAllVilles() {
		ArrayList<Ville> listVille = new ArrayList<Ville>();
		
		
		// TODO récupération et requêtes SQL
		
		return listVille;
	}
	 */
	
	
}
