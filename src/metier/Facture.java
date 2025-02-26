package metier;

import java.time.LocalDate;

public class Facture
{
	private int montant;
	private Client client;
	private LocalDate DateFacture;
	private boolean reglee;
	
	public Facture(int montant, Client client, LocalDate DateFacture, boolean reglee) throws Negatif 	
	{
			if (montant >0) {
				this.montant=montant;
			}
			else {
				throw new Negatif();
			}
			this.client = client;
			this.DateFacture = DateFacture;
			this.reglee = reglee;	
	}
	/**
	 * Retourne le client à qui est adressée la facture..
	 * @return le client.
	 */
	
	public Client getClient()
	{
		return client;
	}

	/**
	 * Retourne le montant de la facture.
	 * @return le montant de la facture.
	 */
	
	public int getMontant()
	{
		return montant;
	}

	/**
	 * Retourne vrai si la facture est reglée.
	 * @return vrai ssi la facture est reglée.
	 */
	
	public void setReglee(boolean reglee) {
		this.reglee = reglee;
	}
	
	public boolean estReglee()
	{
		return reglee;
	}

	/**
	 * Retourne la date de la facture.
	 * @return la date de la facture.
	 */
	
	public LocalDate getDate()
	{
		return DateFacture;
	}

	/**
	 * Supprime la facture
	 */
	
	public void delete()
	{
		client.supprimeFacture(this);
	}
	
	/**
	 * Duplique la facture.
	 * @return une copie de la facture.
	 */
	
	public Facture copie()
	{
		return client.createFacture(montant, reglee);
	}
}
class Negatif extends IllegalArgumentException
{
	@Override
	public String getMessage() {
		return "Le montant d'une facture ne peut pas être négatif.";
	}
}