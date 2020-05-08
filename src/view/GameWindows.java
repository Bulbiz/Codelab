package src.view;

import javax.swing.*;

public class GameWindows{
    private JFrame windows;

    private String title;
    private int width, height;

    public GameWindows (String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;

        createWindows();
    }

    public void createWindows (){
        this.windows = new JFrame(this.title);
        this.windows.setSize(this.width, this.height);
        this.windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.windows.setResizable(false);
        this.windows.setLocationRelativeTo(null);
        this.windows.setVisible(true);
    }
}
