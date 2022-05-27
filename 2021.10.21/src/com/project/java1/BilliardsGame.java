package com.project.java1;


import javax.swing.*;
import java.awt.*;

/**
 * @author lixhui
 * @create 2021-10-20:23
 */
public class BilliardsGame extends JFrame {

    Image ball = Toolkit.getDefaultToolkit().getImage("images//ball.png");
    Image desk = Toolkit.getDefaultToolkit().getImage("images//desk.png");

    double x = 200;
    double y = 200;

    boolean right = true;//控制小球的水平移动是方向

    //绘制窗口
    public void paint(Graphics g){
        System.out.println("窗口被画一次！");
        g.drawImage(desk,0,0,null);
        g.drawImage(ball,(int)x,(int)y,null);

        if (right){
            x += 2;
        }else{
            x -= 2;
        }

        if (x >916){
            right = false;
        }
    }

    //创建窗口
    void launchFrame(){
        setSize(916,501);
        setLocation(100,100);
        setVisible(true);

        //实现动画,每秒绘制窗口25次
        while (true){
            repaint();

            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        System.out.println("我的小游戏开始了！");

        BilliardsGame game = new BilliardsGame();

        game.launchFrame();


    }
}
