# CourseRec_microservice
智能微课堂——在线课程推荐系统
===========================
### 1.	项目简介
本项目用Spring Boot，Spring Cloud和Docker实现了微服务架构模式应用。

本项目的名称为智能微课堂，随着在线教育平台的发展，越来越多的人选择通过慕课平台学习课程。然而从海量的课程中找到自己感兴趣的课程是一件比较困难的事，推荐系统不需要用户提供明确的需求，而是分析用户的历史行为给用户的兴趣建模，从而挖掘出用户的个性化需求。使用推荐系统为慕课学习者提供符合他的兴趣和知识水平的课程，有利于提高课程的完成度。

本项目基于 “华师慕课”平台，“华师慕课”是面向中小学生的在线学习平台，这个平台中包括很多微视频资源，每个微视频讲一个知识点，用户可以针对知识点进行学习。我们所做的工作是为使用这个平台的用户推荐微视频。主要利用了平台固有的知识体系，以及后台用户的做题记录作为判断用户对知识掌握情况的依据。分别实现了对用户学习和做题记录的可视化、基于知识体系以及差异化教学理论对用户进行课程复习推荐、预习推荐。


### 2.	功能性服务
本项目由五个核心微服务构成，如图1所示，每个微服务独立部署，运行在自己的进程中，连接独立的数据库。每个微服务有独立的数据库，所以不能够绕开API而直接访问其它微服务的数据。本项目中用HSQLDB数据库。HSQLDB数据库是一个轻量级的纯Java开发的开放源代码的关系数据库。服务与服务之间的通信通过REST API实现。
 ![image](https://github.com/vivalazy/CourseRec_microservice/raw/master/screenshots/pic6.png)
 
#### User service
包括用户信息的管理。

|  Method  | Path |    Description    | User authenticated | Available from UI |
| -------- |  --- | ----------------- | :-------------------: | :---------------: |
| GET |  /users |  Get users information |           √       |       √          |
| GET |  /users/{id} |  Get specified user information |          √         |       √          |
| POST |  /users |  Register new user |        ×           |         ×        |

#### Course service
包括课程信息的管理：系统中课程的ID、名称、种类。

|  Method  | Path |    Description    | User authenticated | Available from UI |
| -------- |  --- | ----------------- | :-------------------: | :---------------: |
| GET |  /courses |  Get courses information |           √       |       √          |
| GET |  /courses/{id} |  Get specified course information |          √         |       √          |
| POST |  /courses |  Add new course |        ×           |         ×        |

#### Recommendation service
提供针对每个用户的复习课程推荐和复习推荐课程。

|  Method  | Path |    Description    | User authenticated | Available from UI |
| -------- |  --- | ----------------- | :-------------------: | :---------------: |
| GET |  /reviewrecom/{userid} |  Get specified user review course recommendation |           √       |       √          |
| GET |  /previewrecom/{userid} | Get specified user preview course recommendation |          √         |       √          |
| POST |  / recom |  Add new recommendation |        ×           |         ×        |

#### Recommendation service
提供针对每个用户的复习课程推荐和复习推荐课程。

|  Method  | Path |    Description    | User authenticated | Available from UI |
| -------- |  --- | ----------------- | :-------------------: | :---------------: |
| GET |  /record/{userid} |  Get specified user learning record |           √       |       √          |
| POST |  / record |  Add new record |        ×           |         ×        |

### UI service
通过调用其它服务提供的接口，将数据展示在与用户交互的页面中。


### 3.	基础架构服务
 ![image](https://github.com/vivalazy/CourseRec_microservice/raw/master/screenshots/pic7.png)
#### Config service
Spring Cloud Config是用于分布式系统的水平可扩展的集中式配置服务。支持本地存储、Git和Subversion。本项目中使用的是本地配置文件，它从本地类路径加载配置文件。当通知服务请求配置时，配置服务以application.yml相应。

#### API Gateway
使用@EnableZuulProxy注释启用API网关。在这个项目中，使用ZUUL来存储静态内容，并将请求路由到适当的微服务。

#### Service discovery
服务发现允许自动检测服务实例的网络位置，由于自动扩展，故障和升级，可能会动态分配地址。服务发现的关键部分是注册表。本项目中使用Netflix Eureka。使用Spring Boot，可以使用spring-cloud-starter-eureka-server依赖关系，@EnableEurekaServer注释和简单配置属性来构建Eureka注册表。在应用程序启动时，它将注册到Eureka服务器并提供元数据，如主机和端口，运行状况指示器URL，主页等。Eureka从属于一个服务的每个实例接收心跳消息。如果心跳故障切换到可配置的时间表，则实例将从注册表中删除。此外，Eureka提供了一个界面可以跟踪运行的服务和可用实例数。
 ![image](https://github.com/vivalazy/CourseRec_microservice/raw/master/screenshots/pic8.png)
