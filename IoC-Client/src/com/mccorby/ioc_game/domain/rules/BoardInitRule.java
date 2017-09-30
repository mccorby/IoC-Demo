package com.mccorby.ioc_game.domain.rules;

import ioc_container.CheckableRule;

import java.util.Random;

/**
 * This rule initialises a board with boolean values
 */
public class BoardInitRule extends CheckableRule {

    private boolean[][] matrix;
    private boolean hasOneTrueValue;

    public BoardInitRule(boolean[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    protected boolean preExecution() {
        return matrix != null;
    }

    @Override
    protected void executeBody() {
        Random random = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = random.nextBoolean();
                if (matrix[i][j]) {
                    hasOneTrueValue = true;
                }
            }
        }
    }

    @Override
    protected boolean postExecution() {
        return hasOneTrueValue;
    }

    @Override
    public String toString() {
        return "Board Init Rule";
    }
}
