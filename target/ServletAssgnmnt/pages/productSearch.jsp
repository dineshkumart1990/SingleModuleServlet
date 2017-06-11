<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/product.do" method="get">
		Product Id: &nbsp; <input type="text" name="productId"> <br>
		<input type="submit" value="Submit">
		
		${requestScope.product.productId}
		${requestScope.product.name}
		${requestScope.product.price}
		
	</form>
</body>
</html>