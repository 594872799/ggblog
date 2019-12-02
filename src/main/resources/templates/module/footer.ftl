<#--页脚ok-->
<footer class="py-4 border-top bg-white">
    <div class="container d-flex flex-md-row flex-column justify-content-between align-items-center px-lg-2">
        <div>
            <span class="text-muted">Liangwc'Blogs 2019</span>
            <span class="text-muted font-weight-bold"> Thank for <a
                        href="https://github.com/halo-dev/halo">Halo</a></span>
        </div>
        <div class="link-info mt-md-0 mt-4">
            <#--Github-->
            <#if (settings.githubUrl)?? && settings.githubUrl?trim != ''>
                <a class="text-dark mr-3" target="_blank"
                   href="${settings.githubUrl!}">
                    <i class="fab fa-github"></i>
                </a>
            </#if>
            <#--QQ账号-->
            <#if (settings.qqNumber)?? && settings.qqNumber?trim != ''>
                <a class="text-dark mr-3" target="_blank"
                   href="http://wpa.qq.com/msgrd?v=3&uin=${settings.qqNumber!}&site=qq&menu=yes">
                    <i class="fab fa-qq"></i>
                </a>
            </#if>
            <#--新浪微博-->
            <#if (settings.weiboUrl)?? && settings.weiboUrl?trim != ''>
                <a class="text-dark mr-3" target="_blank"
                   href="${settings.weiboUrl!}">
                    <i class="fab fa-weibo"></i>
                </a>
            </#if>
            <#--邮箱地址-->
            <#if (settings.emailAddress)?? && settings.emailAddress?trim != ''>
                <a class="text-dark" href="mailto:${settings.emailAddress!}">
                    <i class="fas fa-envelope"></i>
                </a>
            </#if>
        </div>
    </div>
</footer>