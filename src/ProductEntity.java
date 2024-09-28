package shopping;

public class ProductEntity implements java.io.Serializable{


	private int pno;
	private int price;
	private int stock;

	public int  getPno(){
	
	return pno;

	} 

	public void setPno(int pn){

	pno = pn;
	}

	public int getPrice(){
	return price;

	}

	public void setPrice(int p){

	price = p;
	}


	public int getStock(){
	return stock;
	}

	public void setStock(int s){
	
	stock = s;
	}
}
