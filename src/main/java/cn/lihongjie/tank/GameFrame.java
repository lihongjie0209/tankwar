package cn.lihongjie.tank;

import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
@Slf4j
public class GameFrame extends Frame {

    int x = 0;
    int y = 0;


    public GameFrame() throws HeadlessException {
        final Frame that = this;
        this.setSize(800, 600);
        this.setResizable(false);
        this.setTitle("坦克大战");
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent e) {
                System.exit(0);

            }
        });
        log.info("start running");
        this.setVisible(true);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(final KeyEvent e) {
                super.keyTyped(e);
                log.info(e.toString());
            }

            @Override
            public void keyPressed(final KeyEvent e) {

                log.info(e.toString());
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        x = Math.max(0, x - 10);
                        break;
                    case KeyEvent.VK_RIGHT:
                        x = Math.min(800, x + 10);
                        break;
                    case KeyEvent.VK_UP:
                        y = Math.max(0, y - 10);
                        break;

                    case KeyEvent.VK_DOWN:
                        y = Math.min(600, y + 10);
                        break;


                }
                that.repaint();

            }

            @Override
            public void keyReleased(final KeyEvent e) {
                super.keyReleased(e);
                log.info(e.toString());
            }
        });
    }

    @Override
    public void paint(final Graphics g) {
        log.info("paint");

        g.fillRect(x, y, 50, 50);
        log.info(String.format("x = %d y = %d", x, y));

    }



}
