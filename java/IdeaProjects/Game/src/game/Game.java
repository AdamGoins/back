package game;

import gfx.SpriteSheet;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

/**
 * Created by root on 4/15/17.
 */
public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = 1L;

    public static final int WIDTH = 160;
    public static final int HEIGHT = WIDTH / 12 * 9;
    public static final int SCALE = 3;
    public static final String NAME = "Game";

    public boolean isRunning = false;
    public int tickCount = 0;

    private JFrame frame;

    private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

    private SpriteSheet spriteSheet = new SpriteSheet("/Spritesheet.png");

    public Game(){
        setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));

        frame = new JFrame(NAME);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(this, BorderLayout.CENTER);
        frame.pack();

        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public synchronized void start(){
        isRunning = true;
        new Thread(this).start();

    }

    public synchronized void stop(){
        isRunning = false;
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double nsPerTick = 1000000000 / 60;

        int ticks = 0;
        int frames = 0;

        long lastTimer = System.currentTimeMillis();
        double delta = 0;


        while(isRunning){
            long now = System.nanoTime();
            delta += (now - lastTime) / nsPerTick;
            lastTime = now;
            boolean shouldRender = true;


            while(delta >= 1){
                ticks++;
                tick();
                delta -= 1;
                shouldRender = true;
            }

            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            if(shouldRender) {
                frames++;
                render();
            }

            if (System.currentTimeMillis() - lastTimer >= 1000){
                lastTimer += 1000;
                System.out.println("Ticks: " + ticks + ", Frames: " + frames);
                frames = 0;
                ticks = 0;
            }

        }

    }

    public void tick(){
        tickCount++;

        for(int i = 0; i < pixels.length; i++){
            pixels[i] = i + tickCount;
        }

    }

    public void render(){
        BufferStrategy bs = getBufferStrategy();
        if (bs == null){
            createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();


        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        g.dispose();
        bs.show();
    }

    public static void main(String[] args){
        new Game().start();
    }

}
