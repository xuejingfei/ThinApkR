package com.xjf.thinr.plugin.deleteupdate;

import com.xjf.thinr.plugin.ScanSetting;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * description: 专家个人信息界面
 *
 * @author xuejingfei
 * create at 19-7-2
 */
public class DeleteUpdateAdapter extends ClassVisitor {
    private boolean isRClass = false;

    public DeleteUpdateAdapter(int api, ClassVisitor cv) {
        super(api, cv);
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        super.visit(version, access, name, signature, superName, interfaces);
        isRClass = ScanSetting.isRClass(name);
    }

    @Override
    public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
        if (isRClass && value instanceof Integer) {
            return null;
        }
        return super.visitField(access, name, desc, signature, value);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        MethodVisitor methodVisitor = super.visitMethod(access, name, desc, signature, exceptions);
        if(!isRClass) {
            return new UpdateClassAdapter(name,access,desc,methodVisitor);
        }
        return methodVisitor;
    }


}
