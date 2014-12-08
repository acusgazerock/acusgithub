/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lat1;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import lat1.view.FormSiswa;

/**
 *
 * @author acusgazerock
 */
public class Main {

    /**
     * @param args the command line arguments
     */
        public static void main(String[] args) {
        try {
            // TODO code application logic here
            UIManager.setLookAndFeel(new NimbusLookAndFeel());//untuk merubah look and feel
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                FormSiswa fs=new FormSiswa();
                fs.setLocationRelativeTo(null);
                fs.setVisible(true);
            }
        });
    }

}
