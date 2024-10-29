package voto;

import java.awt.event.KeyEvent;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class PantallaElectoral extends javax.swing.JFrame {

    static {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
    }

    public PantallaElectoral() {
        initComponents();
        panelDatosVotante.setVisible(false);
        jp_prep.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        campoDNI = new javax.swing.JTextField();
        btnAceptarDNI = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        panelDatosVotante = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtAM = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtAP = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        rbt_candidatoA = new javax.swing.JRadioButton();
        rbt_CandidatoB = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        rbt_Abstencion = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        jp_prep = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_results = new javax.swing.JTextArea();
        btn_recuento_de_votos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("DNI del elector:");

        campoDNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoDNIKeyPressed(evt);
            }
        });

        btnAceptarDNI.setText("Aceptar");
        btnAceptarDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarDNIActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelDatosVotante.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Nombre");

        jLabel4.setText("Apellido Materno");

        jLabel5.setText("Apellido Paterno");

        jLabel6.setText("Direccion");

        jLabel8.setText("jLabel7");

        buttonGroup1.add(rbt_candidatoA);
        rbt_candidatoA.setText("Andres Manuel Lopez Obrador");

        buttonGroup1.add(rbt_CandidatoB);
        rbt_CandidatoB.setText("Enrique Peña Nieto");

        jButton1.setText("Votar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Vota por Mexico, piensa en ti!");

        buttonGroup1.add(rbt_Abstencion);
        rbt_Abstencion.setSelected(true);
        rbt_Abstencion.setText("Abstencion");

        jLabel10.setText("jLabel7");

        javax.swing.GroupLayout panelDatosVotanteLayout = new javax.swing.GroupLayout(panelDatosVotante);
        panelDatosVotante.setLayout(panelDatosVotanteLayout);
        panelDatosVotanteLayout.setHorizontalGroup(
            panelDatosVotanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosVotanteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosVotanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosVotanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                    .addComponent(txtAM)
                    .addComponent(txtAP)
                    .addComponent(txtnombre))
                .addGap(18, 18, 18)
                .addGroup(panelDatosVotanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosVotanteLayout.createSequentialGroup()
                        .addGroup(panelDatosVotanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbt_CandidatoB, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbt_Abstencion))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelDatosVotanteLayout.createSequentialGroup()
                        .addGroup(panelDatosVotanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDatosVotanteLayout.createSequentialGroup()
                                .addGroup(panelDatosVotanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rbt_candidatoA)
                                    .addGroup(panelDatosVotanteLayout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addGroup(panelDatosVotanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(42, 42, 42)
                                .addGroup(panelDatosVotanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1)))
                            .addComponent(jLabel9))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelDatosVotanteLayout.setVerticalGroup(
            panelDatosVotanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosVotanteLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(panelDatosVotanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosVotanteLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosVotanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelDatosVotanteLayout.createSequentialGroup()
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(rbt_candidatoA)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelDatosVotanteLayout.createSequentialGroup()
                            .addGroup(panelDatosVotanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panelDatosVotanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(panelDatosVotanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(txtAP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(panelDatosVotanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6)))))
                .addComponent(rbt_CandidatoB)
                .addGap(18, 18, 18)
                .addComponent(rbt_Abstencion)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jp_prep.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        ta_results.setColumns(20);
        ta_results.setRows(5);
        jScrollPane1.setViewportView(ta_results);

        btn_recuento_de_votos.setText("PREP");
        btn_recuento_de_votos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_recuento_de_votosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp_prepLayout = new javax.swing.GroupLayout(jp_prep);
        jp_prep.setLayout(jp_prepLayout);
        jp_prepLayout.setHorizontalGroup(
            jp_prepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_prepLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_recuento_de_votos)
                .addContainerGap(172, Short.MAX_VALUE))
        );
        jp_prepLayout.setVerticalGroup(
            jp_prepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_prepLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jp_prepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_prepLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_prepLayout.createSequentialGroup()
                        .addComponent(btn_recuento_de_votos)
                        .addGap(51, 51, 51))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jp_prep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelDatosVotante, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAceptarDNI)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(campoDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAceptarDNI)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelDatosVotante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jp_prep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarDNIActionPerformed
        if (campoDNI.getText().length() == 8) {
            try {
                Registry register = LocateRegistry.getRegistry("localhost", 1099);
                ValidarCliente validarInterfaz = (ValidarCliente) register.lookup("validar_cliente");

                String datos[] = new String[4];
                datos = validarInterfaz.verificar_votante(Integer.parseInt(campoDNI.getText()));

                panelDatosVotante.setVisible(true);
                jp_prep.setVisible(true);
                txtnombre.setText(datos[0]);
                txtAP.setText(datos[1]);
                txtAM.setText(datos[2]);
                txtDireccion.setText(datos[3]);
                ta_results.setText("");
                if (txtnombre.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "Dni incorrecto");
                }
            } catch (RemoteException ex) {
                Logger.getLogger(PantallaElectoral.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(PantallaElectoral.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("DNI DE LONGITUD incorecta");
        }

    }//GEN-LAST:event_btnAceptarDNIActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            Registry register = LocateRegistry.getRegistry("localhost", 1099);
            ValidarCliente enviar_voto = (ValidarCliente) register.lookup("validar_cliente");

            if (!enviar_voto.verificar_voto(Integer.parseInt(campoDNI.getText()))) {
                if (rbt_Abstencion.isSelected()) {
                    enviar_voto.enviar_voto("Abstencion", Integer.parseInt(campoDNI.getText()));
                } else if (rbt_candidatoA.isSelected()) {
                    enviar_voto.enviar_voto("Andres Manuel Lopez Obrador", Integer.parseInt(campoDNI.getText()));
                } else {
                    enviar_voto.enviar_voto("Enrique Peña Nieto", Integer.parseInt(campoDNI.getText()));
                }

                JOptionPane.showMessageDialog(null, "Voto realizado correctamente", "MENSAJE DE CONFIRMACION", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "ERROR el solicitante ya realizo su voto", "ERROR", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (RemoteException ex) {
            Logger.getLogger(PantallaElectoral.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(PantallaElectoral.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void campoDNIKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoDNIKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
            btnAceptarDNIActionPerformed(null);
    }//GEN-LAST:event_campoDNIKeyPressed

    private void btn_recuento_de_votosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_recuento_de_votosActionPerformed

        Registry register;
        try {
            register = LocateRegistry.getRegistry("localhost", 1099);
            Votos miInerfaz = (Votos) register.lookup("urna");
            String[][] registro = miInerfaz.recuento();
            String salida = "CANDIDATO\t\t\tVOTOS\n\n" + registro[0][0] + "\t\t\t      " + registro[0][1] + "\n"
                    + registro[1][0] + "\t\t      " + registro[1][1] + "\n" + registro[2][0] + "\t\t      " + registro[2][1] + "\n";
            ta_results.setText(salida);
        } catch (RemoteException ex) {
            System.out.println("" + ex.getMessage());
        } catch (NotBoundException ex) {
            System.out.println("" + ex.getMessage());
        }


    }//GEN-LAST:event_btn_recuento_de_votosActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaElectoral().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptarDNI;
    private javax.swing.JButton btn_recuento_de_votos;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField campoDNI;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jp_prep;
    private javax.swing.JPanel panelDatosVotante;
    private javax.swing.JRadioButton rbt_Abstencion;
    private javax.swing.JRadioButton rbt_CandidatoB;
    private javax.swing.JRadioButton rbt_candidatoA;
    private javax.swing.JTextArea ta_results;
    private javax.swing.JTextField txtAM;
    private javax.swing.JTextField txtAP;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
