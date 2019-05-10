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
public class Population {
    private Individual[] individuals;
    public Population(int poplationSize){
        this.individuals = new Individual[poplationSize];
    }
    public void Initialize(){
        for(int i =0;i<individuals.length;++i){
            Individual newI = new Individual();
            newI.GenerateRandomIndividual();
            saveIndividual(i,newI);
        }
    }
    
    public Individual GetIndividual(int idx){
        return this.individuals[idx];
    }
    public Individual GetFittestIndividual(){
        Individual fittest = individuals[0];
        for(int i =1;i<individuals.length;++i){
            if(GetIndividual(i).GetFitness()<fittest.GetFitness()){
                fittest = individuals[i];
            }
        }
        return fittest;
    }
    public int size(){
        return this.individuals.length;
    }
    public void saveIndividual(int idx, Individual i){
        individuals[idx] = i;
    }
}
