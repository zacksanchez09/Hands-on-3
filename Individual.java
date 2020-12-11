/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handsonthree;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author zacksanchez
 */
public class Individual
{
    public static final int SIZE = 6;
    private int[] genes = new int[SIZE];
    // Equation to get the 30 value
    // a + 2b - 3c + d + 4e + f = 30
    private int Binary[] = {1, 2, -3, 1, 4, 1}; 
    private int fitnessValue;

    public Individual() 
    {}

    public int getFitnessValue() 
    {
        return fitnessValue;
    }

    public void setFitnessValue(int fitnessValue) 
    {
        this.fitnessValue = fitnessValue;
    }

    public int getGene(int index) 
    {
        return genes[index];
    }
    
    public void setGene(int index, int gene) 
    {
        this.genes[index] = gene;
    }
    
    public int evaluate() 
    {
        int fitness = 0;
        
        for(int i=0; i<SIZE; ++i) { 
            fitness += this.getGene(i) * Binary[i];
        }
        
        this.setFitnessValue(fitness);

        return fitness;
    }

    public void mutate() 
    {
        Random rand = new Random();
        
        int index = ThreadLocalRandom.current().nextInt(0, SIZE);
        
        this.setGene(index, Math.abs(1-this.getGene(index)));    // flip
    }
    
    public void randGenes() 
    {
        Random rand = new Random();
        
        for(int i=0; i<SIZE; ++i) {
            this.setGene(i, ThreadLocalRandom.current().nextInt(0, 9));
        }
    }
}
