###Spring3.1包详解与依赖关系

####包的详解
Spring 3.1的jar包和以前的不一样，新版本的jar包把原来的包分解了，功能分工很明确：

【1】org.springframework.aop-3.1.1.RELEASE.jar ---- ---- spring面向切面编程，提供AOP（面向切面编程）
【2】org.springframework.asm-3.1.1.RELEASE.jar ---- ---- spring独立的asm程序
[spring2.5.6的时候需要asmJar 包,3.0开始提供他自己独立的asm.jar .ASM是小巧轻便的 Java 字节码操控框架 ，
它能方便地生成和改造 Java 代码。 Hibernate 和 Spring 在底层都用到了 ASM(CgLib 底层用的 asm)]
【3】org.springframework.aspects-3.1.1.RELEASE.jar ---- ---- spring整合了aspectjrt.jar，也可以使用aspectjrt.jar来代替。
【4】org.springframework.beans-3.1.1.RELEASE.jar ---- ---- springIoC（依赖注入）的基础实现，所有应用都要用到的，
它包含访问配置文件、创建和管理bean以及进行Inversion of Control / Dependency Injection（IoC/DI）操作相关的所有类。
【5】org.springframework.context.support-3.1.1.RELEASE.jar ---- ---- spring-context 的扩展支持，包含支持缓存Cache（ehcache）、
JCA、JMX、邮件服务（Java Mail、COS Mail）、任务计划Scheduling（Timer、Quartz）方面类。
【6】org.springframework.context-3.1.1.RELEASE.jar ---- ----spring 提供在基础 IoC 功能上的扩展服务，此外还提供许多企业级服务
的支持，如 邮件服务、任务调度、JNDI定位、EJB 集成、远程访问、 缓存以及各种视图层框架的封装等。
【7】org.springframework.core-3.1.1.RELEASE.jar ---- ---- 包含Spring框架基本的核心工具类，Spring其它组件要都要使用到这个
包里的类，是其它组件的基本核心。
【8】org.springframework.expression-3.1.1.RELEASE.jar ---- ----spring 表达式语言。
【9】org.springframework.instrument.tomcat-3.1.1.RELEASE.jar ---- ----spring3.1 对 Tomcat 的连接池的基。
【10】org.springframework.instrument-3.1.1.RELEASE.jar ---- ----spring3.1 对服务器的代理接口。
【11】org.springframework.jdbc-3.1.1.RELEASE.jar ---- ----包含对Spring对JDBC数据访问进行封装的所有类。
【12】org.springframework.jms-3.1.1.RELEASE.jar ---- ----提供了对JMS 1.0.2/1.1的支持类。
【13】org.springframework.orm-3.1.1.RELEASE.jar ---- ----包含Spring对DAO特性集进行了扩展，使其支持 iBATIS、JDO、OJB、TopLink，
因为Hibernate 已经独立成包了，现在不包含在这个包里了。这个jar文件里大部分的类都要依赖spring-dao.jar里的类，
用这个包时你需要同时包含spring-dao.jar包 。
【14】org.springframework.oxm-3.1.1.RELEASE.jar ---- ----spring 对Object/XMI 的映射的支持，可以让JAVA与XML之间来回切换。
【15】org.springframework.test-3.1.1.RELEASE.jar ---- ----spring 对Junit 等测试框架的简单封装。
【16】org.springframework.transaction-3.1.1.RELEASE.jar ---- ----为为JDBC、Hibernate、JDO、JPA等提供的一致的声明式和编程式事务管理。
【17】org.springframework.web.portlet-3.1.1.RELEASE.jar ---- ----springMVC 增强，支持portlet标准（JSR168/JSR286）。
【18】org.springframework.web.servlet-3.1.1.RELEASE.jar ---- ----对 J2EE6.0 Servlet3.0 的支持。
【19】org.springframework.web.struts-3.1.1.RELEASE.jar ---- ---- 整合 Struts 的支持。
【20】org.springframework.web-3.1.1.RELEASE.jar ---- ----包含Web应用开发时，用到Spring框架时所需的核心类，
包括自动载入WebApplicationContext 特性的类、Struts与JSF集成类、文件上传的支持类、Filter类和大量工具辅助类。

####依赖关系：
#####【Spring AOP + aspectJ 编程需要导入】

Spring自带的：
1、org.springframework.aop-3.1.1.jar（依赖【2】、【3】、【4】）
2、com.springsource.org.aopalliance-1.0.0.jar
3、com.springsource.org.apache.commons.logging-1.1.1.jar
4、org.springframework.core-3.1.1.RELEASE.jar（依赖【3】）

使用aspectJ框架，还需导入：
5、org.springframework.aspects-3.1.1.RELEASE.jar（依赖【6】、【7】、【8】、【9】）
6、com.springsource.org.apache.commons.logging-1.1.1.jar
7、org.springframework.beans-3.1.1.RELEASE.jar（依赖【6】、【8】）
8、org.springframework.core-3.1.1.RELEASE.jar（依赖【6】）
9、org.springframework.context-3.1.1.RELEASE.jar（依赖【6】、【7】、【8】）
10、com.springsource.org.aspectj.runtime-1.6.12.RELEASE.jar（似乎可以不要，见【Spring 3.1包详解】）
11、com.springsource.org.aspectj.weaver-1.6.12.RELEASE.jar

如果项目不是面向接口编程，则还需要下载cglib包放到项目里，因为cglib包可以产生不面向接口的代理：
12、com.springsource.net.sf.cglib-2.2.0
另外，由于cglib底层实现使用了ASM，所以还需要导入Spring自带的：
13、org.springframework.asm-3.1.1.RELEASE.jar


#####【DataSource】

【使用c3p0需要导入】
com.springsource.com.mchange.v2.c3p0-0.9.1.2

【使用dbcp需要导入】
1、com.springsource.org.apache.commons.dbcp-1.2.2.osgi.jar(依赖【2】)
2、com.springsource.org.apache.commons.pool-1.5.3.jar

【使用Proxool需要导入】
1、com.springsource.org.logicalcobwebs.proxool-0.9.1（依赖【2】、【3】）
2、com.springsource.org.apache.commons.logging-1.1.1.jar
3、com.springsource.org.logicalcobwebs.cglib.core-0.9.1（依赖【4】）
4、com.springsource.net.sf.cglib-2.2.0.jar

【使用BoneCP需要导入】
1、bonecp-0.7.1.RELEASE.jar（在http://jolbox.com/requirements.html下载)（依赖【1】、【2】、【3】）
2、guava-11.0.2.jar（http://code.google.com/p/guava-libraries/wiki/Release11下载)
3、slf4j-api-1.6.4.jar（依赖【4】）
4、slf4j-nop-1.6.4.jar(如果要换成其他日志的实现，例如log4j，请自行替换成其他包)
5、jsr305-2.0.0.jar（据说本来是在JDK7中支持该标准的，但被推迟到了jdk8。 另外，我在官网中也没发现jdk7支持jsr305标准,
下载地址 http://www.jarvana.com/jarvana/archive-details/com/google/code/findbugs/jsr305/2.0.0/jsr305-2.0.0.jar,
下载后源码和二进制码事实上都是在这个包里的）

【使用tomcat jdbc pool需要导入】
1、com.springsource.org.apache.tomcat.jdbc-1.0.9.3（依赖【2】）
2、com.springsource.org.apache.juli.extras.springsource-6.0.32.S2-r1673.jar ---- Apache Tomcat的JULI日志组件允许Web应用提供自己的日志配置

