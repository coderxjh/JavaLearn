package com.xiao.autoconfigure.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author simba@onlying.cn
 * @date 2021/7/8 18:16
 */
@ConfigurationProperties("hello")
public class HelloProperties {

    private String prefix;
    private String suffix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
