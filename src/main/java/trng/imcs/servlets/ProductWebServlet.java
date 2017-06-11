package trng.imcs.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trng.imcs.model.Product;
import trng.imcs.service.ProductService;
import trng.imcs.service.ProductServiceImpl;

/**
 * Servlet implementation class ProductWebServlet
 */
public class ProductWebServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private ProductService productService;
	
	private StringBuilder productIdHolder;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductWebServlet() {
        super();
        productService = new ProductServiceImpl();
        productIdHolder = new StringBuilder();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String productId = request.getParameter("productId");
//		Product product = productService.getProduct(productId);		
//		response.setContentType("text/html");
//		productIdHolder.append(productId);
//		response.getWriter()
//			.append("<html> <body>")
//			.append("Product Id: " + product.getProductId())
//			.append("Product Name: " + product.getName())
//			.append("Price: " + product.getPrice())
//			.append("</body></html>");
		
		request.setAttribute("product", new Product("101", "Computer", 1000));
		
		RequestDispatcher homeDisp = request.getRequestDispatcher("pages/productSearch.jsp");
		homeDisp.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String productId = request.getParameter("productId");
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		request.setAttribute("message", "Successfully Added");
		RequestDispatcher homeDisp = request.getRequestDispatcher("pages/addProduct.jsp");
		homeDisp.forward(request, response);
	}
}
