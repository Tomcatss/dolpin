package com.test.utils.commonUtils;

import org.springframework.web.servlet.view.InternalResourceView;

import java.io.File;
import java.util.Locale;

public class HtmlResourceView extends InternalResourceView {
    //该视图解析器先跳到html页面再跳到jsp页面，如果html和jsp在相同的目录下，则优先跳到html页面，如果两者都没有则跳到error。
    @Override
    public boolean checkResource(Locale locale) throws Exception {
        File file = new File(this.getServletContext().getRealPath("/")+getUrl());
        return file.exists();
    }
}
