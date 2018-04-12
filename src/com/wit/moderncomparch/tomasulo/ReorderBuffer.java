package com.wit.moderncomparch.tomasulo;

public class ReorderBuffer extends Buffer {
    protected double[] results;

    public ReorderBuffer(int bufferSize) {
        super(bufferSize);
        results = new double[instructionBuffer.length];
    }

    /**
     * adds an Instruction in the buffer if the buffer is not full
     * @param instruction
     * @return boolean - true if instruction added to buffer, false if buffer full
     */
    public boolean addInstruction(Instruction instruction, double result){
        for (int i = 0; i < instructionBuffer.length; i++){
            if (instructionBuffer[i] == null){
                instructionBuffer[i] = instruction;
                results[i] = result;
                return true;
            }
        }
        return false;
    }

    /**
     * removes an instruction from the buffer and returns it
     * @return removed Instruction
     */
    public Instruction removeInstruction(){
        for (int i = 0; i < instructionBuffer.length; i++){
            if (instructionBuffer[i] != null){
                Instruction instruction = instructionBuffer[i];
                results[i] = 0.0;
                instructionBuffer[i] = null;
                return instruction;
            }
        }
        return null;
    }

    /**
     * removes an instruction from the buffer and returns it
     * @param index of instruction to remove
     * @return removed Instruction
     */
    public Instruction removeInstruction(int index){
        Instruction removedInstruction = super.removeInstruction(index);
        if (removedInstruction != null){
            results[index] = 0.0;
        }
        return removedInstruction;
    }

    /**
     * removes an instruction from the buffer and returns the result
     * @return calculated result of removed instruction
     */
    public Double removeInstructionAndReturnResult(){
        for (int i = 0; i < instructionBuffer.length; i++){
            if (instructionBuffer[i] != null){
                double result = results[i];
                results[i] = 0.0;
                instructionBuffer[i] = null;
                return result;
            }
        }
        return 0.0;
    }

    /**
     * removes an instruction from the buffer and returns the result
     * @param index of instruction to remove
     * @return calculated result of removed Instruction
     */
    public double removeInstructionAndReturnResult(int index){
        if (instructionBuffer[index] != null){
            double result = results[index];
            results[index] = 0.0;
            instructionBuffer[index] = null;
            return result;
        } else {
            return 0.0;
        }
    }

    /**
     * Returns all the results in the buffer
     * @return array of results in buffer
     */
    public double[] getAllResults(){
        return results;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < instructionBuffer.length; i++){
            output.append(instructionBuffer[i].toString()).append(" | ").append(results[i]).append(" |/n");
        }
        return output.toString();
    }
}
