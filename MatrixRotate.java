package Matrix;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Don on 17.07.2016.
 */
public class MatrixRotate {

    public void rotateMatrix() {
        int degree = degreeRotate();
        boolean isTrue = degreeVerify(degree);
        if (isTrue) {
            int[][] Matrix = createRamdomMatrix();
            int[][] RotateMatrix = matrixRotation(Matrix, degree);
            System.out.println("Original matrix is: ");
            matrixPrint(Matrix);
            System.out.println("New matrix is (rotate to): "+degree+" degree contraclockwise");
            matrixPrint(RotateMatrix);
        }
        else {
            System.out.print("You enter not valid degree for rotate");
        }
    }

    static void matrixPrint(int[][] matrix) {
        for (int x = 0;x<matrix.length;x++) {
            for (int y = 0;y<matrix[0].length;y++){
                System.out.print(matrix[x][y]+" ");
            }
            System.out.println("");
        }
    }

    static int[][] matrixRotation(int [][] matrix, int degree) {
        int Steps = degree / 3;
        int[][] newMatrix = matrixRotation90(matrix);
        for (int i = 0;i<Steps-1; i++) {
            newMatrix = matrixRotation90(newMatrix);
        }
        return newMatrix;
    }

    static int [][] matrixRotation90(int [][] matrix) {
        int [][] rotateMatrix = new int[matrix[0].length][matrix.length];
        for (int oldX = 0; oldX < matrix.length; oldX++) {
            int newX = matrix[0].length - 1;
            for (int oldY = 0; oldY < matrix[0].length; oldY ++) {
                rotateMatrix[newX][oldX] = matrix[oldX][oldY];
                newX--;
            }
        }
        return rotateMatrix;
    }

    static int[][] createRamdomMatrix() {
        Random random = new Random();
        int xMatrix = random.nextInt(5)+2;
        int yMatrix = random.nextInt(5)+2;
        int[][] newMatrix = new int[xMatrix][yMatrix];
        for (int x = 0; x < xMatrix; x++) {
            for (int y = 0; y < yMatrix; y++) {
                newMatrix[x][y] =random.nextInt(10);
            }
        }
        return newMatrix;
    }

    static int degreeRotate() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter degree to rotate a matrix (90, 180 or 270)");
        int degree = in.nextInt();
        return degree;
    }

    static boolean degreeVerify(int degree) {
        if ((degree != 90) & (degree != 180) & (degree != 270)) {
            return false;
        }
        else {
            return true;
        }
    }
}
