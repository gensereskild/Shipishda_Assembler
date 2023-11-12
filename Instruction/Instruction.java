package Instruction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Instruction {
    
    /**
     * The name of an instruction is its (lowercase) mnemonic, e.g. {@code xor} (exclusive-or) or {@code j} (jump).
     */
    public String name;
    
    /**
     * {@code arg1Type} is {@code null} if it is not supported by this instruction, {@code imm} if it
     * expects an immediate integer, {@code label} if it expects a label (an identifier), and {@code reg}
     * if it expects a register.
     */
    public String arg1Type;
    
    /**
     * {@code arg2Type} is {@code null} if it is not supported by this instruction, {@code imm} if it
     * expects an immediate integer, {@code label} if it expects a label (an identifier), and {@code reg}
     * if it expects a register.
     */
    public String arg2Type;
    
    /**
     * {@code arg3Type} is {@code null} if it is not supported by this instruction, {@code imm} if it
     * expects an immediate integer, {@code label} if it expects a label (an identifier), and {@code reg}
     * if it expects a register.
     */
    public String arg3Type;
    
    /**
     * The {@code rawInstructionBits} function assembles the raw bits that are readable by the CPU for a
     * given combination of instruction and arguments.
     * @param opcodeList A list containing all the CPU's available opcodes, in order, so that index = 0 corresponds
     * to the instruction with opcode 0.
     * @param arg1 The first argument. {@code null} if no such argument, an integer for either {@code reg} or
     * {@code imm} types, and the name of the label if a 
     * @param arg2
     * @param arg3
     * @return
     */
    public List<Integer> rawInstructionBits(
        List<Instruction> opcodeList, 
        String arg1, 
        String arg2, 
        String arg3, 
        HashMap<String, Integer> labelAddresses
    ) {
        
        final int indexInOpcodeList = opcodeList.indexOf(this);
        
        if (indexInOpcodeList == -1) {
            throw new IllegalStateException("Attempted to find raw instruction bits of unregistered instruction.");
        }
        
        // TODO: Verify that this matches the VM's and the physical computer's specifications.
        int opcode = indexInOpcodeList << 9;
        
        List<Integer> rawBits = new ArrayList<>();
        
        String[] args = new String[] {arg1, arg2, arg3};
        String[] argTypes = new String[] {arg1Type, arg2Type, arg3Type};
        
        for (int i = 0; i < 3; i++) {
            String arg = args[i];
            String type = argTypes[i];
            if (type == null) {
                continue;
            } else switch (type) {
                case "imm":
                    int value = Integer.valueOf(arg);
                    rawBits.add(value);
                    break;
                case "label":
                    
            }
        }
        
        rawBits.add(0, opcode);
        
        return rawBits;
        
    }
    
}
