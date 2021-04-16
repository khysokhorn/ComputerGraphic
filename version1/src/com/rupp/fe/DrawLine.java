package com.rupp.fe;

import com.jogamp.opengl.GL2;

class DrawLine {
    private final GL2 gl2;

    public DrawLine(GL2 gl2) {
        this.gl2 = gl2;
    }
    
    // DDA
    public void dda(double x1, double y1, int x2, int y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        int step;
        if (dx > dy) {
            step = (int) Math.abs(dx);
        } else
            step = (int) Math.abs(dy);
        double x_inc = (dx / (step * 1.0));
        double y_inc = (dy / (step * 1.0));
        System.out.println("step value is " + step);
        System.out.println("dx value is " + dx);
        System.out.println("dy value is " + dy);
        System.out.println("xInc value is " + x_inc);
        System.out.println("yInc value is " + y_inc);

        System.out.println((int) Math.round(0.6));
        System.out.println((int) 0.5);
        System.out.println("-----------------------");
        for (int i = 0; i < step; i++) {
            gl2.glPointSize(5.0f);
            gl2.glBegin(GL2.GL_POINTS);
            gl2.glColor3f(1, 0, 1);
            gl2.glVertex2i((int) Math.round(x1), (int) Math.round(y1));
            gl2.glEnd();

            x1 = x1 + x_inc;
            y1 = y1 + y_inc;
            System.out.println("(x, y) = (" + x1 + " , " + y1 + " )");
            System.out.println("(x, y) = (" + (int) Math.round(x1) + " , " + (int) Math.round(y1) + " )");

        }
        gl2.glEnd();
    }

    public void blda(int x1, int y1, int x2, int y2) {
        int x = x1;
        int y = y1;
        int dx = x2 - x1;
        int dy = y2 - y1;
        int p = 2 * dy - dx;

        while (x <= x2) {
            gl2.glPointSize(5.0f);
            gl2.glBegin(GL2.GL_POINTS);
            gl2.glColor3f(1, 1, 1);
            gl2.glVertex2i(x, y);
            gl2.glEnd();
            x++;
            if (p < 0) {
                p = p + 2 * dy;
            } else {
                p = p + 2 * dy - 2 * dx;
                y++;
            }
            System.out.println("(x, y, p) = (" + x + ", " + y + ", " + p + " )");
        }

    }

    public void drawPoint(int x, int y) {
        gl2.glBegin(GL2.GL_POINTS);
        gl2.glPointSize(100.0f);
        gl2.glColor3f(1, 0, 1);
        gl2.glVertex2f(x, y);
        gl2.glEnd();
    }

    public void drawLine(int x1, int y1, int x2, int y2) {
        gl2.glBegin(GL2.GL_LINES);
        gl2.glVertex2i(x1, y1);
        gl2.glVertex2i(x2, y2);
        gl2.glEnd();
    }

    public void drawTable() {
        // horizontals line
        int t = -40;
        int temp = t;
        for (int i = 0; i < 10; i++) {
            // horizontals
            drawLine(temp, t, 100 + (temp * (-1)), t);
            // vertical line
            drawLine(t, temp, t, 100 + (temp * (-1)));
            t += 20;
        }


    }
}