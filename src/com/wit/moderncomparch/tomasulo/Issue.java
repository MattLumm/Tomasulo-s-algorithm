package com.wit.moderncomparch.tomasulo;

public class Issue {
    public static boolean queueToReservation(Instruction instruction) throws Exception {
        String instructionType = instruction.getName();
        switch (instructionType) {
            case "LDUR":
                return Main.loadBuffer.addInstruction(instruction);
            case "STUR":
                return Main.storeBuffer.addInstruction(instruction);
            case "ADDI":
            case "SUBI":
                return Main.integerReservationStation.addInstruction(instruction);
            case "FADD":
            case "FSUB":
                return Main.floatingPointAdditionReservationStation.addInstruction(instruction);
            case "FMULT":
            case "FDIV":
                return Main.floatingPointMultiplicationReservationStation.addInstruction(instruction);
            default:
                throw new Exception("Unknown Instruction Type: " + instructionType);
        }
    }
}
