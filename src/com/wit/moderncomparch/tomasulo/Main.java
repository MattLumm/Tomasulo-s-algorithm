package com.wit.moderncomparch.tomasulo;
import java.util.Scanner;

public class Main {

    static Scanner reader = new Scanner(System.in);
    public Boolean[] registerBusyBits;

    public static Buffer instructionQueue;
    public static Buffer storeBuffer;
    public static Buffer loadBuffer;
    public static Buffer integerReservationStation;
    public static Buffer floatingPointMultiplicationReservationStation;

	public static void main(String[] args) {
		getLatency();
		getReservationStation();
		getCycles();

		Instruction inst = new Instruction("LDUR", "X6", "X2", "32", true);
		try {
			Issue.queueToReservation(inst);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Execute.dfjdf();
		Write.displayData();
		//Write.writebackInstruction();

	}

	/**
	 * Gets input for latency size from the user in order to make the program interactive
	 * @return size - the size of the latency
	 */
	public static int getCycles() {
		System.out.println("Please enter the number of cycles desired: ");
		int cycles = reader.nextInt();
		return cycles;
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
