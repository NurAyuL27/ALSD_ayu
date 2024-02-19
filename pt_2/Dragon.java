package pt_2;
public class Dragon {
    int x, y, width, height;

    public Dragon(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    void moveLeft() {
        if (x > 0) {
            x--;
        } else {
            detectCollision();
        }
    }

    void moveRight() {
        if (x < width) {
            x++;
        } else {
            detectCollision();
        }
    }

    void moveUp() {
        if (y > 0) {
            y--;
        } else {
            detectCollision();
        }
    }

    void moveDown() {
        if (y < height) {
            y++;
        } else {
            detectCollision();
        }
    }

    void printPosition() {
        System.out.println("Position: (" + x + ", " + y + ")");
    }

    void detectCollision() {
        System.out.println("Game Over");
    }
}
