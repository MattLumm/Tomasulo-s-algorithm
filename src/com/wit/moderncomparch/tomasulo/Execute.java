package com.wit.moderncomparch.tomasulo;
import java.util.Scanner;

public class Execute {

	/**
	 * Sets the End of execution cycle of the Instruction
	 * @return True if the Instruction is added properly
	 */
	public static boolean execute(Instruction instruction, int latency, int currentCycles) throws Exception {
		int endCycle=latency+currentCycles;
		instruction.setExecuteLatencyCycle(endCycle);
		String instructionType = instruction.getName();
		switch (instructionType) {
			case "LDUR":
				if(Main.memoryUnit.addInstruction(instruction,endCycle)){
					Main.loadBuffer.removeInstruction();
					return true;
				}
			case "STUR":
				if(Main.memoryUnit.addInstruction(instruction,endCycle)){
					Main.storeBuffer.removeInstruction();
					return true;
				}
			case "ADDI":
			case "SUBI":
				if(Main.fPadderUnit.addInstruction(instruction,endCycle)){
					Main.integerReservationStation.removeInstruction();
					return true;
				}
			case "FADD":
			case "FSUB":
				if(Main.fPadderUnit.addInstruction(instruction,endCycle)){
					Main.floatingPointAdditionReservationStation.removeInstruction();
					return true;
				}
			case "FMULT":
			case "FDIV":
				if(Main.fPmultiplierUnit.addInstruction(instruction,endCycle)){
					Main.floatingPointMultiplicationReservationStation.removeInstruction();
					return true;
				}
			default:
				throw new Exception("Unknown Instruction Type: " + instructionType);
		}

	}
}
