package main.controllers;

import main.models.Color;
import main.models.Coordinate;

public interface PresenterController {

    Color getColor(Coordinate coordinate);
}
