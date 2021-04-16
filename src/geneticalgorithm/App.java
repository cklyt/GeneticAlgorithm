/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticalgorithm;

/**
 *
 * @author louis
 */
public class App {
    public static void main(String[] args) {
        GeneticAlgorithm GA = new GeneticAlgorithm();
        
        Population population = new Population(100);
        population.Initialize();
        
        int generationCounter = 0;
        
        while(generationCounter<Constants.SIMULATION_LENGTH){
            ++generationCounter;
            System.out.println("generation :" + generationCounter +" - fittest is: "+ population.GetFittestIndividual().GetFitness());
            System.out.println(population.GetFittestIndividual()+"\n");
            population = GA.evolvePopulation(population);
        }
        System.out.println("Solution found!!");
        System.out.println(population.GetFittestIndividual());
    }
}
