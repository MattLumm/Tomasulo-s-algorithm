package com.wit.moderncomparch.tomasulo;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    	
    	public Boolean[] registerBusyBits;

        /**
         * Gets input for latency and reservation station size from the user in order to make the program interactive
         * @return size - the size of the latency/reservation station
         */
    	public getInput() {
    		Scanner reader = new Scanner(System.in); 
    		System.out.println("Please enter latency/reservation station size: ");
    		int size = reader.nextInt();
    		return size;
    	}

    }
}
