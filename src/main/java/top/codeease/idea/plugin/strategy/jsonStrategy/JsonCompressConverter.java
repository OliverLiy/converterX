package top.codeease.idea.plugin.strategy.jsonStrategy;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @author by: ly
 * @ClassName: JsonCompressConverter
 * @Description: Json压缩
 * @Date: 2024/1/5 上午11:45
 */
public class JsonCompressConverter implements JsonConverterStrategy{
    @Override
    public String execute(String msg) {
        try {
            JSONObject jsonObject = JSON.parseObject(msg);
            // 序列化时开启压缩特性
            return JSON.toJSONString(jsonObject,SerializerFeature.WriteNonStringValueAsString);
        }catch (Exception exception){
            // 如果无法转换说明JSON有问题，不对该JSON串做处理
        }
        return msg;
    }
}
