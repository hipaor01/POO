/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View.GUI;

import controller.Controller;
import deepspace.BetaPowerEfficientSpaceStationToUI;
import deepspace.GameState;
import deepspace.PowerEfficientSpaceStationToUI;
import deepspace.ShieldToUI;
import deepspace.SpaceCityToUI;
import deepspace.SpaceStationToUI;
import deepspace.WeaponToUI;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class VistaSpaceStation extends javax.swing.JPanel {
    VistaDamage damageView;
    VistaHangar hangarView;

    /**
     * Creates new form VistaSpaceStation
     */
    public VistaSpaceStation() {
        initComponents();
        
        repaint();
        revalidate();
    }
    
    void setSpaceStation(SpaceStationToUI station){
        fireStation.setText(Float.toString(station.getAmmoPower()));
        fuelStation.setText(Float.toString(station.getFuelUnits()));
        medalsStation.setText(Integer.toString(station.getnMedals()));
        
        pendingDamage2.removeAll();
        damageView = new VistaDamage();
        damageView.setDamage(station.getPendingDamage(), "Castigo Pendiente");
        pendingDamage2.add(damageView);
        
        shieldStation.setText(Float.toString(station.getShieldPower()));
        
        stationName.setText(station.getName());
        stationName.setBackground(Color.gray);
        stationName.setOpaque(true);
        
        panelHangarStation.removeAll();
        hangarView = new VistaHangar();
        hangarView.setHangar(station.getHangar());
        panelHangarStation.add(hangarView);
        
        panelShieldsMounted.removeAll();
        ArrayList<ShieldToUI> shieldBoosters = station.getShieldBoosters();
        VistaShield shieldView;
        for(int i = 0; i < shieldBoosters.size(); i++){
            shieldView = new VistaShield();
            shieldView.setShield(shieldBoosters.get(i));
            panelShieldsMounted.add(shieldView);
        }
        
        panelWeaponsMounted.removeAll();
        ArrayList<WeaponToUI> weapons = station.getWeapons();
        VistaWeapon weaponView;
        for(int i = 0; i < weapons.size(); i++){
            weaponView = new VistaWeapon();
            weaponView.setWeapon(weapons.get(i));
            panelWeaponsMounted.add(weaponView);
        }
        
        
        enabledButtons(station);
        
        if(station instanceof SpaceCityToUI){
            tipo.setText("Ciudad espacial");
        }else{
            if(station instanceof BetaPowerEfficientSpaceStationToUI){
                tipo.setText("Estación Eficiente Beta");
            }else{
                if(station instanceof PowerEfficientSpaceStationToUI){
                    tipo.setText("Estación Eficiente");
                }else{
                    tipo.setText("Estación normal");
                }
            }
        }
        
        repaint();
        revalidate();
    }
    
    private void enabledButtons(SpaceStationToUI station){
        if(Controller.getInstance().getState() == GameState.BEFORECOMBAT || Controller.getInstance().getState() == GameState.CANNOTPLAY){
            mountButton.setEnabled(false);
            discardButton.setEnabled(false);
            discardHangarButton.setEnabled(false);
        }else{
            if(station.getHangar().getMaxElements() != 0){
                mountButton.setEnabled(true);
            }else{
                mountButton.setEnabled(false);
            }
            
            if(station.getHangar().getMaxElements() != 0 || station.getWeapons().size() != 0 || station.getShieldBoosters().size() != 0){
                discardButton.setEnabled(true);
            }else{
                discardButton.setEnabled(false);
            }
            
            if(station.getHangar() != null){
                discardHangarButton.setEnabled(true);
            }else{
                discardButton.setEnabled(false);
            }
        }
    }
    
    ArrayList<Integer> getSelectedWeapons(){
        ArrayList<Integer> selectedWeaponsMounted = new ArrayList<>();
        int i = 0;
        
        for(Component c : panelWeaponsMounted.getComponents()){
            if(((VistaWeapon)c).isSelected()){
                selectedWeaponsMounted.add(i);
            }
            i++;
        }
        
        return selectedWeaponsMounted;
    }
    
    ArrayList<Integer> getSelectedShields(){
        ArrayList<Integer> selectedShieldsMounted = new ArrayList<>();
        int i = 0;
        
        for(Component c: panelShieldsMounted.getComponents()){
            if(((VistaShield) c).isSelected()){
                selectedShieldsMounted.add(i);
            }
            i++;
        }
        
        return selectedShieldsMounted;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fireStation = new javax.swing.JLabel();
        fireTitle = new javax.swing.JLabel();
        fuelStation = new javax.swing.JLabel();
        fuelTitle = new javax.swing.JLabel();
        medalsStation = new javax.swing.JLabel();
        medalsTitle = new javax.swing.JLabel();
        mountButton = new javax.swing.JButton();
        panelHangarStation = new javax.swing.JPanel();
        pendingDamage = new javax.swing.JPanel();
        shieldStation = new javax.swing.JLabel();
        shieldTitle = new javax.swing.JLabel();
        shieldsMounted = new javax.swing.JScrollPane();
        panelShieldsMounted = new javax.swing.JPanel();
        weaponsMounted = new javax.swing.JScrollPane();
        panelWeaponsMounted = new javax.swing.JPanel();
        stationName = new javax.swing.JLabel();
        discardHangarButton = new javax.swing.JButton();
        discardButton = new javax.swing.JButton();
        pendingDamage2 = new javax.swing.JPanel();
        titleTipo = new javax.swing.JLabel();
        tipo = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        fireStation.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        fireStation.setText("jLabel1");

        fireTitle.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        fireTitle.setText("Potencia de ataque:");

        fuelStation.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        fuelStation.setText("jLabel1");

        fuelTitle.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        fuelTitle.setText("Nivel de combustible:");

        medalsStation.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        medalsStation.setText("jLabel1");

        medalsTitle.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        medalsTitle.setText("Medallas:");

        mountButton.setText("Equipar");
        mountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mountButtonActionPerformed(evt);
            }
        });

        panelHangarStation.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        pendingDamage.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        shieldStation.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        shieldStation.setText("jLabel1");

        shieldTitle.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        shieldTitle.setText("Potencia de defensa:");

        shieldsMounted.setBackground(new java.awt.Color(239, 239, 239));
        shieldsMounted.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Potenciadores de Defensa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(1, 1, 1))); // NOI18N
        shieldsMounted.setViewportView(panelShieldsMounted);

        weaponsMounted.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Potenciadores de Fuego", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(1, 1, 1))); // NOI18N
        weaponsMounted.setViewportView(panelWeaponsMounted);

        stationName.setBackground(new java.awt.Color(255, 0, 0));
        stationName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        stationName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stationName.setText("Estación de Ejemplo");

        discardHangarButton.setText("Descartar Hangar Completo");
        discardHangarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discardHangarButtonActionPerformed(evt);
            }
        });

        discardButton.setText("Descartar");
        discardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discardButtonActionPerformed(evt);
            }
        });

        titleTipo.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        titleTipo.setText("Tipo:");

        tipo.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        tipo.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(medalsTitle)
                                        .addGap(18, 18, 18)
                                        .addComponent(medalsStation)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(fuelTitle)
                                                .addGap(18, 18, 18)
                                                .addComponent(fuelStation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(stationName)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(fireTitle)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(fireStation))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(shieldTitle)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(shieldStation, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 555, Short.MAX_VALUE)
                                                .addComponent(pendingDamage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(28, 28, 28)
                                                .addComponent(titleTipo)
                                                .addGap(18, 18, 18)
                                                .addComponent(tipo)
                                                .addGap(0, 0, Short.MAX_VALUE))))))
                            .addComponent(weaponsMounted, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pendingDamage2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(mountButton)
                                .addGap(53, 53, 53)
                                .addComponent(discardButton)
                                .addGap(52, 52, 52)
                                .addComponent(discardHangarButton))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(panelHangarStation, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(shieldsMounted, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fuelTitle)
                            .addComponent(fuelStation))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(medalsTitle)
                            .addComponent(medalsStation))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(weaponsMounted, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pendingDamage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(stationName)
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(fireTitle)
                                    .addComponent(fireStation)
                                    .addComponent(titleTipo)
                                    .addComponent(tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(shieldTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(shieldStation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(pendingDamage2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(shieldsMounted, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelHangarStation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mountButton)
                    .addComponent(discardButton)
                    .addComponent(discardHangarButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void mountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mountButtonActionPerformed
        // TODO add your handling code here:
        ArrayList<Integer> weaponsSelected = new ArrayList<>();
        ArrayList<Integer> shieldsSelected = new ArrayList<>();
        
        weaponsSelected = hangarView.getSelectedWeapons();
        shieldsSelected = hangarView.getselectedShields();
        
        Controller.getInstance().mount(weaponsSelected, shieldsSelected);
        
        VentanaPrincipal.getInstance().updateView();
    }//GEN-LAST:event_mountButtonActionPerformed

    private void discardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discardButtonActionPerformed
        // TODO add your handling code here:
        ArrayList<Integer> weaponsMountedSelected = new ArrayList<>();
        ArrayList<Integer> shieldsMountedSelected = new ArrayList<>();
        ArrayList<Integer> weaponsSelectedInHangar = new ArrayList<>();
        ArrayList<Integer> shieldsSelectedInHangar = new ArrayList<>();
        
        weaponsMountedSelected = getSelectedWeapons();
        shieldsMountedSelected = getSelectedShields();
        weaponsSelectedInHangar = hangarView.getSelectedWeapons();
        shieldsSelectedInHangar = hangarView.getselectedShields();
        
        Controller.getInstance().discard(Controller.WEAPON, weaponsMountedSelected, shieldsMountedSelected);
        Controller.getInstance().discard(Controller.SHIELD, weaponsMountedSelected, shieldsMountedSelected);
        
        if(Controller.getInstance().getUIversion().getCurrentStation().getHangar() != null){
            Controller.getInstance().discard(Controller.HANGAR, weaponsSelectedInHangar, shieldsSelectedInHangar);
        }
        
        VentanaPrincipal.getInstance().updateView();
    }//GEN-LAST:event_discardButtonActionPerformed

    private void discardHangarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discardHangarButtonActionPerformed
        // TODO add your handling code here:
        Controller.getInstance().discardHangar();
        VentanaPrincipal.getInstance().updateView();
    }//GEN-LAST:event_discardHangarButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton discardButton;
    private javax.swing.JButton discardHangarButton;
    private javax.swing.JLabel fireStation;
    private javax.swing.JLabel fireTitle;
    private javax.swing.JLabel fuelStation;
    private javax.swing.JLabel fuelTitle;
    private javax.swing.JLabel medalsStation;
    private javax.swing.JLabel medalsTitle;
    private javax.swing.JButton mountButton;
    private javax.swing.JPanel panelHangarStation;
    private javax.swing.JPanel panelShieldsMounted;
    private javax.swing.JPanel panelWeaponsMounted;
    private javax.swing.JPanel pendingDamage;
    private javax.swing.JPanel pendingDamage2;
    private javax.swing.JLabel shieldStation;
    private javax.swing.JLabel shieldTitle;
    private javax.swing.JScrollPane shieldsMounted;
    private javax.swing.JLabel stationName;
    private javax.swing.JLabel tipo;
    private javax.swing.JLabel titleTipo;
    private javax.swing.JScrollPane weaponsMounted;
    // End of variables declaration//GEN-END:variables
}
