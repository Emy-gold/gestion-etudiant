<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="UTF-8">
  <title>Ajouter un étudiant</title>
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
    <h1 class="text-2xl font-bold text-gray-800 mb-6 text-center">➕ Ajouter un étudiant</h1>

    <form action="AjouterEtudiantServlet" method="post" class="space-y-4">

      <div>
        <label for="prenom" class="block text-sm font-medium text-gray-700">Prénom</label>
        <input type="text" id="prenom" name="prenom" required
               class="mt-1 w-full px-3 py-2 border rounded">
      </div>

      <div>
        <label for="nom" class="block text-sm font-medium text-gray-700">Nom</label>
        <input type="text" id="nom" name="nom" required
               class="mt-1 w-full px-3 py-2 border rounded">
      </div>

      <div>
        <label for="email" class="block text-sm font-medium text-gray-700">Email</label>
        <input type="email" id="email" name="email" required
               class="mt-1 w-full px-3 py-2 border rounded">
      </div>

      <div>
        <label for="password" class="block text-sm font-medium text-gray-700">Mot de passe</label>
        <input type="password" id="password" name="password" required
               class="mt-1 w-full px-3 py-2 border rounded">
      </div>

      <input type="hidden" name="role" value="student">

      <button type="submit"
              class="w-full bg-[#C7DB9C] text-gray-900 font-semibold py-2 rounded hover:bg-[#b8ce8e] transition">
        Enregistrer l'étudiant
      </button>
    </form>

    <div class="mt-6 text-center">
      <a href="dashboard_admin.jsp" class="text-blue-700 hover:underline">⬅️ Retour au dashboard</a>
    </div>
  </div>

</body>
</html>
