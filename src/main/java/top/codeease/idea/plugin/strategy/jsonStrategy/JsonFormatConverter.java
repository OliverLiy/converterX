package top.codeease.idea.plugin.strategy.jsonStrategy;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @author by: ly
 * @ClassName: JsonFormatConverter
 * @Description:
 * @Date: 2024/1/5 上午11:35
 */
public class JsonFormatConverter implements JsonConverterStrategy{
    @Override
    public String execute(String msg) {
        try {
            Object jsonObject = JSON.parse(msg);
            return JSON.toJSONString(jsonObject, true);
        }catch (Exception exception){
            // 如果无法转换说明JSON有问题，不对该JSON串做处理
        }
        return msg;
    }
}
