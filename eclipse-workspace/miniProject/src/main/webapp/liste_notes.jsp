<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Note" %>
<%@ page import="dao.NoteDao" %>
<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="UTF-8">
  <title>Liste des notes</title>
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
<body class="min-h-screen flex flex-col items-center justify-start py-8">

  <div class="main-box p-6 rounded-xl shadow-lg w-full max-w-5xl mb-8">
    <h1 class="text-3xl font-bold text-gray-800 mb-4 text-center">📚 Liste des notes</h1>

    <div class="overflow-x-auto">
      <table class="min-w-full bg-white rounded-lg overflow-hidden">
        <thead class="bg-[#C7DB9C] text-gray-900">
          <tr>
            <th class="py-3 px-4 text-left">Étudiant</th>
            <th class="py-3 px-4 text-left">Matière</th>
            <th class="py-3 px-4 text-left">Note</th>
            <th class="py-3 px-4 text-left">Date</th>
          </tr>
        </thead>
        <tbody class="text-gray-700">
          <%
            List<Note> notes = NoteDao.getAllNotesWithEtudiants();
            if (notes != null && !notes.isEmpty()) {
              for (Note n : notes) {
          %>
          <tr class="border-t hover:bg-gray-100">
            <td class="py-2 px-4"><%= n.getNomEtudiant() %></td>
            <td class="py-2 px-4"><%= n.getMatiere() %></td>
            <td class="py-2 px-4"><%= n.getValeur() %></td>
            <td class="py-2 px-4"><%= n.getDateNote() %></td>
          </tr>
          <%
              }
            } else {
          %>
          <tr>
            <td colspan="4" class="text-center py-4 text-red-600">
              Aucune note trouvée.
            </td>
          </tr>
          <% } %>
        </tbody>
      </table>
    </div>
  </div>

  <a href="dashboard_admin.jsp"
     class="bg-gray-200 text-gray-800 font-medium py-2 px-6 rounded hover:bg-gray-300 transition">
    ⬅️ Retour au tableau de bord
  </a>

</body>
</html>
