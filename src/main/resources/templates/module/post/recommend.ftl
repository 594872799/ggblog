<#--文章界面推荐部分ok-->
<#if (post.catagoryId)??>
    <@postTag method="listByCategoryId" id="${post.id}" categoryId="${post.catagoryId!}">
        <#if recommend?? && recommend?size != 0>
            <section id="recommend" class="mb-lg-4 mb-5">
                <div class="card">
                    <div class="card-header"><i class="fas fa-list-ul mr-2"></i>相关推荐</div>
                    <div class="card-body p-0">
                        <ul class="list-group list-group-flush">
                            <#list recommend as post>
                                <#if post?index < 5>
                                    <a href="/article/${post.id!}"
                                       class="list-group-item list-group-item-action">${post.title!}
                                    </a>
                                </#if>
                            </#list>
                        </ul>
                    </div>
                </div>
            </section>
        </#if>
    </@postTag>
</#if>