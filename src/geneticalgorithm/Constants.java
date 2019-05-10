/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticalgorithm;

/**
 *
 * @author Aman
 */
public class Constants {
    private Constants(){
    }
    public static final int [] SOLUTION_SEQUENCE = {0,1,2,3,4,5,6,7,8,9};
    public static final double CROSSOVER_RATE = 0.5;
    public static final double MUTATION_RATE = 0.15;
    public static final int TOURNAMENT_SIZE =5;
    public static final int CHROMOSOME_LENGTH =16;
    public static final int MAX_FITNESS = 10;
    public static final int SIMULATION_LENGTH = 100;
    public static final int GENE_LENGTH = 10;
}
