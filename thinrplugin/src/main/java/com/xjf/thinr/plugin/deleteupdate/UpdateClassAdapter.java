package com.xjf.thinr.plugin.deleteupdate;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.commons.LocalVariablesSorter;

/**
 * description: 专家个人信息界面
 *
 * @author xuejingfei
 * create at 19-7-2
 */
public class UpdateClassAdapter extends LocalVariablesSorter implements Opcodes {

    public UpdateClassAdapter(String name, int access, String desc,MethodVisitor mv) {
        super(Opcodes.ASM5,access,desc, mv);
    }

    @Override
    public void visitIntInsn(int opcode, int operand) {
        super.visitIntInsn(opcode, operand);
    }

}
