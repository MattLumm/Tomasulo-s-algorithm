package com.wit.moderncomparch.tomasulo;

public class Issue {
    public static boolean queueToReservation(Instruction instruction) throws Exception {
        String instructionType = instruction.getName();
        switch (instructionType) {
            case "LDUR":
                return Main.loadBuffer.addInstruction(instruction);
                break;
            case "STUR":
                return Main.storeBuffer.addInstruction(instruction);
                break;
            case "ADDI":
                return Main.integerReservationStation.addInstruction(instruction);
                break;
            case "SUBI":
                return Main.integerReservationStation.addInstruction(instruction);
                break;
            case "FMULT":
                return Main.floatingPointMultiplicationReservationStation.addInstruction(instruction);
                break;
            default:
                throw new Exception("Unknown Instruction Type: " + instructionType);
                return false;
        }
    }
}
