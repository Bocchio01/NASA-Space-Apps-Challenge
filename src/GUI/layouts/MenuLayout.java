package GUI.layouts;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import utils.Constants.GUI;

public class MenuLayout extends JPanel {

    public JPanel subPanel;

    protected GridBagConstraints mainPanelConstrains = new GridBagConstraints() {
        {
            gridx = GridBagConstraints.RELATIVE;
            gridy = 0;
            weightx = 1;
            weighty = 1;
            anchor = GridBagConstraints.CENTER;
            fill = GridBagConstraints.BOTH;
        }
    };

    protected GridBagConstraints subPanelConstrains = new GridBagConstraints() {
        {
            gridx = 0;
            gridy = GridBagConstraints.RELATIVE;
            weightx = 1;
            weighty = 1;
            anchor = GridBagConstraints.CENTER;
        }
    };

    public MenuLayout() {
        setLayout(new GridBagLayout());
        subPanel = new JPanel(new GridBagLayout());

        add(subPanel, mainPanelConstrains);

        subPanel.setPreferredSize(new Dimension(250, 500));
        JScrollPane scrollFrame = new JScrollPane(subPanel);
        subPanel.setAutoscrolls(false);
        scrollFrame.setPreferredSize(new Dimension( 300, 300));
        add(scrollFrame);
    }

    public void addComponent(JLabel component) {
        subPanel.add(component, subPanelConstrains);
    }

}
