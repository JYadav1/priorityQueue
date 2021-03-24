/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programmingassignmentpq;

/**
 *
 * @author Jay Yadav
 */
import java.util.*;

public class ProgrammingAssignmentPQ {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PriorityQueue priorityQueue = new PriorityQueue();
        Random rand = new Random();
        int getServed = 0;
        int intQueue = 0;
        int max_length = 0; // variable for the max line length 
        // private int intServed = 0;
        //private int intQueued = 0;

        for (int time = 0; time < 60; time++) {
            int randN = rand.nextInt(4) + 1; // generates a random number from 1-4
            // create an if statment to add the customer 25% of the time
            if (randN == 4) {
                priorityQueue.addCustomer(new PriorityCustomer()); // crate a new cusmtome in the queue
                System.out.println(" New Customer added! The Queue length is now " + priorityQueue.getSize());
                intQueue++;

            }

            // if statmenet dequeues if the length is greater than 0 and service time greater than 0
            if (priorityQueue.getSize() > 0 && priorityQueue.getFirst().getServiceTime() == 0) {
                priorityQueue.remove();
                System.out.println(" Customer has been completely serviced and removed " + priorityQueue.getSize());
                getServed++;
            }

            System.out.println("---------------------------------------------------");

            if(priorityQueue.getFirst() == null) {
                System.out.println(" The Queue is Empty");
            }
            
            if (priorityQueue.getSize() > 0) {
                priorityQueue.getFirst().decServiceTime();
            }
            // checks the queue in order to get the max length of the queue at a given time 
            if (priorityQueue.getSize() > max_length) {
                max_length = priorityQueue.getSize();
            }
        }
        System.out.println(" Number of customers served is " + getServed);
        System.out.println(" Maximum line length during the simulation " + max_length);

    }
}
