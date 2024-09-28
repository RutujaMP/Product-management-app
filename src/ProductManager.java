package shopping;


public interface ProductManager extends java.rmi.Remote {
	
	int insertProduct(int price ,int stock) throws java.rmi.RemoteException;
	java.util.List<ProductEntity> getProductsDetails() throws  java.rmi.RemoteException;
	
	int  deleteProductsDetails(int pno) throws  java.rmi.RemoteException;

	int  updateProductsDetails(int pno,int price,int stock) throws  java.rmi.RemoteException;
}
