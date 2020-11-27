package com.gykj.zhumulangma.home.bean;

import androidx.annotation.DrawableRes;

/**
 * Author: Thomas.<br/>
 * Date: 2020/11/27 19:32<br/>
 * GitHub: https://github.com/TanZhiL<br/>
 * CSDN: https://blog.csdn.net/weixin_42703445<br/>
 * Email: 1071931588@qq.com<br/>
 * Description:
 */
public class NavigationItem {
    private String label;
    private String value;
    private int bgColor;
    private @DrawableRes int icon;

    public NavigationItem(String label, String value, int bgColor, int icon) {
        this.label = label;
        this.value = value;
        this.bgColor = bgColor;
        this.icon = icon;
    }

    public int getBgColor() {
        return bgColor;
    }

    public void setBgColor(int bgColor) {
        this.bgColor = bgColor;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}