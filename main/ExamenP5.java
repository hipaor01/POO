/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import View.DeepSpaceView;
import View.GUI.VentanaPrincipal;
import controller.Controller;
import deepspace.DeepspaceKamikaze;
import deepspace.GameUniverse;

/**
 *
 * @author usuario
 */
public class ExamenP5 {
    public static void main(String[] args){
        GameUniverse game = new DeepspaceKamikaze();
        DeepSpaceView view = VentanaPrincipal.getInstance();
        Controller controller = Controller.getInstance();
        controller.setModelView(game, view);
        controller.start();
    }
}
