package sample;

import javafx.geometry.Point2D;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

/**
 *
 * @author Akshat
 */
public abstract class Character {

    private Polygon character;
    private Point2D movement;
    private boolean alive = true;

    public Character(Polygon character, int x, int y) {
        this.character = character;
        character.setTranslateX(x);
        character.setTranslateY(y);
        this.movement = new Point2D(0, 0);
    }

    public void setMovement(Point2D movement) {
        this.movement = movement;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public boolean isAlive() {
        return alive;
    }

    public Point2D getMovement() {
        return movement;
    }

    public Polygon getCharacter() {
        return character;
    }

    public void turnLeft() {
        this.character.setRotate(this.character.getRotate() - 5);
    }

    public void turnRight() {
        this.character.setRotate(this.character.getRotate() + 5);
    }

    public void accelerate() {
        double changeX = Math.cos(Math.toRadians(this.character.getRotate()));
        double changeY = Math.sin(Math.toRadians(this.character.getRotate()));

        changeX *= 0.05;
        changeY *= 0.05;

        this.movement = this.movement.add(changeX, changeY);
    }

    public boolean collide(Character other) {
        Shape collisionArea = Shape.intersect(this.character, other.getCharacter());
        return collisionArea.getBoundsInLocal().getWidth() != -1;
    }

    public void move() {
        this.character.setTranslateX(this.character.getTranslateX() + this.movement.getX());
        this.character.setTranslateY(this.character.getTranslateY() + this.movement.getY());

        if (this.character.getTranslateX() < -15) {
            this.character.setTranslateX(this.character.getTranslateX() + AsteroidApplication.WIDTH + 15);
        }

        if (this.character.getTranslateX() > AsteroidApplication.WIDTH + 15) {
            this.character.setTranslateX(this.character.getTranslateX() % AsteroidApplication.WIDTH);
        }

        if (this.character.getTranslateY() < -15) {
            this.character.setTranslateY(this.character.getTranslateY() + AsteroidApplication.HEIGHT + 15);
        }

        if (this.character.getTranslateY() > AsteroidApplication.HEIGHT + 15) {
            this.character.setTranslateY(this.character.getTranslateY() % AsteroidApplication.HEIGHT);
        }
    }
}

