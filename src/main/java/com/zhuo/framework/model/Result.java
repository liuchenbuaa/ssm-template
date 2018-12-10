package com.zhuo.framework.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuchen <liuchen03@kuaishou.com>
 * Created on 2018-12-07
 */
public class Result {

    public static Map<String, Object> success() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("success", true);
        return map;
    }

    public static <T> Map<String, Object> successWithData(T data) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("success", true);
        map.put("result", data);
        return map;
    }
}
