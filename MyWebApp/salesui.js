async function doGetProducts(){
	let response = await fetch("api/products/");
	if(response.ok)
		return await response.json();
	if(response.status == 404)
		return "No orders found for this customer";
	return "Internal Server Error";
}

async function doPostOrder( price, stock) {
	const request = {
		method: 'post',
		headers: {'Content-Type': 'application/json'},
		body: JSON.stringify({
		
			productNo: new Number(price),
			quantity: new Number(stock)
		})
	};
	let response = await fetch("api/products/", request);
	if(response.ok) {
		let result = await response.json();
		return "New order number is " + result.pno;
	}
	return "Order Failed";

}

