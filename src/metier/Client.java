package metier;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Client
{
	/** 
	 * Crée un client.
	 * @param nom le nom du client. 
	 */
	private String nom;
	ArrayList <Facture> factures ;
	static ArrayList <Client> clients;
	
	public Client(String nom)
	{
		this.nom=nom;
		clients.add(this);
	}

	/**
	 * Retourne le nom du client.
	 * @return le nom du client.
	 */
	
	public String getNom()
	{
		return nom;
	}
	
	/**
	 * Modifie le nom du client.
	 * @param nom le nom du client.
	 */
	
	public void setNom(String nom)
	{
		this.nom=nom;
	}
	
	/**
	 * Créé une facture.
	 * @param montant Le montant de la facture.
	 * @return la facture créée.
	 */
	
	public Facture createFacture(int montant)
	{
		Facture facture = new Facture(montant, this, LocalDate.now(), false);
		factures.add(facture);
		return facture;
	}
	
	/**
	 * Retourne une copie de la liste des factures du client. 
	 * @return une copie de la liste des factures du client.
	 */

	public List<Facture> getFactures()
	{
		return factures;
	}
	
	/**
	 * Retourne la somme des montants des factures.
	 * @return la somme des montants des factures.
	 */
	
	public int sommeMontants()
	{
		int somme = 0;
		for(int i =0 ; i<factures.size() ; i++) {
			somme += factures.get(i).getMontant();
		}
		return somme;
	}

	/**
	 * Créé une facture en précisant si elle est reglée.
	 * @param montant Le montant de la facture.
	 * @param reglée Vrai si la facture est reglée.
	 * @return la facture créée.
	 */
	
	public Facture createFacture(int montant, boolean reglee)
	{
		Facture facture = new Facture(montant, this, LocalDate.now(), reglee);
		factures.add(facture);
		return facture;
	}	
	
	/**
	 * Retourne la liste des factures reglées. 
	 * @return la liste des factures reglées.
	 */
	
	public List<Facture> facturesReglees()
	{
		ArrayList <Facture> facturesreglees = new ArrayList<>();
		for(Facture factu : factures) {
			if (factu.estReglee() == true) {
				facturesreglees.add(factu); 
			}
		}
		return facturesreglees;
			
	}
	

	/**
	 * Retourne tous les clients créés.
	 * @return une copie de la liste de tous les clients.
	 */
	public static List<Client> tous()
	{
		return clients;
	}
	
	/**
	 * Supprime le client.
	 */
	
	public void delete()
	{
		clients.remove(this);
	}
}
