package Controller;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import org.w3c.dom.ls.LSOutput;

import dao.IDaoLocal;
import entities.Filiere;
import entities.Student;

/**
 * Servlet implementation class StudentController
 */
@WebServlet(name="/StudentController")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB(beanName = "StudentService")
	private IDaoLocal<Student> studentDao;
	@EJB(beanName = "FiliereService")
	private IDaoLocal<Filiere> filiereDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<Student> students = studentDao.findAll();
		request.setAttribute("students", students);
		request.setAttribute("emptyStud", new Student("","","","",""));
		request.setAttribute("buttonMode", "add");
		request.setAttribute("filieres", filiereDao.findAll());
		request.getRequestDispatcher("/Student.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String getAction = request.getParameter("action");
			if(getAction.equals("add")) {
				String firstName = request.getParameter("firstName");
		        String lastName = request.getParameter("lastName");
		        String email = request.getParameter("email");
		        String telephone = request.getParameter("telephone");
		        String password = request.getParameter("password");
		        Filiere filiere = filiereDao.findById(Integer.parseInt(request.getParameter("filiere")));
		        studentDao.create(new Student(email,password,firstName, lastName, telephone,filiere));
			}else if (getAction.equals("delete")) {
				doDelete(request, response);
			}else if(getAction.equals("update")) {
				Student st = studentDao.findById(Integer.parseInt(request.getParameter("studentidupt")));
				request.setAttribute("emptyStud", st);
				request.setAttribute("buttonMode", "Save");
				List<Student> students = studentDao.findAll();
				request.setAttribute("filieres", filiereDao.findAll());
				request.setAttribute("students", students);
				
				request.getRequestDispatcher("/Student.jsp").forward(request, response);
			}else {
				doPut(request, response);
			}
	        // Redirect to a success page or perform any other actions
	        doGet(request, response);
	}
	 protected void doDelete(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        // Extract the user ID from the request parameter
	        String userIdParam = request.getParameter("studentid");
	        // Check if the parameter is not null and is a valid integer
	        if (userIdParam != null) {
	            int userId = Integer.parseInt(userIdParam);    
	            Student studentdeleted = studentDao.findById(userId);
	            studentDao.delete(studentdeleted);
	        }
	        doGet(request, response);
	    }
	 @Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int Student_id = Integer.parseInt(request.getParameter("updatestudentid"));
		String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String telephone = request.getParameter("telephone");
        String password = request.getParameter("password");
        Filiere filiere = filiereDao.findById(Integer.parseInt(request.getParameter("filiere")));
        Student updatedStudent = new Student(email,password,firstName,lastName,telephone,filiere);
        
        updatedStudent.setId(Student_id);
        if(updatedStudent != null) {
        	studentDao.update(updatedStudent);
        }
	}
}
