package modern.web.app;

import shopping.*;
import java.rmi.*;
import java.util.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/products")
public class ProductManagerAPI {

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Response readOrders() {
		try{
			ProductManager stub = (ProductManager)Naming.lookup("rmi://localhost:8000/ProductManager");
			List<ProductEntity> products = stub.getProductsDetails();
			if(products.size() == 0)
				return Response.status(404).build();
			// return Response.status(200).entity(products).build();
				return Response.status(200)
      				.header("Access-Control-Allow-Origin", "*")
          				.header("Access-Control-Allow-Methods", 
        				"GET, POST, PUT, DELETE, OPTIONS, HEAD")      
				.entity(products).build();

		}catch(Exception e){
			return Response.status(500).build();
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createOrder(ProductEntity info) {
		try{
			ProductManager stub = (ProductManager)Naming.lookup("rmi://localhost:8000/ProductManager");
			System.out.println(info);
			int productNo = stub.insertProduct(info.getPrice(), info.getStock());
			info.setPno(productNo);
			
			//return Response.ok(info).build();
				return Response.status(200)
      				.header("Access-Control-Allow-Origin", "*")
          				.header("Access-Control-Allow-Methods", 
        				"GET, POST, PUT, DELETE, OPTIONS, HEAD")      
				.entity(info).build();
		}catch(Exception e){
			return Response.status(500).build();
		}
	}

	
	@DELETE
	@Path("/delete/{id}")
	//@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteproduct(@PathParam("id") int pn) {
		try{
			ProductManager stub = (ProductManager)Naming.lookup("rmi://localhost:8000/ProductManager");
		
			int productNo = stub.deleteProductsDetails(pn);
			//pn.setPno(productNo);
			
			 
			//return Response.status(200).entity(pn).build();
				return Response.status(200)
      				.header("Access-Control-Allow-Origin", "*")
          				.header("Access-Control-Allow-Methods", 
        				"GET, POST, PUT, DELETE, OPTIONS, HEAD")      
				.entity(pn).build();
		}catch(Exception e){
			return Response.status(500).build();
		}
	}


	@PUT
	@Path("/put")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteproduct(ProductEntity obj) {
		try{
			ProductManager stub = (ProductManager)Naming.lookup("rmi://localhost:8000/ProductManager");
		
			int productNo = stub.updateProductsDetails(obj.getPno(),obj.getPrice(),obj.getStock());
			obj.setPno(productNo);
			
			 
			//return Response.status(200).entity(pn).build();
				return Response.status(200)
      				.header("Access-Control-Allow-Origin", "*")
          				.header("Access-Control-Allow-Methods", 
        				"GET, POST, PUT, DELETE, OPTIONS, HEAD")      
				.entity(productNo).build();
		}catch(Exception e){
			return Response.status(500).build();
		}
	}





}

