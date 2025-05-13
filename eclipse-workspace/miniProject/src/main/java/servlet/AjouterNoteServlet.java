package servlet;

import dao.NoteDao;
import model.Note;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/AjouterNoteServlet")
public class AjouterNoteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AjouterNoteServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int etudiantId = Integer.parseInt(request.getParameter("etudiantId"));
            String matiere = request.getParameter("matiere");
            double valeur = Double.parseDouble(request.getParameter("valeur"));

            Note note = new Note(etudiantId, matiere, valeur);

            boolean success = NoteDao.ajouterNote(note);

            if (success) {
                // Redirection vers la liste des notes ou le dashboard
                response.sendRedirect("liste_notes.jsp");
            } else {
                request.setAttribute("error", "Erreur lors de l'ajout de la note.");
                request.getRequestDispatcher("ajouter_note.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Données invalides.");
            request.getRequestDispatcher("ajouter_note.jsp").forward(request, response);
        }
    }
}
