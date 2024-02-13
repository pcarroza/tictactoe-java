package main.controllers;

import main.models.Coordinate;

public interface CoordinateController {

    Coordinate getOrigin();

    Coordinate getTarget();

    void accept(CoordinateControllerVisitor coordinateControllerVisitor);
}
