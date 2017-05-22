# AIDLDemo
#服务 --四大组件
##1.服务的创建
###1.创建一个类继承自Service（或它的子类，如IntentService）,重写里面比较关键的回调方法
	如 ： 1.onStartCommand()  正常启动
		   
		  2.onBind()  绑定启动
###2.清单文件中声明服务
	在Manifest文件中声明的时候，只有android:name属性是必须有的
	
	 1.android:enabled 如果为true，则这个service可以被系统实例化，如果为false，则不行，默认为true
	 
	 2.android:exported false service只使用于自己的应用
	 
     3.android:icon 一个象征着这个service的icon
	
	 4.android:label 显示给用户的这个service的名字，如果不设置，默认使用Application的label属性

	 5.android:name

	 6.android:permission

	 7.android:process service运行的进程的name。默认启动的service是运行在主线程的。

##Service启动方式
###1.启动
	当应用组件（Activity）通过调用startService()启动服务时，服务既处于“启动状态”

	无论应用是处于启动状态还是绑定状态，亦或者出去启动并且绑定状态，任何应用组件均可像使用Activity那样通过调用Intent来使用服务（即使此服务来自另一应用）	

	注意：服务在其托管进程的主线程中运行，，它既不创建自己的线程，也不在单独的进程中运行（除非另行制定）。这意味着，如果服务将执行任何CPU密集型工作或阻止性操作，则应在服务内创建新的线程来完成这项工作。通过使用单独的线程，可以降低发生“程序无响应”ANR错误，而应用的主线程可继续专注于运行用户与Activity之间的交互

	onCreate()
	onStartCommand()
	onDestroy()

	为了确保应用的安全性，请始终使用显示Intent启动或者绑定service，且不要为服务声明intent过滤。启动哪个服务存在一定得不确定性，而如果对这种不确定性的考量非常有必要

###2.绑定



#AIDL
##1.定向TAG
	 1.AIDL中的定向tag表示了在跨进程通信中数据的流向，
###1.in
	其中in表示数据只能由客户端流向服务端，
###2.out
	out表示数据只能由服务器流向客户端，
###3.inout
	inout则表示数据可在服务端与客户端之间双向流通。
	
	其中数据流向是针对在客户端中的那个传入方法的对象而言的。
	
	in为定向tag的话表现为服务端会接受到一个那个对象的完整数据，但是客户端的那个对象不会因为服务端对传参的修改而发生变动；

	out的话表现为服务端将会接受到那个对象的空对象，但是服务端对接受到的空对象有任何修改你之后客户端将会同步变化；
	
	inout为定向tag的情况下，服务端将会接受到客户端传来对象的完整信息，并且客户端将会同步服务器对该对象的任何变动
	
