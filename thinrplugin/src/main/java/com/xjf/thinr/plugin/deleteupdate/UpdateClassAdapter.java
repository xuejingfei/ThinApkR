package com.xjf.thinr.plugin.deleteupdate;

import com.xjf.thinr.plugin.ScanSetting;
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
    public void visitFieldInsn(int opcode, String owner, String name, String desc) {
        String key = owner + name;
        Integer value = ScanSetting.mRClassMaps.get(key);
        if (value != null) {
            System.out.println("替换对R.class的直接引用：+" + owner  + name);
            super.visitLdcInsn(value);
        } else {
            super.visitFieldInsn(opcode, owner, name, desc);
        }
    }
}
