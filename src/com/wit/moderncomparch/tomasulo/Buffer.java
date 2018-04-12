package com.wit.moderncomparch.tomasulo;

public class Buffer {
    private Instruction[] instructionBuffer;

    public Buffer(int bufferSize){
        instructionBuffer = new Instruction[bufferSize];
    }

    /**
     * adds an Instruction in the buffer if the buffer is not full
     * @param instruction
     * @return boolean - true if instruction added to buffer, false if buffer full
     */
    public boolean addInstruction(Instruction instruction){
        for (int i = 0; i < instructionBuffer.length; i++){
            if (instructionBuffer[i] != null){
                instructionBuffer[i] = instruction;
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
        if (instructionBuffer[index] != null){
            Instruction instruction = instructionBuffer[index];
            instructionBuffer[index] = null;
            return instruction;
        } else {
            return null;
        }
    }

    /**
     * Check if buffer is full
     * @return true if full, false otherwise
     */
    public boolean checkBuffer(){
        for (Instruction instruction : instructionBuffer) {
            if (instruction == null) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns all the instructions in the buffer
     * @return array of instructions in buffer
     */
    public Instruction[] getAllInstructions(){
        return instructionBuffer;
    }
}
