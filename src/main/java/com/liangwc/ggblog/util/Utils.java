package com.liangwc.ggblog.util;

import com.liangwc.ggblog.vo.ArticleVo;

import java.util.LinkedList;
import java.util.List;

/**
 * @author liangweicheng
 * @date 2019/12/12 15:35
 */
public class Utils {

    /**
     * 分割tag
     *
     * @return
     */
    public static void splitTag(List<ArticleVo> articleList) {

        for (ArticleVo vo : articleList) {
            List<String> tagList = new LinkedList<>();
            for (String tag : vo.getTags().split(",")) {
                tagList.add(tag);
            }
            vo.setTagList(tagList);
        }
    }
}
