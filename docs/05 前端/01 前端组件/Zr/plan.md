## 需求分析&风险规避&未来规划

开头直接就暴露问题，直指主题：

    需求倒排期？难以保证前端体验
    前端维护成本高
    前端开发已经影响整体进度
    
我相信很多人都已经遇到这样的问题，那项目开发过程中，任何环节如果出现问题肯定会delay进度。至少前端目前已经暴露了这些问题。

当然针对以上的问题总结为以下几个类别

    资源不够
    技术选型太多
    没法长期维护
    
通过以上问题总结，终于找到病因，可是如何解决呢？还是需要设定一下边界。

设定边界之前先考虑一个**问题**

    可不可以采用开源框架解决问题？
    
我相信，答案已经有了那就是**可以啊**。不过从战略上考虑（虽然理我很遥远，但是我也是组织中的一员啊！！！），最近几个重要新闻让我们可以反思啊

+ facebook修改react开源协议的事情
+ 美国优先，所有依赖美国技术核心的企业生存难以保证

相信这2件事就足以说明问题了，结论就是

    师夷长技以制夷
    
当然我们伟大的祖国已经很多领域在世界格局中领跑了。话说回来，我们技术上很多前沿的，有交互体验性高的，模式成熟的，那就去其糟粕，取其精髓

最后我们需要设定边界

    边界一：开发的组件需要了解到，服务端人员与前端人员比例严重失衡，难以用类似SPA方式去支持。当然类似的模式还有很多，总之都是需要大量前端人员针对不同条线支持，但是看到结果。这种方式难以大面积实行~~
    边界二：开发的组件也需要知道，前端人员擅长HTML+Css+Javascript，而服务端人员只是了解一些基础，甚至更少
    边界三：既然组件研发，就需要知晓服务端人员那么多，写前端代码就会有很多问题凸显：变量泛滥、凭兴趣喜好选取插件、后期基本难以维护、交互上因为插件众多难以统一，并且发现问题或者遇到新的问题基本就是妥协。
    边界四：组件也需要支持快速引入成熟的第三方插件、还是原生语法（减少学习成本）、文档API准确对应相应的插件（减少错误率，提升查找效率）

这就是Zr的诞生流程，总的来说，这是专门为Java Web工程师设计的一款实用的UI 框架。Zr的来意“Go to zero”。

那就谈谈关于Zr未来发展的步骤：

第一步：实现一套无缝对接的原生UI框架，目前就是1.x的阶段。

第二部：实现业务组件的搭建，丰富组件库，这个版本为2.x，同时优化所有1.x的组件内容。

第三步：实现3.x，这个版本基本就是不向下兼容了，整体重写，是一套MVVM的框架，可以较好的提升体验性与专业性。当然，这个版本以后是针对专业前端人员开发的，不过我相信在这个衍生过程中，会有越来越多的全栈人才加入开发和分享。
    



    

    