/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawlines;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import java.util.ArrayList;

/** This object will draw lines inside of a Pane when an arrow key is
 *  pressed and will draw it in that direction from the current line */
public class LineDrawingObject extends Pane {
    // ArrayList to store the Line Object's
    ArrayList<Line> lines = new ArrayList<>();
    Line line;
    private Color lineColor;
    private double lineLength;
    private double startX;
    private double startY;
    private double endX;
    private double endY;

    /** Default Constructor */
    public LineDrawingObject() {
        // Set a default size for this Pane
        this.setWidth(350);
        this.setHeight(350);
        // Set Line properties
        this.startX = getWidth() / 2;
        this.startY = getHeight() / 2;
        this.lineLength = 20;
        this.lineColor = Color.BLACK;
        // Create line and set it Stroke
        line = new Line(this.startX, this.startY,
                this.startX, this.startY - this.lineLength);
        line.setStroke(this.lineColor);
        // Add line to ArrayList and Pane
        lines.add(line);
        getChildren().add(line);
    }

    /** Second Constructor, allows you to control the line length, color and center it */
    public LineDrawingObject(double lineLength, Color lineColor) {
        // Set a default size for this Pane
        this.setWidth(350);
        this.setHeight(350);
        // Set line properties
        this.startX = getWidth() / 2;
        this.startY = getHeight() / 2;
        this.lineLength = lineLength;
        this.lineColor = lineColor;
        // Create line and set it Stroke
        line = new Line(this.startX, this.startY,
                this.startX, this.startY - this.lineLength);
        line.setStroke(this.lineColor);
        // Add line to ArrayList and Pane
        lines.add(line);
        getChildren().add(line);
    }

    /** Third Constructor, allows you to control the line length, color, and pane size */
    public LineDrawingObject(double lineLength, Color lineColor,
                             double paneWidth, double paneHeight) {
        // Set a default size for this Pane
        this.setWidth(paneWidth);
        this.setHeight(paneHeight);
        // Set line properties
        this.startX = getWidth() / 2;
        this.startY = getHeight() / 2;
        this.lineLength = lineLength;
        this.lineColor = lineColor;
        // Create line and set it Stroke
        line = new Line(this.startX, this.startY,
                this.startX, this.startY - this.lineLength);
        line.setStroke(this.lineColor);
        // Add line to ArrayList and Pane
        lines.add(line);
        getChildren().add(line);
    }

    /** Third Constructor, allows you to control the line length and color, startX, and startY */
    public LineDrawingObject(double lineLength, double startX, double startY, Color lineColor) {
        // Set line properties
        this.startX = startX;
        this.startY = startY;
        this.lineLength = lineLength;
        this.lineColor = lineColor;
        // Create line and set it Stroke
        line = new Line(this.startX, this.startY,
                this.startX, this.startY - this.lineLength);
        line.setStroke(this.lineColor);
        // Add line to ArrayList and Pane
        lines.add(line);
        getChildren().add(line);
    }

    /** Get the list of lines */
    public ArrayList<Line> getLines() {
        return lines;
    }

    /** Get the current line object */
    public Line getLine() {
        return this.line;
    }

    /** Manually set the current line object */
    public void setLine(Line line) {
        this.line = line;
    }

    /** Get the current line object color */
    public Color getLineColor() {
        return this.lineColor;
    }

    /** Set the current line object color */
    public void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
    }

    /** Get length of the lines */
    public double getLineLength() {
        return this.lineLength;
    }

    /** Set a new length for the lines */
    public void setLineLength(double lineLength) {
        this.lineLength = lineLength;
    }

    /** Get the count of the number of line currently in existence */
    public int getLineCount() {
        return this.lines.size();
    }

    /** Get the startX coordinates */
    public double getStartX() {
        return this.startX;
    }

    /** Set the startX coordinates */
    public void setStartX(double startX) {
        this.startX = startX;
    }

    /** Get the startY coordinates */
    public double getStartY() {
        return this.startY;
    }

    /** Set the startY coordinates */
    public void setStartY(double startY) {
        this.startY = startY;
    }

    /** Get the endX coordinates */
    public double getEndX() {
        return this.endX;
    }

    /** Set the endX coordinates */
    public void setEndX(double endX) {
        this.endX = endX;
    }

    /** Get the endY coordinates */
    public double getEndY() {
        return this.endY;
    }

    /** Set the endY coordinates */
    public void setEndY(double endY) {
        this.endY = endY;
    }

    /** Paint the next line based on the key pressed */
    public void paintLine(KeyCode keyCode) {
        // Set line start coordinates to the end of the last line
        setStartX(line.getEndX());
        setStartY(line.getEndY());

        // Set line end coordinates
        switch (keyCode) {
            case UP: goUp(); break;
            case LEFT: goLeft(); break;
            case DOWN: goDown(); break;
            case RIGHT: goRight(); break;
        }

        // Create line
        line = new Line(getStartX(), getStartY(), getEndX(), getEndY());
        line.setStroke(lineColor);
        this.lines.add(line);
        getChildren().add(line);
    }

    /** Set the end coordinates to the left of the last line */
    public void goLeft() {
        setEndX(getStartX() - this.lineLength);
        setEndY(getStartY());
    }

    /** Set the end coordinates to the right of the last line */
    public void goRight() {
        setEndX(getStartX() + this.lineLength);
        setEndY(getStartY());
    }

    /** Set the end coordinates above the last line */
    public void goUp() {
        setEndX(getStartX());
        setEndY(getStartY() - this.lineLength);
    }

    /** Set the end coordinates below the last line */
    public void goDown() {
        setEndX(getStartX());
        setEndY(getStartY() + this.lineLength);
    }
}