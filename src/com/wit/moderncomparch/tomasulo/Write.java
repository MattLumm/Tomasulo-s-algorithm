package com.wit.moderncomparch.tomasulo;

public class Write {

    public void displayData( ){
        //Display data in tables
    }

    public void writebackInstruction() {
        //adds instruction to writeback buffer
        Instruction name = new Instruction();
        Instruction regs = new Instruction();
        name.getName();
        regs.getRegs();
        //sets current instruction busy bit to false
        registerBusyBit = false;
    }

}