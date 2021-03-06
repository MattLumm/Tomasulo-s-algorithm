package com.wit.moderncomparch.tomasulo;

public class ExecuteUnit{
    private Instruction executingInstruction;
    private int endCycle;
    private boolean busyBit;
    public ExecuteUnit(){
        executingInstruction= new Instruction("LDUR", "X1", "X0", "0", true);
        endCycle=0;
        busyBit=false;
    }
    public ExecuteUnit(Instruction inst, int eCycle){
        executingInstruction=inst;
        endCycle=eCycle;
        busyBit=false;
    }
    /**
     * Adds the instruction to the ExecutionUnit
     * additionally marks the busy bit and the endCycle of it's execution
     * then removes the instruction from the ReservationQueue
     * @return True if the Instruction is added properly
     */
    public boolean addInstruction(Instruction instruction, int eCycle){
        if (busyBit==false){
            executingInstruction=instruction;
            endCycle=eCycle;
            busyBit=true;


            return true;
        }
        return false;
    }
    /**
     * Checks if execution is done for the instruction
     * @return True if the Instruction is finished executeing
     */
    public boolean checkExecute(int currentCycle) {
        if (currentCycle >= endCycle) {
            busyBit = false;
            if(executingInstruction.getWriteResult()==0) {
                executingInstruction.setWriteResult(currentCycle);
            }
            return true;
        }
        return false;
    }
    /**
     * returns executing Instruciton
     *
     */
    public Instruction getExecutingInstruction(){
        return executingInstruction;
    }
}
