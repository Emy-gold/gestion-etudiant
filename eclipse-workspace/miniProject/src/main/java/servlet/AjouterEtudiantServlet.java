package servlet;

import dao.UtilisateurDao;
import model.Utilisateur;
import util.PasswordUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {
    "/AjouterEtudiantServlet",   // pour l’ajout (POST)
    "/ListeEtudiantsServlet"     // pour la liste (GET)
})
public class AjouterEtudiantServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AjouterEtudiantServlet() {
        super();
    }

    /**
     * doGet → lister les étudiants
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupère la liste des étudiants
        List<Utilisateur> etudiants = UtilisateurDao.getAllEtudiants();
        request.setAttribute("etudiants", etudiants);
        // Transfert à la JSP de liste
        request.getRequestDispatcher("liste_etudiants.jsp").forward(request, response);
    }

    /**
     * doPost → ajouter un étudiant
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupération des données du formulaire
        String prenom     = request.getParameter("prenom");
        String nom        = request.getParameter("nom");
        String email      = request.getParameter("email");
        String motDePasse = request.getParameter("password");
        String role       = "student";

        // Hachage du mot de passe
        String hashed = PasswordUtil.hashPassword(motDePasse);

        // Création de l'objet Utilisateur
        Utilisateur u = new Utilisateur();
        u.setPrenom(prenom);
        u.setNom(nom);
        u.setEmail(email);
        u.setMotDePasse(hashed);
        u.setRole(role);

        // Insertion en base
        boolean success = UtilisateurDao.ajouterEtudiant(u);

        if (success) {
            // Message de succès en session puis redirection vers le dashboard
            request.getSession().setAttribute("successMessage", "L'étudiant a été ajouté avec succès !");
            response.sendRedirect("dashboard_admin.jsp");
        } else {
            // Message d’erreur et retour au formulaire
            request.setAttribute("errorMessage", "Une erreur est survenue lors de l'ajout de l'étudiant.");
            request.getRequestDispatcher("ajouter_etudiant.jsp").forward(request, response);
        }
    }
}


