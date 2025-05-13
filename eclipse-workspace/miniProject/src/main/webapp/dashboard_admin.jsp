<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="UTF-8">
  <title>Dashboard Admin</title>
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
<body class="min-h-screen flex items-center justify-center flex-col">

  <div class="main-box p-8 rounded-xl shadow-lg w-full max-w-md text-center mb-16">
    <h1 class="text-2xl font-bold text-gray-800 mb-4">
      Bienvenue, <%= session.getAttribute("prenom") %> 👋
    </h1>
    <h2 class="text-lg text-gray-700 mb-6">Tableau de bord - Enseignant</h2>

    <div class="flex flex-col items-center gap-4">
      <a href="ajouter_etudiant.jsp"
         class="w-64 bg-[#C7DB9C] text-gray-900 font-medium py-2 rounded hover:bg-[#b8ce8e] transition duration-200 text-center">
        ➕ Ajouter un étudiant
      </a>
      <a href="liste_etudiants.jsp"
         class="w-64 bg-[#C7DB9C] text-gray-900 font-medium py-2 rounded hover:bg-[#b8ce8e] transition duration-200 text-center">
        📋 Liste des étudiants
      </a>
      <a href="ajouter_note.jsp"
         class="w-64 bg-[#C7DB9C] text-gray-900 font-medium py-2 rounded hover:bg-[#b8ce8e] transition duration-200 text-center">
        ➕ Ajouter une note
      </a>
      <a href="liste_notes.jsp"
         class="w-64 bg-[#C7DB9C] text-gray-900 font-medium py-2 rounded hover:bg-[#b8ce8e] transition duration-200 text-center">
        📚 Liste des notes
      </a>
    </div>

    <div class="mt-8 flex justify-center">
      <a href="LogoutServlet"
         class="inline-block px-6 py-2 rounded-full bg-red-100 text-red-700 font-medium hover:bg-red-200 transition">
        🚪 Se déconnecter
      </a>
    </div>
  </div>

  <!-- Display success message at the bottom -->
  <% if (session.getAttribute("successMessage") != null) { %>
    <div class="bg-green-100 text-green-800 p-4 mb-4 rounded w-full max-w-md text-center">
        <%= session.getAttribute("successMessage") %>
    </div>
    <% session.removeAttribute("successMessage"); %> <!-- Remove after showing once -->
  <% } %>

  <!-- Display error message at the bottom -->
  <% if (request.getAttribute("errorMessage") != null) { %>
    <div class="bg-red-100 text-red-800 p-4 mb-4 rounded w-full max-w-md text-center">
        <%= request.getAttribute("errorMessage") %>
    </div>
  <% } %>

</body>
</html>
