package pl.travelbrowser.ui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
    private Image image;

    public void setImage(Image image) {
        this.image = image;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image == null) {
            return;
        }

        int imgW = image.getWidth(this);
        int imgH = image.getHeight(this);
        double scale = Math.max((double) getWidth() / imgW, (double) getHeight() / imgH);
        int drawW = (int) (imgW * scale);
        int drawH = (int) (imgH * scale);
        int x = (getWidth() - drawW) / 2;
        int y = (getHeight() - drawH) / 2;

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(image, x, y, drawW, drawH, this);
    }

}