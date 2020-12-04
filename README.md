# cglibDemo
### cglib插桩实现也是基于ASM
### 学习文档：

- 在方法中插桩：[https://blog.csdn.net/J080624/article/details/82079072](url)
- 每个类详解：[https://blog.csdn.net/qq_33661044/article/details/79767596](url)

### 与JDK Proxy写法很像
```
JDK动态代理：其代理对象必须是某个接口的实现，它是通过在运行期期间创建一个接口的实现类来完成对目标对象的代理。
CGLIB代理：实现原理类似于JDK动态代理，只是它在运行期间生成的代理对象是针对目标类扩展的子类。CGLIB是高效的代码生成包，底层依靠ASM（开源的Java字节码编辑类库）操作字节码实现。
在内存中动态生成类
```
### cglib github地址
[https://github.com/cglib/cglib](url)
### 参考demo

- [https://github.com/leo-ouyang/CGLib-for-Android](url)
- [https://github.com/zhangke3016/MethodInterceptProxy ](url)  （mdlibrary）

### CGLib-for-Android原理

```
dexMaker会在沙盒里创建一个app_dexfiles文件夹，存放dex文件，然后使用双亲委派方式加载类
dexMaker github地址：https://github.com/linkedin/dexmaker
```
### cglib-for-android实现分析截图
![avatar](https://raw.githubusercontent.com/liuhangb/cglibDemo/master/image/cglib-for-android%E4%BB%A3%E7%A0%81%E5%AE%9E%E7%8E%B0.png)

![avatar](https://raw.githubusercontent.com/liuhangb/cglibDemo/master/image/cglib-for-android%E7%94%9F%E6%88%90%E7%9A%84%E4%BB%A3%E7%A0%81.png)

### cglib生成的代码位置
##### 沙盒data/data/包名/app_dexfiles下
![avatar](https://github.com/liuhangb/cglibDemo/blob/master/image/cglib%E7%94%9F%E6%88%90%E7%9A%84dex%E6%96%87%E4%BB%B6.png?raw=true)
### mdlibrary实现分析截图
![avatar](https://github.com/liuhangb/cglibDemo/blob/master/image/mdlibrary%E7%94%9F%E6%88%90%E7%9A%84%E4%BB%A3%E7%A0%81.png?raw=true)

