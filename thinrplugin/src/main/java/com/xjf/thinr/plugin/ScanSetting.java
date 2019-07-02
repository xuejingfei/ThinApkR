package com.xjf.thinr.plugin;


import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * description: 存储扫描
 *
 * @author xuejingfei
 * create at 19-7-2
 */
public class ScanSetting {
    public static Map<String, Integer> mRClassMaps = new HashMap<>();
    private static final String REGEX_R_CLASS = ".*R\\$.*\\.class|.*R\\.class";



    /**
     * 判断该 class 文件是否是 R.class 类，及其内部类如 R$id.class，但是 R$styleable.class 类排除在外
     *
     * @param classFilePath
     * @return
     */
    public static boolean isRClass(String classFilePath) {
        return Pattern.matches(REGEX_R_CLASS, classFilePath);
    }



    
}
