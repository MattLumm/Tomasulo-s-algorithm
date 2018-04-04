package com.wit.moderncomparch.tomasulo;
import java.util.Scanner;

public class Instruction {
	private String name;
	private String reg1;
	private String reg2;
	private String immediateReg3;
	private Boolean busyBit;
	
	private Instruction[] regArray;
	
	public Instruction(String n,String r1,String r2,String r3,Boolean bB){
		name=n;
		reg1=r1;
		reg2=r2;
		immediateReg3=r3;
		busyBit=bB;
    }
	
	/**
     * Gets Name of the Instruction
     * @return name - Name of the Instruction
     */
	public String getName(){
		return name;
	}
	/**
     * Gets an Array of the Registers of the Instruction
     * @return regArray - Array of the Registers of the Instruction
     */
	public String[] getRegs(){
		regArray = new String[3];
		regArray[0]=reg1;
		regArray[1]=reg2;
		regArray[2]=immediateReg3;
		return regArray;
	}
	/**
     * Gets busyBit of the Instruction
     * @return busyBit - busyBit of the Instruction
     */
	public Boolean getBusyBit() {
		return busyBit;
	}
	/**
     * Gets Name of the Instruction
     * @param Boolean of bit to either true or false
     * @return BusyBit is set to bit 
     */
	public null setBusyBit(Boolean bit) {
		busyBit=bit;
		return null;
	}
}
