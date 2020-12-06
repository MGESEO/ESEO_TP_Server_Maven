package com.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blo.VilleBLO;
import com.dto.Ville;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(description="API pour les villes")
@RestController
public class VilleController {
	
	@Autowired
	VilleBLO villeService;

	// Methode GET
    @ApiOperation(value = "Récupère toutes les villes de la base de données, vous pouvez rechercher une ville par son code postal également !")
	@RequestMapping(value = "/ville", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<Ville> appelGet(
			@ApiParam(value="Le code postal de la ville recherchée, laissez vide pour voir toutes les villes",required = false)
			@RequestParam(required = false, value = "codePostal") String monParam)
			throws ClassNotFoundException, SQLException {
		System.out.println("Appel GET");
		System.out.println("param = " + monParam);
		ArrayList<Ville> ville = villeService.getInfoVille(monParam);
		return ville;
	}

	// Methode POST
    @ApiOperation(value = "Insère une ville dans la base de données")
	@RequestMapping(value = "/ville", method = RequestMethod.POST)
	@ResponseBody
	public void appelPost(@RequestBody Ville ville) throws ClassNotFoundException, SQLException {
		System.out.println("Appel POST");
		villeService.creerVille(ville);
	}

	// Methode PUT
    @ApiOperation(value = "Met à jour une ville de la base de données")
	@RequestMapping(value = "/ville", method = RequestMethod.PUT)
	@ResponseBody
	public void appelPut(@RequestBody Ville ville) throws ClassNotFoundException, SQLException {
		System.out.println("Appel PUT");
		villeService.mettreAJour(ville);
		System.out.println("param = " + ville);
	}

	// Methode DELETE
    @ApiOperation(value = "Supprime une ville de la base de données")
	@RequestMapping(value = "/ville", method = RequestMethod.DELETE)
	public void appelDelete(
			@ApiParam(value="Le code postal de la ville à supprimer", required = true)
			@RequestParam(required = true, value = "codeCommuneINSEE") String Code_commune_INSEE) throws Exception {
		System.out.println("Appel DELETE");
		villeService.supprimerLigne(Code_commune_INSEE);
	}
}
