package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Utilisateur;
import util.DBConnection;

public class UtilisateurDao {
    public static boolean Inserer(Utilisateur u) {
        boolean status = false;
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "INSERT INTO utilisateur(prenom, nom, email, mot_de_passe, role) VALUES(?,?,?,?,?)")) {

            ps.setString(1, u.getPrenom());
            ps.setString(2, u.getNom());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getMotDePasse());
            ps.setString(5, u.getRole());

            int rows = ps.executeUpdate();
            status = rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public static Utilisateur getByEmail(String email) {
        Utilisateur utilisateur = null;
        String sql = "SELECT * FROM utilisateur WHERE email = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    utilisateur = new Utilisateur();
                    utilisateur.setId(rs.getInt("id"));
                    utilisateur.setPrenom(rs.getString("prenom"));
                    utilisateur.setNom(rs.getString("nom"));
                    utilisateur.setEmail(rs.getString("email"));
                    utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
                    utilisateur.setRole(rs.getString("role"));
                }
            }
        } catch (SQLException e) {
            System.out.println("❌ Erreur lors de la récupération par email : " + e.getMessage());
            e.printStackTrace();
        }
        return utilisateur;
    }

    public static boolean ajouterEtudiant(Utilisateur u) {
        boolean success = false;
        String sql = "INSERT INTO utilisateur (prenom, nom, email, mot_de_passe, role) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, u.getPrenom());
            ps.setString(2, u.getNom());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getMotDePasse());
            ps.setString(5, "student"); // Rôle imposé pour un étudiant

            int rows = ps.executeUpdate();
            success = rows > 0;
        } catch (SQLException e) {
            System.out.println("❌ Erreur ajout étudiant : " + e.getMessage());
            e.printStackTrace();
        }
        return success;
    }

    /**
     * Récupère tous les utilisateurs dont le rôle est 'student'.
     *
     * @return liste des étudiants
     */
    public static List<Utilisateur> getAllEtudiants() {
        List<Utilisateur> etudiants = new ArrayList<>();
        String sql = "SELECT id, prenom, nom, email FROM utilisateur WHERE role = 'student'";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Utilisateur u = new Utilisateur();
                u.setId(rs.getInt("id"));
                u.setPrenom(rs.getString("prenom"));
                u.setNom(rs.getString("nom"));
                u.setEmail(rs.getString("email"));
                u.setRole("student");
                etudiants.add(u);
            }
        } catch (SQLException e) {
            System.out.println("❌ Erreur récupération liste étudiants : " + e.getMessage());
            e.printStackTrace();
        }
        return etudiants;
    }
}

