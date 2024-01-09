package top.codeease.idea.plugin.enums;


import top.codeease.idea.plugin.strategy.dateStrategy.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by: ly
 * @ClassName: DateConverterTypeEnum
 * @Description: 日期转换枚举类
 * @Date: 2023/12/28 上午11:24
 */
public enum DateConverterTypeEnum {
    /**
     * 获取当前时间
     */
    NOW("NOW (yyyy-MM-dd HH:mm:ss)", NowDateTimeConverter.class),
    TO_DATE_TIME_1("TO_DATE_TIME (yyyy-MM-dd HH:mm:ss)", ToDateTimeOneConverter.class),
    TO_DATE_TIME_2("TO_DATE_TIME (yyyy/MM/dd HH:mm:ss)", ToDateTimeTwoConverter.class),
    TO_DATE("TO_DATE (yyyy/MM/dd)", ToDateConverter.class),
    TO_TIME("TO_TIME (HH:mm:ss)",ToTimeConverter.class),
    TO_TIMESTAMP_SECOND_CONVERTER("TO_TIMESTAMP (Second)", ToTimeStampSecondConverter.class),
    TO_TIMESTAMP_MILLI_SECOND_CONVERTER("TO_TIMESTAMP (MilliSecond)",ToTimeStampMilliConverter.class),
    ;
    private String typeName;
    private Class<? extends DateConverterStrategy> strategyClass;

    DateConverterTypeEnum(String typeName,Class<? extends DateConverterStrategy> strategyClass){
        this.typeName = typeName;
        this.strategyClass = strategyClass;
    }

    public String getTypeName() {
        return typeName;
    }

    public Class<? extends DateConverterStrategy> getStrategyClass() {
        return strategyClass;
    }

    /**
     * 获取全部的转换功能
     * @return
     */
    public static List<String> getTypeNameList(){
        List<String> typeNameList = new ArrayList<>();
        for (DateConverterTypeEnum value : DateConverterTypeEnum.values()) {
            typeNameList.add(value.getTypeName());
        }
        return typeNameList;
    }

    /**
     * 通过类型名称获取实例对象
     * @param typeName
     * @return
     */
    public static DateConverterStrategy getStrategyInstance(String typeName){
        for (DateConverterTypeEnum value : DateConverterTypeEnum.values()) {
            if (value.getTypeName().equals(typeName)){
                try {
                    Class<? extends DateConverterStrategy> strategyClass = value.getStrategyClass();
                    return strategyClass.getDeclaredConstructor().newInstance();
                }catch (Exception exception){
                    exception.printStackTrace();
                }

            }
        }
        return null;
    }
}
