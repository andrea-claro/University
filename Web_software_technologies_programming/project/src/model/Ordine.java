package model;

/**
 * @author Andrea Claro
 *
 */
public class Ordine {
	private int id;
    private int idproduct;
    private int quantity;
    private long price;
    private Prodotto product;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdproduct() {
		return idproduct;
	}
	public void setIdproduct(int idproduct) {
		this.idproduct = idproduct;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public Prodotto getProduct() {
		return product;
	}
	public void setProduct(Prodotto product) {
		this.product = product;
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + idproduct;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + quantity;
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ordine other = (Ordine) obj;
		if (id != other.id)
			return false;
		if (idproduct != other.idproduct)
			return false;
		if (price != other.price)
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}

	public String toString() {
		return "Ordine [id=" + id + ", idproduct=" + idproduct + ", quantity=" + quantity + ", price=" + price + ", product=" + product + "]";
	}
    
    
}
