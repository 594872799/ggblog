package com.liangwc.ggblog.freemarker;

import com.liangwc.ggblog.service.GgArticleInfoService;
import com.liangwc.ggblog.service.GgBlogInfoService;
import freemarker.core.Environment;
import freemarker.template.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * @author liangweicheng
 * @date 2019/11/29 15:03
 */
@Component
public class PostDirective implements TemplateDirectiveModel {
    @Autowired
    private GgArticleInfoService articleInfoService;

    @Override
    public void execute(Environment environment, Map map, TemplateModel[] templateModels, TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {
        int count = articleInfoService.selectCount(null);
        DefaultObjectWrapperBuilder builder = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
        environment.setVariable("count", builder.build().wrap(count));
        templateDirectiveBody.render(environment.getOut());
    }
}
