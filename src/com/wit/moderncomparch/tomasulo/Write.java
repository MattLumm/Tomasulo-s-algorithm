package com.wit.moderncomparch.tomasulo;

public class Write {
    public static void displayData(Instruction[] inst, int cycles, Buffer buff) {
        //Instruction table

        for(int i = 0; i <= (cycles - 1); i++){
            buff.getAllInstructions();

            System.out.println("Cycle " + (i + 1));
            System.out.println("+-----------------+------+------+------+--------+------------------+--------------+");
            System.out.println("| Instruction     |      | Rs1  | Rs2  | Issue  | Execution Starts | Write Result |");
            System.out.println("+-----------------+------+------+------+--------+------------------+--------------+");
            for (int j = 0; j < 6; j++) {
                System.out.println("|          |");
            }
            System.out.println("+-----------------+------+------+------+--------+------------------+--------------+");
            System.out.println();

            //Load Buffer table
            System.out.println("+--------------+--------+-----------+");
            System.out.println("| Load Buffers |  Busy  |  Address  |");
            System.out.println("+--------------+--------+-----------+");
            for (int j = 0; j < 3; j++) {
                System.out.println("| Load Buffers |  Busy  |  Address  |");
            }
            System.out.println("+--------------+--------+-----------+");
            System.out.println();

            //Reservation Station table
            System.out.println("Reservation Stations");
            System.out.println("+-------+--------+-------+-------+-----------------+-----------------+-------------------+-------------------+");
            System.out.println("| Time  |  Name  |  Busy |   Op  | S1 Value of Rs1 | S2 Value of Rs2 | RS for RS1 Source | RS for Rs2 Source |");
            System.out.println("+-------+--------+-------+-------+-----------------+-----------------+-------------------+-------------------+");
            for (int j = 0; j < 5; j++) {
                System.out.println("| Time  |  Name  |  Busy |   Op  | S1 Value of Rs1 | S2 Value of Rs2 | RS for RS1 Source | RS for Rs2 Source |");
            }
            System.out.println("+-------+--------+-------+-------+-----------------+-----------------+-------------------+-------------------+");
            System.out.println();

            //Register Result Status
            System.out.println("Register Result Status");
            System.out.println("+--------+----+------+----------+----------+----------+----------+------+-------+");
            System.out.println("| Clock  |    |  X0  |    X2    |    X4    |    X6    |    X8    |  X10 |  X12  |");
            System.out.println("+--------+----+------+----------+----------+----------+----------+------+-------+");
            System.out.println("| Clock  | FU |  X0  |    X2    |    X4    |    X6    |    X8    |  X10 |  X12  |");
            System.out.println("+--------+----+------+----------+----------+----------+----------+------+-------+");
            System.out.println();

        }
    }


    public static void writebackInstruction(Instruction inst) {
        //adds instruction to writeback buffer
        inst.getName();
        inst.getRegs();
        //sets current instruction busy bit to false
        inst.setBusyBit(false);
    }
}