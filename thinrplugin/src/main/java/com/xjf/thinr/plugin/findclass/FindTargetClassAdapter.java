package com.xjf.thinr.plugin.findclass;

import com.xjf.thinr.plugin.ScanSetting;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;

/**
 * description: 寻找目标类
 *
 * @author xuejingfei
 * create at 19-7-2
 */
public class FindTargetClassAdapter extends ClassVisitor {
    private String mClassName;

    public FindTargetClassAdapter(int api, ClassVisitor cv) {
        super(api, cv);
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        super.visit(version, access, name, signature, superName, interfaces);
        mClassName = name;

    }

    @Override
    public void visitInnerClass(String name, String outerName, String innerName, int access) {
        super.visitInnerClass(name, outerName, innerName, access);
    }

    @Override
    public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
        if(value instanceof Integer) {
//            System.out.println("key:" + mClassName + name + "------>" +value);
            ScanSetting.mRClassMaps.put(mClassName + name,(Integer) value);
        }
        return super.visitField(access, name, desc, signature, value);
    }
}
