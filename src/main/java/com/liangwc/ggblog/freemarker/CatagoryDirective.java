package com.liangwc.ggblog.freemarker;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liangwc.ggblog.entity.GgArticleInfo;
import com.liangwc.ggblog.entity.GgCatagory;
import com.liangwc.ggblog.service.GgArticleInfoService;
import com.liangwc.ggblog.service.GgCatagoryService;
import com.liangwc.ggblog.vo.ArticleVo;
import freemarker.core.Environment;
import freemarker.template.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author liangweicheng
 * @date 2019/11/29 11:28
 */
@Component
public class CatagoryDirective implements TemplateDirectiveModel {
    @Autowired
    private GgCatagoryService catagoryService;
    @Autowired
    private GgArticleInfoService articleInfoService;

    @Override
    public void execute(Environment environment, Map map, TemplateModel[] templateModels, TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {
        TemplateScalarModel tms = (TemplateScalarModel) map.get("method");
        String method = tms.getAsString();
        switch (method) {
            case "list": {
//                List<GgCatagory> catagories = catagoryService.list(null);
                List<ArticleVo> articleVos = articleInfoService.getCategory();
                DefaultObjectWrapperBuilder builder = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
                environment.setVariable("categories", builder.build().wrap(articleVos));
                templateDirectiveBody.render(environment.getOut());
                break;
            }
            case "count": {
                int count = catagoryService.count(null);
                DefaultObjectWrapperBuilder builder = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
                environment.setVariable("count", builder.build().wrap(count));
                templateDirectiveBody.render(environment.getOut());
                break;
            }
        }

    }
}
