package Ejercicios.contorllers;

import java.util.ArrayList;
import java.util.List;

import Ejercicios.models.Celda;

/*
 * Un jugador está en la esquina superior izquierda (0,0) de un tablero m x n. En el tablero hay celdas
 * transitables (true) y no transitables (false). Encuentra un camino válido para ir a la esquina
 * inferior izquierda con el jugador, sabiendo que solo se puede mover hacia abajo y hacia la derecha.
 *
 * Ejemplo 1:
 *  Input:
 *    [
 *      [true,true,true,true]
 *      [false,false,false,true]
 *      [true,true,false,true]
 *      [true,true,false,true]
 *    ]
 *
 *  Output: [(0,0), (0,1), (0,2), (0,3), (1,3), (2,3), (3,3)]
 *
 * Ejemplo 2:
 *  Input:
 *    [
 *      [true,true,true,true]
 *      [false,true,true,true]
 *      [true,true,false,false]
 *      [true,true,true,true]
 *    ]
 *
 *  Output: [(0,0), (0,1), (1,1), (2,1), (3,1), (3,2), (3,3)]
 *
 */
public class Laberinto {

    public List<Celda> getPath(boolean[][] grid) {
        
        List<Celda> path = new ArrayList<>();
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
        }
        if (findPath(grid, 0, 0, path)) {
            return path;
        }
        return new ArrayList<>();
    }
    

    private boolean findPath(boolean[][] grid, int row, int col, List<Celda> path) {
        // Caso base
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            
            path.add(new Celda(row, col));
            return true; 
        }
        
        if (row >= grid.length || col >= grid[0].length || !grid[row][col]) {
            return false; // No se puede continuar desde esta celda.
        }
        
        // Agrega la celda actual al camino.
        path.add(new Celda(row, col));
        
        // Intenta moverse hacia abajo.
        if (findPath(grid, row + 1, col, path)) {
            return true; // Si encuentra un camino moviéndose hacia abajo, retorna true.
        }
        
        // Intenta moverse hacia la derecha.
        if (findPath(grid, row, col + 1, path)) {
            return true; // Si encuentra un camino moviéndose hacia la derecha, retorna true.
        }
        
        
        return false; 
    }
     
}


