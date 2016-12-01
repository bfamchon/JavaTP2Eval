package com.constante;

/**
 * Classe regroupant nos constantes d'accès aux bases
 */
public class Constante {

	public static final String CONNEXION_CONFIG = "jdbc:mysql://webtp.fil.univ-lille1.fr/famchon?" +
					                               "user=famchon&password=BLABLA";

	public static final String CONNEXION_CONFIG_BAPTISTE = "jdbc:mysql://localhost/personnels?" + "user=root&password=rootpassdb";
	public static final String CONNEXION_CONFIG_LAURENT = "jdbc:mysql://localhost/personnels?" + "user=root";
	
	public final static String IDENTIFIANT_PERSONNE = "IDPERS";
	public static final String MESSAGE_ERREUR = "MSGERROR";
	public static final String UTILISATEUR = "UTILISATEUR";
    public static final String PERE = "PAPAJETAIME";
	public static final String EVALUATION = "EVALUATION";
	public static final String EXFILS = "EXFILS";

}
