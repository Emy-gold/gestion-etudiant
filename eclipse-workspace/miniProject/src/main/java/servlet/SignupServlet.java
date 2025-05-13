package servlet;

import dao.UtilisateurDao;
import model.Utilisateur;
import util.PasswordUtil;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("==> SignupServlet lancé");

		
		String prenom = request.getParameter("firstname");
		String nom = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("ConfirmPassword");
		String role = request.getParameter("role");
		
		if (!password.equals(confirmPassword)) {
			request.setAttribute("error","les mots de passe ne correspondest pas.");
			request.getRequestDispatcher("signup.jsp").forward(request, response);
			return;
		}
		
		String motDePasseHashe = PasswordUtil.hashPassword(password);
		
		Utilisateur utilisateur = new Utilisateur(prenom, nom, email, motDePasseHashe, role);
		
		boolean success = UtilisateurDao.Inserer(utilisateur);
		
		if (success) {
			 if ("admin".equals(utilisateur.getRole())) {
	                response.sendRedirect("dashboard_admin.jsp");
	            } else {
	                response.sendRedirect("dashboard_etudiant.jsp");
	            }
		}
		else {
			request.setAttribute("error","Echec de l'inscription. Essayer une autre fois");
			request.getRequestDispatcher("signup.jsp").forward(request, response);
		}

	}
	
}
