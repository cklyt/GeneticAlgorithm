/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticalgorithm;

import java.util.Random;

/**
 *
 * @author Aman
 */
public class Individual {
    private int[] genes;
    private int fitness;
    private Random randomGenerator;
    
    public Individual(){
        this.genes = new int[Constants.CHROMOSOME_LENGTH];
        randomGenerator = new Random();
        
    }
    
    public void GenerateRandomIndividual(){
        for(int i =0;i<Constants.CHROMOSOME_LENGTH;++i){
            genes[i] = randomGenerator.nextInt(2);
        }
    }
    public double f(double x){
        return Math.sin(x)*((x-2)*(x-2))+3;
    }
    public double genesToDoubles(){
        int base = 1;
        double geneInDouble =0;
        for(int i =0 ; i<Constants.GENE_LENGTH;++i){
            if(this.genes[i]==1){
                geneInDouble += base;
            }
            base = base *2;
        }
        
        geneInDouble = geneInDouble/102.4f;
        return geneInDouble;
    }
    public double GetFitness(){
//        if(fitness == 0){
//            for(int i =0;i <Constants.CHROMOSOME_LENGTH;++i){
//                if(GetGene(i)==Constants.SOLUTION_SEQUENCE[i]){
//                    this.fitness++;
//                }
//            }
//        } 
        double geneToDouble = genesToDoubles();
        return f(geneToDouble);
        //return fitness;
    }
    
    public int GetGene(int idx){
        return this.genes[idx];
    }
    
    public void SetGene(int idx, int value){
        this.genes[idx] = value;
        this.fitness = 0;
    }

    @Override
    public String toString() {
        String s = " ";
        
        for(int i =0;i<Constants.CHROMOSOME_LENGTH;++i){
            s+=GetGene(i);
        }
        return s;
    }
    
    
}
