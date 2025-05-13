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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("=> LoginServlet lance");
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		String hashedPassword = PasswordUtil.hashPassword(password);
		
		Utilisateur utilisateur = UtilisateurDao.getByEmail(email);
		
		if(utilisateur != null && utilisateur.getMotDePasse().equals(hashedPassword)) {
			
			HttpSession session = request.getSession();
			session.setAttribute("id", utilisateur.getId());
			session.setAttribute("prenom", utilisateur.getPrenom());
			session.setAttribute("nom", utilisateur.getNom());
			session.setAttribute("email", utilisateur.getEmail());
			session.setAttribute("role", utilisateur.getRole());
			
			// Redirection selon le rôle
						if ("admin".equals(utilisateur.getRole())) {
							response.sendRedirect("dashboard_admin.jsp");
						} else {
							response.sendRedirect("dashboard_etudiant.jsp");
						}
					} else {
						// Erreur de connexion
						request.setAttribute("error", "Email ou mot de passe incorrect.");
						request.getRequestDispatcher("sighup.jsp").forward(request, response);
					}
		
	}

}
