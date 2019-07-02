package com.xjf.thinr.plugin.findclass;

import com.quinn.hunter.transform.asm.BaseWeaver;
import com.xjf.thinr.plugin.ScanSetting;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

/**
 * description: 寻找R.class
 *
 * @author xuejingfei
 * create at 19-7-2
 */
public class FindClassWeaver extends BaseWeaver {

    @Override
    protected ClassVisitor wrapClassWriter(ClassWriter classWriter) {
        return new FindTargetClassAdapter(Opcodes.ASM5,classWriter);
    }


    //找出
    @Override
    public boolean isWeavableClass(String fullQualifiedClassName) {
        return ScanSetting.isRClass(fullQualifiedClassName);
    }

}
