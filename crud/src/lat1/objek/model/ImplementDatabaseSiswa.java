/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lat1.objek.model;

import lat1.objek.entity.Siswa;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author acusgazerock
 */
public class ImplementDatabaseSiswa implements SiswaInterface {
    private String dbHost = "jdbc:mysql://localhost:3306/sis";
    private String dbUser = "root";
    private String dbPass = "";
    private Connection conn;

    public ImplementDatabaseSiswa() {
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (InstantiationException ex) {
                Logger.getLogger(ImplementDatabaseSiswa.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(ImplementDatabaseSiswa.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ImplementDatabaseSiswa.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ImplementDatabaseSiswa(Connection conn) {
        this.conn = conn;
    }

    public void connect() throws SQLException {
        this.conn = DriverManager.getConnection(dbHost, dbUser, dbPass);

    }

    public void disconnect() throws SQLException {
        this.conn.close();
    }

    public List read() throws SQLException {
        Statement st = conn.createStatement();
        String sql = "select *from siswa";
        ResultSet rs = st.executeQuery(sql);
        List list = new ArrayList();
        while (rs.next()) {
            Siswa newSiswa = new Siswa();
            newSiswa.setNis(rs.getString("nis"));
            newSiswa.setNama(rs.getString("nama"));
            newSiswa.setAlamat(rs.getString("alamat"));
            list.add(newSiswa);
        }
        return list;



    }

    public void insert(Siswa siswa) throws SQLException {
        String sql = "insert into siswa (nis, nama, alamat) values(?,?,?);";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, siswa.getNis());
        ps.setString(2, siswa.getNama());
        ps.setString(3, siswa.getAlamat());
        ps.executeUpdate();

    }

    public void update(String nis, Siswa siswa) throws SQLException {
        String sql = "update siswa set nis=?,nama=?,alamat=? where nis=?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, siswa.getNis());
        ps.setString(2, siswa.getNama());
        ps.setString(3, siswa.getAlamat());
        ps.setString(4, nis);
        ps.executeUpdate();

    }

    public void delete(String nis) throws SQLException {
        String sql = "delete from siswa where nis=?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, nis);
        ps.executeUpdate();

    }

    public Siswa read(String nis) throws SQLException {
        String sql = "select *from siswa where nis = ?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, nis);
        ResultSet rs = ps.executeQuery();
        Siswa siswa = new Siswa();
        while (rs.next()) {
            siswa.setNis(rs.getString("nis"));
            siswa.setNama(rs.getString("nama"));
            siswa.setAlamat(rs.getString("alamat"));
        }
        return siswa;

    }
}
