<#--用来做HTML大概的框架，和一些重要的css和js文件的引入-->
<#macro layout title,description>
    <!DOCTYPE html>
    <html lang="zh">
    <head>
        <meta charset="UTF-8">
        <#--防止用户缩放-->
        <meta name="viewport"
              content="width=device-width,
              initial-scale=1,
              minimum-scale=1.0,
              maximum-scale=1.0,
              user-scalable=no,
              shrink-to-fit=no">
        <meta name="description" content="${description!}"/>
        <meta name="site" content="${context!}"/>

        <#--BootStrap CSS-->
        <link href="https://cdn.bootcss.com/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
        <#--Font Awesome 图标库-->
        <link href="https://cdn.bootcss.com/font-awesome/5.10.2/css/all.min.css" rel="stylesheet">
        <#--主页添加的CSS-->
<#--        <#if is_index?? || is_search?? || is_category?? || is_tag?? || is_sheet??>-->
            <link rel="stylesheet" href="${static!}/css/index.css">
<#--        </#if>-->
        <#--归档界面添加的CSS-->
        <#if is_archives?? || is_tags?? || is_categories??>
            <link rel="stylesheet" href="${static!}/css/time-line.css">
        </#if>
        <#if is_category??>
            <link rel="stylesheet" href="${static!}/css/category.css">
        </#if>
        <#--文章界面需要引入的CSS-->
        <#--Github MarkDown的引入-->
            <link rel="stylesheet" href="${static!}/css/github-markdown.css">
            <link rel="stylesheet" href="${static!}/css/post.css">
        <#--代码高亮用到的CSS-->
            <link href="https://cdn.bootcss.com/highlight.js/9.15.10/styles/github.min.css" rel="stylesheet">
            <link href="https://cdn.bootcss.com/fancybox/3.5.7/jquery.fancybox.min.css" rel="stylesheet">
            <link href="https://cdn.bootcss.com/social-share.js/1.0.16/css/share.min.css" rel="stylesheet">
        <#--日志界面的样式-->
        <#if is_journal??>
            <link href="https://cdn.bootcss.com/fancybox/3.5.7/jquery.fancybox.min.css" rel="stylesheet">
            <link rel="stylesheet" href="${static!}/css/journals.css">
        </#if>
        <#if is_sheet??>
            <link rel="stylesheet" href="${static!}/css/sheet.css">
            <link href="https://cdn.bootcss.com/social-share.js/1.0.16/css/share.min.css" rel="stylesheet">
        </#if>
        <#--页面公用的CSS-->
        <link rel="stylesheet" href="${static!}/css/style.css">

        <#--公共 head 代码，包含：Favicon，站点验证代码-->
<#--        <@global.head />-->
        <title>${title}</title>
    </head>
    <body>
    <#--  导航栏  -->
    <#include "navbar.ftl">

    <#--主要内容-->
    <#nested>

    <!-- 公共BootStrap支持使用的JavaScript -->
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://cdn.bootcss.com/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>

    <#-- 公共底部代码，包含：统计代码，底部信息 -->
    <#include "footer.ftl">

    <#--全局的JavaScript脚本-->
    <script type="text/javascript" src="${static!}/js/index.js"></script>
    <script type="text/javascript" src="${static!}/js/navbar.js"></script>
    <#if is_archives?? || is_tags?? || is_categories??>
        <script type="text/javascript" src="${static!}/js/navigation.js"></script>
    </#if>

    <script type="text/javascript" src="${static!}/js/search.js"></script>

<#--    &lt;#&ndash; 额外配置功能&ndash;&gt;-->
<#--    <#if is_post?? || is_sheet??>-->
        <script>
            var displayReadProgress = true;
            var displayLineNumber = true;
            var enableCodeCopy = true;
            var displayCodeType = true;
            var displayMobileCatalog = true;
            var linkOnBlackPage = true;
            var enableShare = true;
            var twitterAccountShare = true;
            var postTitle = true;
            var blogTitle = true;
            var blogUrl = true;
            <#--var displayReadProgress = <#if (settings.open_read_progress)??>${settings.open_read_progress?c}<#else>true</#if>;-->
            <#--var displayLineNumber = <#if (settings.line_number)??>${settings.line_number?c}<#else>true</#if>;-->
            <#--var enableCodeCopy = <#if (settings.code_copy)??>${settings.code_copy?c}<#else>true</#if>;-->
            <#--var displayCodeType = <#if (settings.code_type)??>${settings.code_type?c}<#else>true</#if>;-->
            <#--var displayMobileCatalog = <#if (settings.mobile_catalog)??>${settings.mobile_catalog?c}<#else>true</#if>;-->
            <#--var linkOnBlackPage = <#if (settings.link_on_blank_page)??>${settings.link_on_blank_page?c}<#else>true</#if>;-->
            <#--var enableShare = <#if (settings.open_share)??>${settings.open_share?c}<#else>true</#if>;-->
            <#--var twitterAccountShare = `${settings.twitter_account_share!}`;-->
            <#--var postTitle = `${post.title!}`;-->
            <#--var blogTitle = `${options.blog_title!}`;-->
            <#--var blogUrl = `${context!}`;-->
        </script>
        <script src="https://cdn.bootcss.com/social-share.js/1.0.16/js/social-share.min.js"></script>
<#--    </#if>-->
<#--    <#if is_post??>-->
        <script src="https://cdn.bootcss.com/clipboard.js/2.0.4/clipboard.min.js"></script>
    <#--代码高亮库-->
        <script src="https://cdn.bootcss.com/highlight.js/9.15.10/highlight.min.js"></script>
        <script>hljs.initHighlightingOnLoad();</script>
        <script src="https://cdn.bootcss.com/fancybox/3.5.7/jquery.fancybox.min.js"></script>
        <script type="text/javascript" src="${static!}/js/post.js"></script>
<#--    </#if>-->
    <#if is_journal??>
        <script src="https://cdn.bootcss.com/fancybox/3.5.7/jquery.fancybox.min.js"></script>
        <script type="text/javascript" src="${static!}/js/journals.js"></script>
    </#if>
    <#if is_sheet??>
        <script type="text/javascript" src="${static!}/js/sheet.js"></script>
    </#if>
    <div id="backTop" class="back-top">
        <span><i class="fas fa-caret-up"></i></span>
    </div>
    </body>
    </html>
</#macro>