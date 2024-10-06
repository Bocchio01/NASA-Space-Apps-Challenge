package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import models.record.StarRecord;
import utils.Constants;

public class Widget {

    public static class FormPanel extends JPanel {

        public FormPanel(Theme appTheme, String labelText, JComponent activeArea) {
            super(new GridBagLayout());

            JLabel label = new JLabel(labelText);
            activeArea.setPreferredSize(Constants.GUI.WIDGET_DIMENSION);

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.NORTHWEST;
            gbc.insets = new Insets(5, 5, 2, 5);
            add(label, gbc);

            gbc.gridy = 1;
            gbc.insets = new Insets(0, 5, 5, 5);
            add(activeArea, gbc);

            appTheme.registerPanel(this);
            appTheme.registerLabel(label);
        }
    }

    public static class Button extends JButton {

        public Button(String text) {
            setText(text);
            setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            setPreferredSize(Constants.GUI.WIDGET_DIMENSION);
        }
    }

    public static class LogoLabel extends JLabel {

        public LogoLabel() {
            this(2);
        }

        public LogoLabel(double scale) {
            this((int) (200 * scale), (int) (186 * scale));
        }

        public LogoLabel(int width, int height) {
            setHorizontalAlignment(JLabel.CENTER);
            setVerticalAlignment(JLabel.CENTER);

            try {

                BufferedImage originalImage = ImageIO.read(getClass().getResource(Constants.Path.Assets.LOGO));
                Image scaledImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);

                ImageIcon icon = new ImageIcon(scaledImage);
                setIcon(icon);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static class ComboItem {
        private String label;
        private int value;

        public ComboItem(String label, int value) {
            this.label = label;
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    public static class StarField extends JPanel {

        private List<StarRecord> stars;

        public StarField(List<StarRecord> stars) {
            this.stars = List.of(
                    new StarRecord(100, 150, 1, 3),
                    new StarRecord(200, 100, 5, 2),
                    new StarRecord(300, 200, 10, 5));
            setLayout(new GridBagLayout());
            setBackground(Color.BLACK);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            for (StarRecord star : stars) {

                int size = getSizeBasedOnDistance(star.getDistanceFromPlanet());

                g2d.setColor(getColorBasedOnBrightness(star.getBrightness()));

                g2d.fillOval(star.getX(), star.getY(), size, size);
            }
        }

        private int getSizeBasedOnDistance(double distance) {

            return (int) Math.max(1, 10 - distance * 0.1);
        }

        private Color getColorBasedOnBrightness(int brightness) {
            switch (brightness) {
                case 1:
                    return new Color(200, 200, 255);
                case 2:
                    return new Color(150, 150, 255);
                case 3:
                    return new Color(100, 100, 255);
                case 4:
                    return new Color(50, 50, 255);
                case 5:
                    return new Color(0, 0, 255);
                default:
                    return Color.WHITE;
            }
        }
    }
}
