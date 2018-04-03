package com.wit.moderncomparch.tomasulo;
import java.util.Scanner;

public class Main {

    static Scanner reader = new Scanner(System.in);
    public Boolean[] registerBusyBits;

	public static void main(String[] args) {
        int latency, rs;
		getLatency();
		getReservationStation();
	}

		/**
         * Gets input for latency size from the user in order to make the program interactive
         * @return size - the size of the latency
         */
    	public static int getLatency() {
    		System.out.println("Please enter latency size: ");
    		int latency_size = reader.nextInt();
    		return latency_size;
    	}

	/**
	 * Gets input for reservation station size from the user in order to make the program interactive
	 * @return size - the size of the reservation station
	 */
		public static int getReservationStation() {
			Scanner reader = new Scanner(System.in);
			System.out.println("Please enter reservation station size: ");
			int rs_size = reader.nextInt();
			return rs_size;
		}

    }
