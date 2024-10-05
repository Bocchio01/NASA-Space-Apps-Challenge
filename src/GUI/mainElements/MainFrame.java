package GUI.mainElements;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import GUI.Widget;
import utils.Constants;
import utils.Interfaces;

public class MainFrame extends JFrame implements Interfaces.UIWindows {

    private CardLayout menuCardLayout = new CardLayout();
    private JPanel menuPanel = new JPanel(menuCardLayout);
    private JPanel explorerPanel;

    public MainFrame() {
        setSize(Constants.GUI.FRAME_WIDTH, Constants.GUI.FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        setTitle(Constants.APP_TITLE);
        setIcon(Constants.Path.Assets.LOGO);
        setLayout(new BorderLayout(2, 2));

        add(menuPanel, BorderLayout.WEST);

    }

    private void setIcon(String iconPath) {
        ImageIcon iconImage = new ImageIcon();

        try {
            Image originalImage = ImageIO.read(Widget.class.getResource(iconPath));
            iconImage = new ImageIcon(originalImage);
        } catch (IOException e) {
            // TODO Auto-generated catch block
        }

        setIconImage(iconImage.getImage());
    }

    public void setExplorerDisplay(JPanel explorerDisplay) {
        this.explorerPanel = explorerDisplay;

        add(explorerDisplay, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    @Override
    public JFrame getMainFrame() {
        return this;
    }

    @Override
    public JPanel getMenuPanel() {
        return menuPanel;
    }

    @Override
    public JPanel getExplorerPanel() {
        return explorerPanel;
    }

    @Override
    public CardLayout getMenuCardLayout() {
        return menuCardLayout;
    }
}
