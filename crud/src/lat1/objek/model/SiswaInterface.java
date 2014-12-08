/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lat1.objek.model;

import java.sql.SQLException;
import java.util.List;
import lat1.objek.entity.Siswa;

/**
 *
 * @author acusgazerock
 */
public interface SiswaInterface {
        public void connect() throws SQLException;   //inget di beri throws SQLException
    public void disconnect() throws SQLException;
    public List  read() throws SQLException;
    public void insert(Siswa siswa) throws  SQLException;
    public void update(String nis, Siswa siswa) throws SQLException;
    public void delete(String nis) throws SQLException;
    public Siswa read(String nis) throws  SQLException;
}
