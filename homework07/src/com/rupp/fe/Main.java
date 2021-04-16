package com.rupp.fe;


import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;


public class Main implements GLEventListener, ActionListener {
    private CallBack callBack;
    private Scanner scanner;

    Main() {
        final GLProfile gp = GLProfile.get(GLProfile.GL2);
        GLCapabilities cap = new GLCapabilities(gp);

        final GLCanvas gc = new GLCanvas(cap);
        gc.addGLEventListener(this);
        gc.setSize(400, 400);

        // set the menu here

        //Create a Menu
        JMenu menu = new JMenu("Menu");
        JMenu jMenuOption = new JMenu("Option");
        //Create Menu Items
        JMenuItem[] item = new JMenuItem[5];

        item[0] = new JMenuItem("DDA");
        item[0].addActionListener(this);
        menu.add(item[0]);
        item[1] = new JMenuItem("BVA");
        item[1].addActionListener(this);
        menu.add(item[1]);

        item[0] = new JMenuItem("Color");
        item[0].addActionListener(this);
        jMenuOption.add(item[0]);
        item[1] = new JMenuItem("Width");
        item[1].addActionListener(this);
        jMenuOption.add(item[1]);

        //Create a menu bar
        JMenuBar mb = new JMenuBar();
        mb.add(menu);
        mb.add(jMenuOption);

        final JFrame frame = new JFrame("Computer Graphic");
        frame.setJMenuBar(mb);
        frame.add(gc);
        frame.setSize(500, 400);
        frame.setVisible(true);
    }

    @Override
    public void init(GLAutoDrawable arg0) {
        GL2 gl = arg0.getGL().getGL2();
        GLU glu = new GLU();

        gl.glClearColor(0f, 0f, 0f, 1.0f);
        gl.glViewport(-250, -150, 250, 150);
        gl.glMatrixMode(gl.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluOrtho2D(-250.0, 250.0, -150.0, 150.0);


    }

    @Override
    public void display(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        callBack.onGL2(gl);
    }

    @Override
    public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {

    }

    @Override
    public void dispose(GLAutoDrawable arg0) {

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        callBack = gl2 -> {
            DrawLine drawLine = new DrawLine(gl2);
          //  new Utils().drawLine(actionEvent.getActionCommand(), drawLine);
            scanner = new Scanner(System.in);
            int x0, y0, x1, y1;
            System.out.println("Enter x0");
            x0 = scanner.nextInt();
            System.out.println("Enter y0");
            y0 = scanner.nextInt();
            System.out.println("Enter x1");
            x1 = scanner.nextInt();
            System.out.println("Enter y1");
            y1 = scanner.nextInt();
            System.out.println("x, y, " + x0);
            String cmd = actionEvent.getActionCommand();
            if (cmd.equals("DDA")) {
                //register draw point from here
                //drawLine.dda(1 - 10, 1 - 10, 8 - 10, 5 - 10);
                drawLine.dda(x1, y0, x1, y1);
            } else {
                // drawLine.blda(1, 1, 8, 5);
                drawLine.blda(x1, y0, x1, y1);
            }

        };
    }

    public static void main(String[] args) {
        new Main();
    }

}