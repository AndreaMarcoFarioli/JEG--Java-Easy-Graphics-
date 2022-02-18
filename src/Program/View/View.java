package Program.View;

import GameUtilities.GameObject.GameObject;
import GameUtilities.GameRender;

import javax.swing.*;
import java.awt.*;

public class View {
    private JFrame mainFrame;
    private Graphics g;
    private GameRender gameRender = new GameRender();
    private Timer time;

    public void render(){
        mainFrame = new JFrame("TBalls");
        mainFrame.setSize(900, 750);
        mainFrame.setLocationRelativeTo(null);

        initializePanel();

        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void initializePanel(){
        mainFrame.setContentPane(gameRender.getPanel());
    }

    public void instantiate(Object object) throws Exception{
        if(!(object instanceof GameObject))
            throw new Exception("Object isn't an instance of GameObject");
        gameRender.instantiate(object);
    }
    public Dimension getGameRenderSize(){
        return gameRender.getPanel().getSize();
    }
}
