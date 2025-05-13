<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Note" %>
<%@ page import="dao.NoteDao" %>
<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="UTF-8">
  <title>Dashboard Étudiant</title>
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

  <div class="main-box p-6 rounded-xl shadow-lg w-full max-w-3xl mb-8">
    <h1 class="text-3xl font-bold text-gray-800 mb-4 text-center">
      👋 Bienvenue, <%= session.getAttribute("prenom") %> !
    </h1>

    <div class="mb-6 text-gray-700 text-center">
      <p><strong>Nom :</strong> <%= session.getAttribute("nom") %></p>
      <p><strong>Email :</strong> <%= session.getAttribute("email") %></p>
    </div>

    <h2 class="text-xl font-semibold text-gray-800 mb-2">📚 Vos notes</h2>
    <div class="overflow-x-auto">
      <table class="min-w-full bg-white rounded-lg overflow-hidden">
        <thead class="bg-[#C7DB9C] text-gray-900">
          <tr>
            <th class="py-3 px-4 text-left">Matière</th>
            <th class="py-3 px-4 text-left">Note</th>
            <th class="py-3 px-4 text-left">Date</th>
          </tr>
        </thead>
        <tbody class="text-gray-700">
          <%
            int etudiantId = (Integer) session.getAttribute("id");
            List<Note> notes = NoteDao.getNotesParEtudiant(etudiantId);
            if (notes != null && !notes.isEmpty()) {
              for (Note note : notes) {
          %>
          <tr class="border-t hover:bg-gray-100">
            <td class="py-2 px-4"><%= note.getMatiere() %></td>
            <td class="py-2 px-4"><%= note.getValeur() %></td>
            <td class="py-2 px-4"><%= note.getDateNote() %></td>
          </tr>
          <%
              }
            } else {
          %>
          <tr>
            <td colspan="3" class="text-center py-4 text-red-600">
              Aucune note trouvée.
            </td>
          </tr>
          <% } %>
        </tbody>
      </table>
    </div>
  </div>

  <a href="LogoutServlet"
     class="bg-red-100 text-red-700 px-6 py-2 rounded-full hover:bg-red-200 transition font-medium">
    🚪 Se déconnecter
  </a>

</body>
</html>
