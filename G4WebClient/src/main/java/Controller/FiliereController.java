package Controller;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import dao.IDaoLocal;
import entities.Filiere;
import entities.Student;

/**
 * Servlet implementation class FiliereController
 */
@WebServlet(name="/FiliereController")
public class FiliereController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB(beanName = "FiliereService")
	private IDaoLocal<Filiere> filiereDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FiliereController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Filiere> filieres = filiereDao.findAll();
		request.setAttribute("filieres", filieres);
		request.setAttribute("emptyFil", new Filiere("",""));
		request.setAttribute("buttonMode", "add");
		request.getRequestDispatcher("/Filiere.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String getAction = request.getParameter("action");
		if(getAction.equals("add")) {
			String name = request.getParameter("name");
	        String code = request.getParameter("code");
	        filiereDao.create(new Filiere(name,code));
		}else if (getAction.equals("delete")) {
			doDelete(request, response);
		}else if(getAction.equals("update")) {
			Filiere filiere = filiereDao.findById(Integer.parseInt(request.getParameter("filiereidupt")));
			request.setAttribute("emptyFil", filiere);
			request.setAttribute("buttonMode", "Save");
			List<Filiere> filieres = filiereDao.findAll();
			request.setAttribute("filieres", filieres);
			
			request.getRequestDispatcher("/Filiere.jsp").forward(request, response);
		}else {
			doPut(request, response);
		}
        // Redirect to a success page or perform any other actions
        doGet(request, response);
	}
	 protected void doDelete(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        // Extract the user ID from the request parameter
	        String userIdParam = request.getParameter("filiereid");
	        // Check if the parameter is not null and is a valid integer
	        if (userIdParam != null) {
	            int filiereId = Integer.parseInt(userIdParam);    
	            Filiere filiereDeleted = filiereDao.findById(filiereId);
	            filiereDao.delete(filiereDeleted);
	        }
	        doGet(request, response);
	    }
	 @Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int filiere_id = Integer.parseInt(request.getParameter("updatefiliereid"));
		 String name = request.getParameter("name");
	     String code = request.getParameter("code");
	     
	     Filiere updatedFiliere = new Filiere(name,code);
	     updatedFiliere.setId(filiere_id);
	     if(updatedFiliere != null) {
	     	filiereDao.update(updatedFiliere);
	     }
	}
}
