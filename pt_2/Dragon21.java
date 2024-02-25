package pt_2;

import java.util.Scanner;

public class Dragon21 {
    int x, y, width, height;
    Scanner sc = new Scanner(System.in);    

    void moveLeft() {
        x -= 1;
        if (x < 0 || x > width) {
            detectCollision();
        } 
    }

    void moveRight() {
        x += 1;
        if (x < 0 || x > width) {
            detectCollision();
        }
    }

    void moveUp() {
        y -= 1;
        if (y < 0 || y > height) {
            detectCollision();
        } 
    }

    void moveDown() {
        y += 1;
        if (y < 0 || y > height) {
            detectCollision();
        } 
    }

    void printPosition() {
        System.out.println("Dragon position: " + x + ","  + y );
    }

    void detectCollision() {
        System.out.println("Game Over!");
        System.exit(0);
        
    }

    void loopingGame() {
        while (x > 0 && x < width && y > 0 && y < height) { 
            System.out.print("Masukkan left / right / up / down : ");
            String pilih = sc.nextLine();
            System.out.println();
            switch (pilih) {
                case "left":
                    moveLeft();
                    break;
                case "right":
                    moveRight();
                    break;
                case "up":
                    moveUp();
                    break;
                case "down":
                    moveDown();
                    break;
                default:
                    break;
            }
            printPosition();
        }
    }
    public Dragon21() {

    }

    public Dragon21(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

}
