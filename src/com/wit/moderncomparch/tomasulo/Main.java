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

    private static final Instruction[] instructions = {new Instruction("LDUR", "X6", "X2", "32", true)};

	public static void main(String[] args) {
		int latency = getLatency();
		int rs = getReservationStation();
		int cycles = getCycles();
		instructionQueue = new Buffer(instructions.length);
		storeBuffer = new Buffer(4);
		loadBuffer = new Buffer(4);
		integerReservationStation = new Buffer(rs);
		floatingPointMultiplicationReservationStation = new Buffer(rs);

		for (Instruction instruction:instructions){
			instructionQueue.addInstruction(instruction);
		}

		try {
			Issue.queueToReservation(instructions[0]);
		} catch (Exception e) {
			e.printStackTrace();
		}

	//	Issue.readOperands();
	//	Issue.renameDestination();

	//	Execute.checkLatency(latency);
	//	Execute.setData();
	//	Execute.getData();
	//	Execute.snoopCDB();
		Write.displayData(cycles);
		Write.writebackInstruction(instructions[0]);
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
