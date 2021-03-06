package com.wit.moderncomparch.tomasulo;
import java.util.Scanner;

public class Main {



    static Scanner reader = new Scanner(System.in);
    public static Boolean[] registerBusyBits;
    public static Buffer instructionQueue;
    public static Buffer storeBuffer;
    public static Buffer loadBuffer;
    public static Buffer integerReservationStation;
    public static Buffer floatingPointAdditionReservationStation;
    public static Buffer floatingPointMultiplicationReservationStation;
    public static ReorderBuffer reorderBuffer;
	public static ExecuteUnit memoryUnit;
	public static ExecuteUnit fPadderUnit;
	public static ExecuteUnit fPmultiplierUnit;



    private static final Instruction[] instructions = {
    		new Instruction("LDUR", "X6", "X2", "32", true),
			new Instruction("LDUR", "X2", "X3", "44", true),
			new Instruction("FMULT", "X0", "X4", "X2", true),
			new Instruction("FSUB", "X8", "X2", "X6", true),
			new Instruction("FDIV", "X10", "X6", "X0", true),
			new Instruction("FADD", "X6", "X2", "X8", true)};

	public static void main(String[] args) {
		int currentCycle=0;
		int latency = getLatency();
		int rs = getReservationStation();
		int cycles = getCycles();
		instructionQueue = new Buffer(instructions.length);
		storeBuffer = new Buffer(4);
		loadBuffer = new Buffer(4);
		integerReservationStation = new Buffer(rs);
		floatingPointAdditionReservationStation = new Buffer(rs);
		floatingPointMultiplicationReservationStation = new Buffer(rs);
		reorderBuffer = new ReorderBuffer(4);
		memoryUnit = new ExecuteUnit();
		fPadderUnit = new ExecuteUnit();
		fPmultiplierUnit = new ExecuteUnit();
        Boolean[] registerBusyBits = new Boolean[20];
        for(int i=0; registerBusyBits.length>i;i++){
            registerBusyBits[i]=false;
        }

		for (Instruction instruction:instructions){
			instructionQueue.addInstruction(instruction);
		}
		for(currentCycle=0;currentCycle<cycles;currentCycle++) {
			try {
				if(currentCycle<instructions.length) {
					Issue.queueToReservation(instructions[currentCycle]);
					instructions[currentCycle].setIssue(currentCycle);
					flipRegisterBusyBit(instructions[currentCycle].getRegs()[0], registerBusyBits);
				}
				try {
					if(currentCycle<instructions.length) {
						if (CheckRegisters(instructions[currentCycle], registerBusyBits)) {
							Execute.execute(instructions[currentCycle], latency, currentCycle);
						}
					}
					if (memoryUnit.checkExecute(currentCycle)) {
						flipRegisterBusyBit(memoryUnit.getExecutingInstruction().getRegs()[0], registerBusyBits);
					}
					if (fPadderUnit.checkExecute(currentCycle)) {
						flipRegisterBusyBit(fPadderUnit.getExecutingInstruction().getRegs()[0], registerBusyBits);
					}
					if (fPmultiplierUnit.checkExecute(currentCycle)) {
						flipRegisterBusyBit(fPmultiplierUnit.getExecutingInstruction().getRegs()[0], registerBusyBits);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		Write.displayData(instructions, cycles, storeBuffer, loadBuffer, integerReservationStation, floatingPointAdditionReservationStation, floatingPointMultiplicationReservationStation, registerBusyBits);
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
    /**
     * Takes a Register String from an Instruction and flips it's position in the ResiterBusyBits to either true or false
     *
     */
		public static void flipRegisterBusyBit(String register, Boolean[] registerBusyBits){
            int registerIndex=RegisterToInt(register);
            if(registerBusyBits[registerIndex]== true) {
                registerBusyBits[registerIndex] = false;
            }
            else{
                registerBusyBits[registerIndex] = true;
            }
            return;
        }
    /**
     * Takes a Register String from an Instruction and converts it to a number
     *
     */
        public static int RegisterToInt(String register){
            int registerIndex=0;
            register=register.substring(1,register.length());
            registerIndex= Integer.parseInt(register);
            return registerIndex;
        }
    /**
     * Takes the 2nd and 3rd Register String from an Instruction and checks if they're not Busy
     *
     */
        public static boolean CheckRegisters(Instruction instruction, Boolean[]registerBusyBits){
            if(registerBusyBits[RegisterToInt(instruction.getRegs()[1])]==false){
                if(registerBusyBits[RegisterToInt(instruction.getRegs()[2])]==false){
                    return true;
                }
            }
            return false;
        }
    }
