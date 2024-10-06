package GUI.layouts;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

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

        // subPanel.setPreferredSize(new Dimension(250, 500));

        JScrollPane scrollFrame = new JScrollPane(subPanel);
        scrollFrame.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollFrame.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        add(scrollFrame, mainPanelConstrains);
    }

    public void addComponent(Component component) {
        subPanel.add(component, subPanelConstrains);
    }

}
