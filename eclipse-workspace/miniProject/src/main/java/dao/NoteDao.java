package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Note;
import util.DBConnection;

public class NoteDao {

    public static boolean ajouterNote(Note note) {
        boolean success = false;

        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO note (etudiant_id, matiere, valeur, date_note) VALUES (?, ?, ?, CURRENT_DATE)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, note.getEtudiantId());
            ps.setString(2, note.getMatiere());
            ps.setDouble(3, note.getValeur());

            int rows = ps.executeUpdate();
            success = rows > 0;

            ps.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("❌ Erreur ajout note : " + e.getMessage());
            e.printStackTrace();
        }

        return success;
    }
    
    public static List<Note> getAllNotesWithEtudiants() {
        List<Note> notes = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT n.*, u.prenom, u.nom FROM note n JOIN utilisateur u ON n.etudiant_id = u.id";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Note note = new Note();
                note.setEtudiantId(rs.getInt("etudiant_id"));
                note.setMatiere(rs.getString("matiere"));
                note.setValeur(rs.getDouble("valeur"));
                note.setDateNote(rs.getDate("date_note"));
                note.setNomEtudiant(rs.getString("prenom") + " " + rs.getString("nom"));
                notes.add(note);
            }

            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("❌ Erreur récupération notes : " + e.getMessage());
            e.printStackTrace();
        }

        return notes;
    }
    
    public static List<Note> getNotesParEtudiant(int etudiantId) {
        List<Note> notes = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM note WHERE etudiant_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, etudiantId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Note note = new Note();
                note.setEtudiantId(etudiantId);
                note.setMatiere(rs.getString("matiere"));
                note.setValeur(rs.getDouble("valeur"));
                note.setDateNote(rs.getDate("date_note"));
                notes.add(note);
            }

            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return notes;
    }


}
