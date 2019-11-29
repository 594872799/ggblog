package com.liangwc.ggblog.config;

import com.liangwc.ggblog.freemarker.CatagoryDirective;
import com.liangwc.ggblog.freemarker.MenuDirective;
import com.liangwc.ggblog.freemarker.PostDirective;
import com.liangwc.ggblog.freemarker.TagDirective;
import freemarker.template.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author liangweicheng
 * @date 2019/11/29 14:42
 */
@Component
public class FreemarkerConfig {
    @Autowired
    private Configuration configuration;

    @Autowired
    private MenuDirective menuDirective;
    @Autowired
    private CatagoryDirective catagoryDirective;
    @Autowired
    private PostDirective postDirective;
    @Autowired
    private TagDirective tagDirective;

    @PostConstruct
    public void setSharedVariable() {
        configuration.setSharedVariable("menuTag", menuDirective);
        configuration.setSharedVariable("categoryTag", catagoryDirective);
        configuration.setSharedVariable("postTag", postDirective);
        configuration.setSharedVariable("tagTag", tagDirective);
    }
}
