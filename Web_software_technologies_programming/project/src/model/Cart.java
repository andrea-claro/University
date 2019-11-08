package model;

import java.util.Collection;
import java.util.LinkedHashMap;

/**
 * @author Andrea Claro
 *
 */
public class Cart {
	public static class ProdottoQuantita {
		private Prodotto prodotto;
		private int quantita;

		private ProdottoQuantita(Prodotto prodotto, int quantita) {
			this.prodotto = prodotto;
			this.quantita = quantita;
		}

		public int getQuantita() {
			return quantita;
		}

		public void setQuantita(int quantita) {
			this.quantita = quantita;
		}

		public Prodotto getProdotto() {
			return prodotto;
		}

		public long getPrice() {
			return quantita * prodotto.getPrice();
		}
	}

	private LinkedHashMap<Integer, ProdottoQuantita> prodotti = new LinkedHashMap<>();

	public Collection<ProdottoQuantita> getProdotti() {
		return prodotti.values();
	}

	public ProdottoQuantita get(int prodId) {
		return prodotti.get(prodId);
	}

	public void put(Prodotto prodotto, int quantita) {
		prodotti.put(prodotto.getId(), new ProdottoQuantita(prodotto, quantita));
	}

	public ProdottoQuantita remove(int prodId) {
		return prodotti.remove(prodId);
	}

	public long getPrice() {
		int price = 0;
		for(ProdottoQuantita pq: getProdotti()) {
			price+= pq.getPrice();
		}
		return price;
	}

	@Override
	public String toString() {
		return "Carrello [prodotti=" + prodotti + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((prodotti == null) ? 0 : prodotti.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		if (prodotti == null) {
			if (other.prodotti != null)
				return false;
		} else if (!prodotti.equals(other.prodotti))
			return false;
		return true;
	}

}
