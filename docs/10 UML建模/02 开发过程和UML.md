2开发过程和UML
UML是从一堆OO分析和设计方法发展而来的。但是大家容易在建模语言描述上达成一致，但是对于开发过程上却难以达成一致。注意RUP是Rational统一过程，是一个可以用UML的开发过程框架，实际上RUP和UML没有关系。

2.1迭代和瀑布过程

二者的本区别是如何把一个项目分解为更小块

瀑布风格基于活动来分解项目，如：需求分析、设计、编码和测试。为期一年的项目可能有两个月的2个月的分析阶段，4个月的设计，3个月的编码阶段，接着是3个月的测试阶段。

迭代风格根据功能子集来分解项目。你可能把一年分为三个月的迭代，在第一个迭代中，你会处理1/4的需求，并对这1/4做完整的软件生命周期：分析、设计、编码、测试，第一个迭代结束时，你拥有了1/4所需功能的系统。

2.2 UML在开发过程里

不管你是否使用瀑布方法，你依然会做分析、设计、编码和测试，你可以运作一个每周一迭代的项目，那么每周就是一个小型瀑布。

2.2.1需求分析用到的UML技能包括：

	用例，描述人们如何与系统交互。<br/>
	类图，从概念视角画类图，是建造严密的领域词汇表的好方法。<br/>
	活动图，能够展示组织的工作流，展示软件如何与人类活动交互，能够为用例展示其上下文。<br/>
	状态图：如果一个概念有一个值得注意的生命周期，里面有各种状态和改变状态的事件

2.2.2设计

	类图从软件视角展示软件中的类，以及他们如何互联。<br/>
	常用场景的序列图，从用例中选择重要的场景用序列图展示软件发生了什么。<br/>
	包图展示软件的大规模组织。<br/>
	为有复杂生命历史的类创建状态图。<br/>
	部署投入用于展示软件的物理布局

