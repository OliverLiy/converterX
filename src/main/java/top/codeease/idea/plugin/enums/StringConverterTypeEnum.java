package top.codeease.idea.plugin.enums;

import top.codeease.idea.plugin.strategy.stringStrategy.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by: ly
 * @ClassName: StringFormatTypeEnum
 * @Description: String转换类枚举
 * @Date: 2023/12/21 上午11:47
 */
public enum StringConverterTypeEnum {
    /**
     * 转大写
     */
    UPPER("Upper (CODEEASE)", UpperStringConverter.class),
    /**
     * 转小写
     */
    LOWER("Lower (codeease)", LowerStringConverter.class),
    /**
     * 转驼峰命名
     */
    CAMEL_CASE("Camel (codeEase)", CamelCaseStringConverter.class),
    /**
     * 类名驼峰
     */
    CLASS_CAMEL_CASE("ClassCamel (CodeEase)", ClassCamelStringConverter.class),
    /**
     * 转下划线大写
     */
    TO_UNDERLINE_UPPER("UnderlineUpper (CODE_EASE)", UnderlineUpperStringConverter.class),
    /**
     * 转下划线小写
     */
    TO_UNDERLINE_LOWER("UnderlineLower (code_ease)", UnderlineLowerStringConverter.class)



    ;
    private String typeName;
    private Class<? extends StringConverterStrategy> strategyClass;

    StringConverterTypeEnum(String typeName, Class<? extends StringConverterStrategy> strategyClass){
        this.typeName = typeName;
        this.strategyClass = strategyClass;
    }

    public String getTypeName() {
        return typeName;
    }

    public Class<? extends StringConverterStrategy> getStrategyClass() {
        return strategyClass;
    }

    /**
     * 获取全部的转换功能
     * @return
     */
    public static List<String> getTypeNameList(){
        List<String> typeNameList = new ArrayList<>();
        for (StringConverterTypeEnum value : StringConverterTypeEnum.values()) {
            typeNameList.add(value.getTypeName());
        }
        return typeNameList;
    }

    /**
     * 通过类型名称获取实例对象
     * @param typeName
     * @return
     */
    public static StringConverterStrategy getStrategyInstance(String typeName){
        for (StringConverterTypeEnum value : StringConverterTypeEnum.values()) {
            if (value.getTypeName().equals(typeName)){
                try {
                    Class<? extends StringConverterStrategy> strategyClass = value.getStrategyClass();
                    return strategyClass.getDeclaredConstructor().newInstance();
                }catch (Exception exception){
                    exception.printStackTrace();
                }

            }
        }
        return null;
    }

}
