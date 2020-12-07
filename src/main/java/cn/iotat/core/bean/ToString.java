package cn.iotat.core.bean;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

public class ToString implements Serializable {
    private static final long serialVersionUID = 7730763402528350944L;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}