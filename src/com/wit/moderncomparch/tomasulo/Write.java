package com.wit.moderncomparch.tomasulo;

public class Write {

    /**
     * Displays data into tables
     */
    public static void displayData(Instruction[] inst, int cycles, Buffer storeBuffer, Buffer loadBuffer, Buffer integerReservationStation, Buffer floatingPointAdditionReservationStation, Buffer floatingPointMultiplicationReservationStation, Boolean[] bB) {
        //Instruction table
        for(int i = 0; i <= (cycles - 1); i++){
            ReorderBuffer reBuff = new ReorderBuffer(4);
            printBuffer(loadBuffer,i,"load");
            printBuffer(storeBuffer,i,"store");

            printBuffer(integerReservationStation,i,"integer");
            printBuffer(floatingPointAdditionReservationStation,i,"FP ADD");
            printBuffer(floatingPointMultiplicationReservationStation,i,"FP Mult");

            /**
            //Load Buffer table
            System.out.println("+--------------+--------+-----------+");
            System.out.println("| Load Buffers |  Busy  |  Address  |");
            System.out.println("+--------------+--------+-----------+");
            for (int j = 0; j < 3; j++) {
                System.out.println("|   " + reBuff.getAllInstructions()[i] + " | " + reBuff.getAllResults()[i] + "   |");
            }
            System.out.println("+--------------+--------+-----------+");
            System.out.println();
             */

            //Register Result Status
            System.out.println("Register Result Status");
            System.out.println("+--------+----+------+----------+----------+----------+----------+----------+-----------+");
            System.out.println("| Clock  |    |  X0  |    X2    |    X4    |    X6    |    X8    |    X10   |    X12    |");
            System.out.println("+--------+----+------+----------+----------+----------+----------+----------+-----------+");
            System.out.println("|   "+ (i+1) + "    | FU |"+bB[0]+" |"+"|  "+bB[2]+"  |"+"|  "+bB[4]+"  |"+"|  "+bB[6]+"  |"+"|  "+bB[8]+"  |"+"|  "+bB[10]+"  |"+"|  "+bB[12]+"  |");
            System.out.println("+--------+----+------+----------+----------+----------+----------+----------+-----------+");
            System.out.println();

        }
    }

    /**
     * Adds the instruction to the Writeback buffer
     * set instruction busy bit to false
     * @param inst instruction to add to writeback buffer
     */
    public static void writebackInstruction(Instruction inst) {
        //adds instruction to writeback buffer
        inst.getName();
        inst.getRegs();
        //sets current instruction busy bit to false
        inst.setBusyBit(false);
    }
    public static void printBuffer(Buffer buff,int i, String name){
        System.out.println("Buffer "+name);
        System.out.println("Cycle " + (i + 1));
        System.out.println("+-----------------+------+------+------+--------+------------------+--------------+");
        System.out.println("| Instruction     |      | Rs1  | Rs2  | Issue  | Execution Starts | Write Result |");
        System.out.println("+-----------------+------+------+------+--------+------------------+--------------+");
        if(buff!=null) {
            for (int j = 0; j < buff.getAllInstructions().length - 1; j++) {
                if (buff.getAllInstructions()[j] != null) {
                    System.out.println("|     " + buff.getAllInstructions()[j].toString());
                }
            }
        }
        else
            System.out.println("Empty");
        System.out.println("+-----------------+------+------+------+--------+------------------+--------------+");
        System.out.println();
    }
}