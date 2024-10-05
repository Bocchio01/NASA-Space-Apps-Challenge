package utils;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import GUI.GUI;

public class Interfaces {

    public interface ExampleRecord {
        Integer getID();
    }

    public interface UIWindows {
        JFrame getMainFrame();
   
        JPanel getMenuPanel();
        
        JPanel getExplorerPanel();

        CardLayout getMenuCardLayout();
    }

    public interface UIPanel {
        JPanel createPanel(GUI gui);
    
        void onOpen(Object[] args);
    
        String getID();
    }
}
