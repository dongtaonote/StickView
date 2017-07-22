这个工程主要是为了实现列表滑动过程中View的悬停，这个工程提供了四种我曾尝试过的方案。每个方案的优缺点，使用情况我都会详细的介绍。个人推荐第二种，项目中也是使用的第二种。



coordinatorLayout:采用CoordinatorLayout + AppBarLayout + CollapsingToolbarLayout + NestedScrollView + VerticalViewPager +Behavior实现。VerticalViewpager里面是Fragment ，Fragment里面的是RecycleView填充。优点：可以结合toolbar、behavior做一些自定义的伸缩动画。缺点：当TabLayout头上的东西太多（悬停部分以上东西太多的话比如加一个横向滚动listview，再加一个viewpager），频繁、快速滑动列表，此时会导致滑动会出问题，behavior的时间传递会有问题。问题暂未解决。使用场景：需要结合toolbar实现一些效果的可以采用，但是一般做项目里面不可能悬停部分以上就只有一个toolbar的，所以不建议采用。具体实现方案见简书 http://www.jianshu.com/p/f1152d74e085



scrollablelayout：采用自定义的LinearLayout 方案实现，重写了dispatchTouchEvent 、computeScroll、scrollBy、scrollTo方法，悬停控件是Viewpager上面的控件，copy别人的代码，然后增加了一个功能，可以自定义设置悬停的y轴的位置 。优点：可以灵活嵌套使用，头部嵌套多少东西都无所谓。缺点：举个栗子--主界面采用TabLayout+ViewPager（FragmentAdapter）+RecycleView 实现，SwipRefreshLayout布局需要使用在主布局里面，如果使用在每个Fragment里面的话，检测是否滑动到顶部会出问题。然后就会出现RecycleView加载更多的问题，自己看着解决吧，网上有很多解决方案。使用场景：几乎全部都可以。个人是比较推荐这种实现方案。具体实现方案见简书 http://www.jianshu.com/p/f1152d74e085



sticknavi：采用自定义的LinearLayout方案实现，大体实现方案同上，优点：易扩展。缺点：当头部嵌套东西多的话，滑动会比较卡顿，然后导致滑动会出问题。使用场景：当头部东西不多时，比如只有一个viewpager或者只有一些gridview按钮，具体实现方案见简书 http://www.jianshu.com/p/f1152d74e085



texttopview：采用继承NestedScrollView重写View实现，实现思路是把需要悬停的view照个相，然后draw在需要悬停的位置，优点：滑动顺滑，头部内容易扩展，如果一个view需要悬停只需要给这个view加上一个tag String。缺点：如果悬停的控件是button、textview这些控件没有问题，如果悬停的控件是个TabLayout，或者是一些可以动态改变的控件，这个方案就会出问题。使用场景：用于悬停一些内容结构不会变动的头部。具体实现方案见简书 http://www.jianshu.com/p/f1152d74e085
