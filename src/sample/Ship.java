package sample;

import javafx.scene.shape.Polygon;

/**
 *
 * @author Akshat
 */
public class Ship extends Character {

    public Ship(int x, int y) {
        super(new Polygon(-2.5, 0, -5, -5, 10, 0, -5, 5), x, y);
    }
}
