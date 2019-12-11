package com.liangwc.ggblog.freemarker;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liangwc.ggblog.entity.GgArticleInfo;
import com.liangwc.ggblog.service.GgArticleInfoService;
import freemarker.core.Environment;
import freemarker.template.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
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
        TemplateScalarModel tms = (TemplateScalarModel) map.get("method");
        String method = tms.getAsString();
        switch (method) {
            case "listByCategoryId": {
                TemplateScalarModel model = (TemplateScalarModel) map.get("categoryId");
                int categoryId = Integer.parseInt(model.getAsString());
                QueryWrapper<GgArticleInfo> wrapper = new QueryWrapper<>();
                wrapper.eq("catagory_id", categoryId)
                        .orderByDesc("create_time");
                List<GgArticleInfo> list = articleInfoService.list(wrapper);
                DefaultObjectWrapperBuilder builder = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
                environment.setVariable("recommend", builder.build().wrap(list));
                templateDirectiveBody.render(environment.getOut());
            }
            case "count": {
                int count = articleInfoService.count(null);
                DefaultObjectWrapperBuilder builder = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
                environment.setVariable("count", builder.build().wrap(count));
                templateDirectiveBody.render(environment.getOut());
            }
        }

    }
}
