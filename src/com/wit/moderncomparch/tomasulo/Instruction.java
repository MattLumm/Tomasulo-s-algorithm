package com.wit.moderncomparch.tomasulo;
import java.util.Scanner;

public class Instruction {
	private String name;
	private String reg1;
	private String reg2;
	private String immediateReg3;
	private Boolean busyBit;
	private int executeLatencyCycle;
	private int issue;
	private int executionStart;
	private int writeResult;
	
	private String[] regArray;
	
	public Instruction(String n,String r1,String r2,String r3,Boolean bB){
		name=n;
		reg1=r1;
		reg2=r2;
		immediateReg3=r3;
		busyBit=bB;
		executeLatencyCycle=0;
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
     * Sets the BusyBit
     * @parameter Boolean of bit to either true or false
     * @return BusyBit is set to bit
     */
	public void setBusyBit(Boolean bit) {
		busyBit=bit;
		return;
	}
	/**
     * Set's theExecutionLatencyCycle
	 * @parameter int of the current cycle + latency of the instruction
	 * @set executeLatencyCycle set in the instruction
	 */
	public void setExecuteLatencyCycle(int Cycle){
		executeLatencyCycle=Cycle;
		return;
	}
	public int getExecuteLatencyCycle(){
		return executeLatencyCycle;
	}
	public void setIssue(int i){
	    issue=i;
	    return;
    }
    public void setExecutionStart(int es){
        executionStart=es;
        return;
    }
    public void setWriteResult(int wr){
	    writeResult=wr;
	    return;
    }
    public int getIssue(){
        return issue;
    }
    public int getExecutionStart(){
        return executionStart;
    }
    public int GetWriteResult(){
        return writeResult;
    }

	@Override
	public String toString() {
		if (name != null && reg1 != null && reg2 != null && immediateReg3 != null){
			return "   " + name + "     |  " + reg1 + "  |  " + reg2 + "  |  " + immediateReg3 + "  |   " + issue + "    |       " +
					executionStart + "          |        " + writeResult + "     |";
		} else {
			return "|               |      |      |      |        |               |             |";
		}
	}
}
