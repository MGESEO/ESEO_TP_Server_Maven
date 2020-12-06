package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
		//test
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
			con.close();
		} catch (SQLException e) {
			Logger.getLogger("logger").log(Level.WARNING, "Context",e);
		}
		return villes;
	}

	@Override
	public void setVille(Ville ville) {
		String requete = "INSERT INTO ville_france VALUES (";
		requete += "'"+ville.getCodeCommune();
		requete += "', '"+ville.getNomCommune();
		requete += "', '"+ville.getCodePostal();
		requete += "', '"+ville.getLibelleAcheminement();
		requete += "', '"+ville.getLigne();
		requete += "', '"+ville.getLatitude();
		requete += "', '"+ville.getLongitude();
		requete += "' )";
		
		//test
		try {
			Connection con = JDBCConfiguration.getConnexionBDD();
			Statement stmt = con.createStatement();
			stmt.executeUpdate(requete);
			con.close();
		} catch (SQLException e) {
			Logger.getLogger("logger").log(Level.WARNING, "Context",e);
		}
	}

	@Override
	public ArrayList<Ville> getInfoVilles(String param) {
		Ville ville = null;
		ArrayList<Ville> villes = new ArrayList<Ville>();

		String requete = "SELECT * FROM ville_france WHERE Code_postal="+param;
		//test
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
			System.out.println(param);
			System.out.println(villes);
			con.close();
		} catch (SQLException e) {
			Logger.getLogger("logger").log(Level.WARNING, "Context",e);
		}
		return villes;
	}

	@Override
	public void mettreAJour(Ville ville) {
		String requete = "UPDATE `ville_france` SET `Nom_commune`='"+ville.getNomCommune()
		+"',`Code_postal`='"+ville.getCodePostal()
		+"',`Libelle_acheminement`='"+ville.getLibelleAcheminement()
		+"',`Ligne_5`='"+ville.getLigne()
		+"',`Latitude`='"+ville.getLatitude()
		+"',`Longitude`='"+ville.getLongitude()
		+ "' WHERE Code_commune_INSEE = '"+ville.getCodeCommune()+"'";
		
		//test
		try {
			Connection con = JDBCConfiguration.getConnexionBDD();
			Statement stmt = con.createStatement();
			stmt.executeUpdate(requete);
			con.close();
		} catch (SQLException e) {
			Logger.getLogger("logger").log(Level.WARNING, "Context",e);
		}
		
	}

	@Override
	public void supprimerLigne(String code_commune_INSEE) {
		String requete = "DELETE FROM ville_france WHERE Code_commune_INSEE = "+code_commune_INSEE;
		//test
		try {
			Connection con = JDBCConfiguration.getConnexionBDD();
			Statement stmt = con.createStatement();
			stmt.executeUpdate(requete);
			con.close();
		}
		 catch (SQLException e) {
			Logger.getLogger("logger").log(Level.WARNING, "Context",e);
		}
		
	}

}
