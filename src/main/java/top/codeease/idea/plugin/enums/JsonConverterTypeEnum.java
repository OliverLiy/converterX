package top.codeease.idea.plugin.enums;

import top.codeease.idea.plugin.strategy.jsonStrategy.*;
import top.codeease.idea.plugin.strategy.stringStrategy.StringConverterStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by: ly
 * @ClassName: JsonConverterTypeEnum
 * @Description:
 * @Date: 2024/1/5 上午11:31
 */
public enum JsonConverterTypeEnum {
    /**
     * JSON格式化
     */
    JSON_FORMAT("JSON_FORMAT", JsonFormatConverter.class),
    JSON_COMPRESS("JSON_COMPRESS", JsonCompressConverter.class),
    JSON_REMOVE_ESCAPING("REMOVE_ESCAPING", JsonRemoveEscapingConverter.class),
    JSON_ADD_ESCAPING("ADD_ESCAPING", JsonAddEscapingConverter.class)
    ;
    private String typeName;
    private Class<? extends JsonConverterStrategy> strategyClass;

    JsonConverterTypeEnum(String typeName, Class<? extends JsonConverterStrategy> strategyClass){
        this.typeName = typeName;
        this.strategyClass = strategyClass;
    }

    public String getTypeName() {
        return typeName;
    }

    public Class<? extends JsonConverterStrategy> getStrategyClass() {
        return strategyClass;
    }

    /**
     * 获取全部的转换功能
     * @return
     */
    public static List<String> getTypeNameList(){
        List<String> typeNameList = new ArrayList<>();
        for (JsonConverterTypeEnum value : JsonConverterTypeEnum.values()) {
            typeNameList.add(value.getTypeName());
        }
        return typeNameList;
    }

    /**
     * 通过类型名称获取实例对象
     * @param typeName
     * @return
     */
    public static JsonConverterStrategy getStrategyInstance(String typeName){
        for (JsonConverterTypeEnum value : JsonConverterTypeEnum.values()) {
            if (value.getTypeName().equals(typeName)){
                try {
                    Class<? extends JsonConverterStrategy> strategyClass = value.getStrategyClass();
                    return strategyClass.getDeclaredConstructor().newInstance();
                }catch (Exception exception){
                    exception.printStackTrace();
                }

            }
        }
        return null;
    }
}
