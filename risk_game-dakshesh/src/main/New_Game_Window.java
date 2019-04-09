/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Strategies.Strategy;
import Strategies.Aggresive;
import Strategies.Benevolent;
import Strategies.Cheating;
import Strategies.Human;
import Strategies.Random;
import game_engine.Game.GameObjectsWrapper;
import game_engine.Game.LoadGame;
import models.GameMap;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;
import models.GameMap;
import map.mapeditor.NewMap;
import map.mapeditor.EditMap;
import map.mapprocessor.InvalidMapException;
import map.mapprocessor.MapParser;
import map.mapprocessor.MapValidator;
import game_engine.GameDriver;
import java.io.IOException;
import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 * This is the main class of the game from where the game starts
 *
 * @author daksh
 */
public class New_Game_Window extends javax.swing.JFrame {

    /**
     * Creates new form Risk_Game_Main_Window
     */
    String mapPath;
    /**
     * Number of players in the game
     */
    int noOfPlayer;
    /**
     * Object of the GameMap {@link models.GameMap}
     */
    GameMap map;

    /**
     * Initializes the components
     */
    public New_Game_Window() {
        initComponents();
        makeInvisible();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        noOfPlayers = new javax.swing.JSpinner();
        browseMap = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        startGame = new javax.swing.JButton();
        mPath = new javax.swing.JTextField();
        map_edit = new javax.swing.JButton();
        new_map = new javax.swing.JButton();
        jl0 = new javax.swing.JLabel();
        jl1 = new javax.swing.JLabel();
        jl2 = new javax.swing.JLabel();
        jl3 = new javax.swing.JLabel();
        jl4 = new javax.swing.JLabel();
        jl5 = new javax.swing.JLabel();
        p0 = new javax.swing.JComboBox();
        p1 = new javax.swing.JComboBox();
        p5 = new javax.swing.JComboBox();
        p4 = new javax.swing.JComboBox();
        p3 = new javax.swing.JComboBox();
        p2 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("No of players :");

        noOfPlayers.setModel(new javax.swing.SpinnerNumberModel(3, 2, 6, 1));
        noOfPlayers.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                noOfPlayersStateChanged(evt);
            }
        });

        browseMap.setText("Browse");
        browseMap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseMapActionPerformed(evt);
            }
        });

        jLabel2.setText("Map :");

        startGame.setText("Start Game");
        startGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startGameActionPerformed(evt);
            }
        });

        mPath.setText("");

        map_edit.setText("Map Edit");
        map_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                map_editActionPerformed(evt);
            }
        });

        new_map.setText("New Map");
        new_map.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new_mapActionPerformed(evt);
            }
        });

        jl0.setText("Player 0 :");

        jl1.setText("Player 1 :");

        jl2.setText("Player 2 :");

        jl3.setText("Player 3 :");

        jl4.setText("Player 4 :");

        jl5.setText("Player 5 :");

        p0.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Human", "Aggresive", "Benevolent", "Cheating" ,"Random" }));

        p1.setModel(new javax.swing.DefaultComboBoxModel(new String[] {  "Human", "Aggresive", "Benevolent", "Cheating" ,"Random" }));

        p5.setModel(new javax.swing.DefaultComboBoxModel(new String[] {  "Human", "Aggresive", "Benevolent", "Cheating" ,"Random" }));

        p4.setModel(new javax.swing.DefaultComboBoxModel(new String[] {  "Human", "Aggresive", "Benevolent", "Cheating" ,"Random" }));

        p3.setModel(new javax.swing.DefaultComboBoxModel(new String[] {  "Human", "Aggresive", "Benevolent", "Cheating" ,"Random" }));

        p2.setModel(new javax.swing.DefaultComboBoxModel(new String[] {  "Human", "Aggresive", "Benevolent", "Cheating" ,"Random" }));
        p2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mPath, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(browseMap)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(noOfPlayers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jl2)
                                    .addComponent(jl1)
                                    .addComponent(jl0))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(p2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(p0, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(p1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(startGame)
                                .addGap(30, 30, 30)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jl4)
                                .addGap(26, 26, 26)
                                .addComponent(p4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jl3)
                                    .addGap(26, 26, 26)
                                    .addComponent(p3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jl5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(p5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(new_map)))
                        .addGap(132, 132, 132))))
            .addGroup(layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(map_edit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(noOfPlayers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(browseMap)
                    .addComponent(mPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl3)
                    .addComponent(p0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl0))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(p4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jl1)
                        .addComponent(p1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jl4)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl2)
                    .addComponent(jl5)
                    .addComponent(p5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(map_edit)
                    .addComponent(new_map)
                    .addComponent(startGame))
                .addGap(79, 79, 79))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * browses the path of map for loading and if path is valid store that as
     * <code>New_Game_Window.mapPath</code>
     *
     * @param evt when browse button is clicked
     */
    private void browseMapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseMapActionPerformed
        // TODO add your handling code here:
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        int returnValue = jfc.showOpenDialog(null);
        // int returnValue = jfc.showSaveDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            String mapPath = selectedFile.getAbsolutePath();
            mPath.setText(mapPath);
            System.out.println(mapPath);
            this.mapPath = mapPath;
        }

    }//GEN-LAST:event_browseMapActionPerformed
    /**
     * gets the number of players and sends that with a valid map to
     * <code>game_driver_main</code> and
     *
     * @param evt when start button is clicked
     */
    private void startGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startGameActionPerformed
        // TODO add your handling code here:
        String mapPath = mPath.getText().toString();
        if (checkMapPath(mapPath)) {
            try {
                map = MapParser.parseMap(mapPath);
            } catch (InvalidMapException ex) {
                System.out.println(ex.getMessage());
                System.out.println("Invalid Map");
            }
            this.dispose();
            int nop = (Integer) noOfPlayers.getValue();
            Strategy s[] = getStrategies(nop);
            int gameMode = 1;
            GameDriver gd = new GameDriver(map, nop, s, gameMode, -1);
            gd.startGame();
//            GameDriver gd1 = new GameDriver(map, nop);
//            gd1.startGame();
        }
    }//GEN-LAST:event_startGameActionPerformed
    /**
     * creates an object of EditMap and fill that using LoadMapFile
     *
     * @param evt when Map edit button is clicked
     */
    private void map_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_map_editActionPerformed
        // TODO add your handling code here:
        String mapPath = mPath.getText().toString();
        if (checkMapPath(mapPath)) {
            EditMap me = new EditMap();
            try {
                me.loadMapFile(mapPath);
            } catch (InvalidMapException ex) {
                System.out.println("Invalid Map File: Exception");
                Logger.getLogger(New_Game_Window.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_map_editActionPerformed
    /**
     * creates new map
     *
     * @param evt When new map button is clicked
     */
    private void new_mapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_new_mapActionPerformed
        // TODO add your handling code here:
        NewMap mc = new NewMap();
        mc.createMap();
    }//GEN-LAST:event_new_mapActionPerformed

    private void p2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_p2ActionPerformed

    private void noOfPlayersStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_noOfPlayersStateChanged
        // TODO add your handling code here:
        int n = (Integer) noOfPlayers.getValue();
        jl[0] = jl0;
        jl[1] = jl1;
        jl[2] = jl2;
        jl[3] = jl3;
        jl[4] = jl4;
        jl[5] = jl5;

        jcb[0] = p0;
        jcb[1] = p1;
        jcb[2] = p2;
        jcb[3] = p3;
        jcb[4] = p4;
        jcb[5] = p5;

        for (int i = 0; i < 6; i++) {
            jl[i].setVisible(false);
            jcb[i].setVisible(false);
        }

        for (int i = 0; i < n; i++) {
            jl[i].setVisible(true);
            jcb[i].setVisible(true);
        }

    }//GEN-LAST:event_noOfPlayersStateChanged
    /**
     * gets path for map and returns true if that path contains a valid map
     *
     * @param mapPath path of the map file in file storage
     * @return true if valid map otherwise false
     */
    boolean checkMapPath(String mapPath) {
        if (mapPath.length() == 0) {
            JOptionPane.showMessageDialog(null, "Please Select Map");
            return false;
        } else {

            String p[] = mapPath.split("\\\\");
            String fileName = p[p.length - 1];
            String e[] = fileName.split("\\.");
            if (e[1].equals("map")) {
                boolean reply;
                try {
                    GameMap m = MapParser.parseMap(mapPath);
                    reply = MapValidator.verifyMap(m);
                } catch (InvalidMapException ex) {
                    Logger.getLogger(New_Game_Window.class.getName()).log(Level.SEVERE, null, ex);
                    reply = false;
                }

                if (reply) {
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Map!");
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Not a file");
                return false;
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(New_Game_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(New_Game_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(New_Game_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(New_Game_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        new New_Game_Window().setVisible(true);

    }
    javax.swing.JLabel[] jl = new JLabel[6];

    javax.swing.JComboBox[] jcb = new JComboBox[6];
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browseMap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jl0;
    private javax.swing.JLabel jl1;
    private javax.swing.JLabel jl2;
    private javax.swing.JLabel jl3;
    private javax.swing.JLabel jl4;
    private javax.swing.JLabel jl5;
    private javax.swing.JTextField mPath;
    private javax.swing.JButton map_edit;
    private javax.swing.JButton new_map;
    private javax.swing.JSpinner noOfPlayers;
    private javax.swing.JComboBox p0;
    private javax.swing.JComboBox p1;
    private javax.swing.JComboBox p2;
    private javax.swing.JComboBox p3;
    private javax.swing.JComboBox p4;
    private javax.swing.JComboBox p5;
    private javax.swing.JButton startGame;
    // End of variables declaration//GEN-END:variables

    private void makeInvisible() {

        int n = (Integer) noOfPlayers.getValue();
        jl[0] = jl0;
        jl[1] = jl1;
        jl[2] = jl2;
        jl[3] = jl3;
        jl[4] = jl4;
        jl[5] = jl5;

        jcb[0] = p0;
        jcb[1] = p1;
        jcb[2] = p2;
        jcb[3] = p3;
        jcb[4] = p4;
        jcb[5] = p5;

        for (int i = n; i < 6; i++) {
            jl[i].setVisible(false);
            jcb[i].setVisible(false);
        }

    }

    private Strategy[] getStrategies(int nop) {
        Strategy[] s = new Strategy[nop];
        jl[0] = jl0;
        jl[1] = jl1;
        jl[2] = jl2;
        jl[3] = jl3;
        jl[4] = jl4;
        jl[5] = jl5;

        jcb[0] = p0;
        jcb[1] = p1;
        jcb[2] = p2;
        jcb[3] = p3;
        jcb[4] = p4;
        jcb[5] = p5;
        for (int i = 0; i < nop; i++) {
            String temp = (String) jcb[i].getSelectedItem();
            if (temp.equalsIgnoreCase("Human")) {
                Strategy tempStrategy = new Human();
                s[i] = tempStrategy;
            }
            if (temp.equalsIgnoreCase("Aggresive")) {
                Strategy tempStrategy = new Aggresive();
                s[i] = tempStrategy;

            }
            if (temp.equalsIgnoreCase("Benevolent")) {
                Strategy tempStrategy = new Benevolent();
                s[i] = tempStrategy;

            }
            if (temp.equalsIgnoreCase("Cheating")) {
                Strategy tempStrategy = new Cheating();
                s[i] = tempStrategy;

            }
            if (temp.equalsIgnoreCase("Random")) {
                Strategy tempStrategy = new Random();
                s[i] = tempStrategy;
            }
        }
        return s;
    }
}