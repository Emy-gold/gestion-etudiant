<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Utilisateur" %>
<%@ page import="dao.UtilisateurDao" %>
<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="UTF-8">
  <title>Ajouter une note</title>
  <script src="https://cdn.tailwindcss.com"></script>
  <style>
    body {
      background: linear-gradient(to bottom, white, #C7DB9C);
    }
    .main-box {
      background-color: #f5f5f5;
    }
  </style>
</head>
<body class="min-h-screen flex items-center justify-center">

  <div class="main-box p-8 rounded-xl shadow-lg w-full max-w-md">
    <h1 class="text-2xl font-bold text-gray-800 mb-6 text-center">➕ Ajouter une note</h1>

    <form action="AjouterNoteServlet" method="post" class="space-y-4">

      <!-- Étudiant -->
      <div>
        <label for="etudiantId" class="block text-sm font-medium text-gray-700">Étudiant</label>
        <select name="etudiantId" id="etudiantId" required
                class="mt-1 w-full px-3 py-2 border rounded">
          <option value="">-- Sélectionnez un étudiant --</option>
          <%
            List<Utilisateur> etudiants = UtilisateurDao.getAllEtudiants();
            for (Utilisateur etu : etudiants) {
          %>
            <option value="<%= etu.getId() %>">
              <%= etu.getPrenom() %> <%= etu.getNom() %>
            </option>
          <% } %>
        </select>
      </div>

      <!-- Matière -->
      <div>
        <label for="matiere" class="block text-sm font-medium text-gray-700">Matière</label>
        <input type="text" id="matiere" name="matiere" required
               class="mt-1 w-full px-3 py-2 border rounded">
      </div>

      <!-- Note -->
      <div>
        <label for="valeur" class="block text-sm font-medium text-gray-700">Note</label>
        <input type="number" step="0.01" min="0" max="20" id="valeur" name="valeur" required
               class="mt-1 w-full px-3 py-2 border rounded">
      </div>

      <!-- Bouton -->
      <button type="submit"
              class="w-full bg-[#C7DB9C] text-gray-900 font-semibold py-2 rounded hover:bg-[#b8ce8e] transition">
        Enregistrer la note
      </button>
    </form>

    <!-- Lien retour -->
    <div class="mt-6 text-center">
      <a href="dashboard_admin.jsp" class="text-blue-700 hover:underline">⬅️ Retour au dashboard</a>
    </div>
  </div>

</body>
</html>

