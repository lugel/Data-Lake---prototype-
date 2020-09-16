/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datalake;

import java.awt.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wojtek
 */
public class Find extends javax.swing.JFrame {

     ArrayList<DanaPogodowa> records = new ArrayList<DanaPogodowa>();

    public Find() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        button2 = new java.awt.Button();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Find files");
        setResizable(false);

        jLabel1.setText("Data poczatkowa");

        jLabel2.setText("Data koncowa");

        jLabel3.setText("Szukany parametr");

        button2.setLabel("wyszukaj");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        jLabel5.setText("Lokalizacja");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Temperatura zmierzona dźwiękiem [°C]", "Ciśnienie atmosferyczne [mbar]", "Temperatura  [°C]", "Wilgotność [%]", "Wskazanie kompasu", "Prędkość U-V", "Prędkość wiatru [m/s]", "Kierunek wiatru", "Temperatura wewnątrz pomieszczenia" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField3)
                    .addComponent(jTextField2)
                    .addComponent(jTextField1)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        button2.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

//--- BUTTON1 --- ZAŁADUJ DANE KOD ----
//        BufferedReader reader;
        //        try {
            //          //  ArrayList records = new ArrayList<DanaPogodowa> ();
            //            reader = new BufferedReader(new FileReader("jezioroDanych//data08-2020.csv"));
            //            DateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
            //            String[] data = null;
            //            String line;
            //            reader.readLine();
            //            reader.readLine();
            //            while ((line = reader.readLine()) != null) {
                //                //  records.add(line);
                //                data = line.split(";");
                //
                //                DanaPogodowa pogoda = new DanaPogodowa();
                //                pogoda.data= format.parse(data[0]);
                //
                //                if(!data[2].isEmpty())
                //                pogoda.predkoscDzwieku = Double.parseDouble(data[2]);
                //                records.add(pogoda);
                //            }
            //            reader.close();
            //            //testy
            //            jTextField1.setText(String.valueOf(records.size()));
            //            DanaPogodowa pogoda = new DanaPogodowa();
            //            pogoda = (DanaPogodowa) records.get(1);
            //            jTextField2.setText( String.valueOf( pogoda.predkoscDzwieku));
            //
            //            String pattern = "dd-MM-yyyy";
            //
            //            DateFormat df = new SimpleDateFormat(pattern);
            //
            //            String todayAsString = df.format(pogoda.data);
            //
            //            jTextField3.setText( todayAsString);
            //
            //            records.clear();
            //        }
        //
        //        catch (FileNotFoundException ex) {
            //            Logger.getLogger(Find.class.getName()).log(Level.SEVERE, null, ex);
            //        } catch (IOException ex) {
            //            Logger.getLogger(Find.class.getName()).log(Level.SEVERE, null, ex);
            //        } catch (ParseException ex) {
            //            Logger.getLogger(Find.class.getName()).log(Level.SEVERE, null, ex);
            //        }  
    
    
    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
     
//        double sumaPomiaru=0;
//        int licznik=0;
//            String getDate = jTextField4.getText();
//            String fileName= "jezioroDanych//data"+getDate.substring(3)+".csv";
//         try {
//             załadujDane(fileName);
//         } catch (FileNotFoundException ex) {
//             Logger.getLogger(Find.class.getName()).log(Level.SEVERE, null, ex);
//         }
//	for(DanaPogodowa daneLoop : records)
//        {  
//            String pattern = "dd-MM-yyyy";
//
//            DateFormat df = new SimpleDateFormat(pattern);
//
//            String dataPomiaru = df.format( daneLoop.data);
//           
//            if(dataPomiaru.equals(getDate))
//            {
//                sumaPomiaru+=daneLoop.predkoscDzwieku;
//                licznik++;
//                
//            }
//        }
//        DecimalFormat twoDForm = new DecimalFormat("#.##");
//        jTextField5.setText( String.valueOf( twoDForm.format(sumaPomiaru/licznik)));
// 
// //po odczycie czyścimy listę 
// 
//    records.clear();
        // TODO add your handling code here:
    }//GEN-LAST:event_button2ActionPerformed

//     public  void załadujDane(String plik) throws FileNotFoundException {
//             BufferedReader reader;
//        try {
//          //  ArrayList records = new ArrayList<DanaPogodowa> ();
//            reader = new BufferedReader(new FileReader(plik));
//            DateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
//            String[] data = null;
//            String line;
//            reader.readLine();
//            reader.readLine();
//            while ((line = reader.readLine()) != null) {
//                //  records.add(line);
//                data = line.split(";");
//
//                DanaPogodowa pogoda = new DanaPogodowa();
//                pogoda.data= format.parse(data[0]);
//              
//                if(!data[2].isEmpty())
//                pogoda.predkoscDzwieku = Double.parseDouble(data[2]);
//                records.add(pogoda);
//            }
//            reader.close();
//            //testy
//            jTextField1.setText(String.valueOf(records.size()));
//            DanaPogodowa pogoda = new DanaPogodowa();
//            pogoda = (DanaPogodowa) records.get(1);
//            jTextField2.setText( String.valueOf( pogoda.predkoscDzwieku));
//              
//            String pattern = "MM-dd-yyyy";
//
//            DateFormat df = new SimpleDateFormat(pattern);
//
//            String todayAsString = df.format(pogoda.data);
//            
//            jTextField3.setText( todayAsString);
//                
//        }
//
//        catch (FileNotFoundException ex) {
//            Logger.getLogger(Find.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(Find.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ParseException ex) {
//            Logger.getLogger(Find.class.getName()).log(Level.SEVERE, null, ex);
//        }
//         
//     }
// 
     /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws FileNotFoundException {
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
                java.util.logging.Logger.getLogger(Find.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(Find.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(Find.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(Find.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new Find().setVisible(true);
                }
            });
    
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
