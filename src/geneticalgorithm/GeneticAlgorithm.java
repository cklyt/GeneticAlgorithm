/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticalgorithm;

import java.util.Random;

/**
 *
 * @author louis
 */
public class GeneticAlgorithm {

    public Random randomGenerator;

    public Random getRandomGenerator() {
        return randomGenerator;
    }

    public GeneticAlgorithm(){
        this.randomGenerator = new Random();
    }
    
    public Population evolvePopulation(Population population){
        Population newPopulation = new Population(population.size());
        
        for(int i =0;i<population.size();++i){
            Individual firstIndividual = RandomSelection(population);
            Individual secondIndividual = RandomSelection(population);
            Individual newIndividual = CrossOver(firstIndividual,secondIndividual);
            newPopulation.saveIndividual(i, newIndividual);
        }
        
        for(int i =0;i<newPopulation.size();++i){
            Mutate(newPopulation.GetIndividual(i));
        }
        
        return newPopulation;
    }
    
    private void Mutate(Individual individual){
        for(int i =0;i<Constants.CHROMOSOME_LENGTH;++i){
            if(Math.random()<=Constants.MUTATION_RATE){
                int gene = randomGenerator.nextInt(2);
                individual.SetGene(i, gene);
            }
        }
    }
    
    private Individual RandomSelection(Population p){
        Population newPopulation = new Population(Constants.TOURNAMENT_SIZE);
        
        for(int i =0;i<Constants.TOURNAMENT_SIZE;++i){
            int randomIndex = (int)(Math.random()*p.size());
            newPopulation.saveIndividual(i, p.GetIndividual(randomIndex));
        }
        return newPopulation.GetFittestIndividual();
    }
    private  Individual CrossOver(Individual first, Individual second){
        Individual newSolution = new Individual();
        for(int i =0;i<Constants.CHROMOSOME_LENGTH;++i){
            if(Math.random()<=Constants.CROSSOVER_RATE){
                newSolution.SetGene(i, first.GetGene(i));
            }else{
                newSolution.SetGene(i, second.GetGene(i));
            }
        }
        return newSolution;
    }
    
}
