# boot-demo

一个基于 **Spring Boot** 的学生管理系统，实现了基本的 CRUD 操作，适合 **Spring Boot 初学者** 学习参考。

## 🚀 技术栈

* **框架**: Spring Boot 3.5.5
* **语言**: Java 21
* **ORM**: Spring Data JPA
* **数据库**: MySQL
* **构建工具**: Maven

## 📂 项目结构

```
com.example.boot_demo
├── controller        # 控制器层，处理HTTP请求
│   └── StudentController.java
├── service           # 服务层，处理业务逻辑
│   ├── StudentService.java
│   └── StudentServiceImpl.java
├── dao               # 数据访问层，JPA实体类
│   └── Student.java
├── dto               # 数据传输对象
│   └── StudentDTO.java
├── converter         # DTO与实体类转换工具
│   └── StudentConverter.java
└── BootDemoApplication.java   # 应用入口类
```

## ✨ 功能介绍

实现学生信息的增删改查功能，包括：

* 添加新学生
* 根据 ID 查询学生
* 更新学生信息
* 删除学生

## 📖 API 文档

### 1. 获取学生信息

* **URL**: `/student/{id}`
* **方法**: `GET`
* **参数**: `id` (路径参数，学生ID)
* **响应**: 学生详细信息(JSON)

### 2. 添加新学生

* **URL**: `/student`
* **方法**: `POST`
* **请求体**:

  ```json
  {
    "name": "张三",
    "age": 20,
    "email": "zhangsan@example.com"
  }
  ```
* **响应**: 新增学生的ID

### 3. 更新学生信息

* **URL**: `/student/{id}`
* **方法**: `PUT`
* **参数**:

  * `id` (路径参数，学生ID)
  * `name` (可选，学生姓名)
  * `age` (可选，学生年龄)
  * `email` (可选，学生邮箱)
* **响应**: 更新后的学生信息

### 4. 删除学生

* **URL**: `/student/{id}`
* **方法**: `DELETE`
* **参数**: `id` (路径参数，学生ID)
* **响应**: 无

## ⚙️ 环境配置

1. 确保已安装 **JDK 21** 和 **Maven**
2. 创建 MySQL 数据库：

   ```sql
   CREATE DATABASE test CHARACTER SET utf8;
   ```
3. 修改 `application.properties` 配置文件：

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/test?characterEncoding=utf-8
   spring.datasource.username=你的数据库用户名
   spring.datasource.password=你的数据库密码
   ```

## ▶️ 运行步骤

1. 克隆仓库：

   ```bash
   git clone <你的仓库URL>
   cd boot-demo
   ```
2. 构建项目：

   ```bash
   mvn clean package
   ```
3. 运行应用：

   ```bash
   java -jar target/boot-demo-0.0.1-SNAPSHOT.jar
   ```
4. 访问 API: [http://localhost:8080/student/{id}](http://localhost:8080/student/{id})

用 **Postman** 调试
比如我们这个学生管理系统，Postman 里可以这样组织：

### 📂 Collection: `boot-demo 学生管理系统`

* **GET 学生信息**

  * URL: `http://localhost:8080/student/{{id}}`
  * 方法: GET
  * 参数: `id` (路径参数)
* **POST 添加学生**

  * URL: `http://localhost:8080/student`
  * 方法: POST
  * Body (raw JSON):

    ```json
    {
      "name": "张三",
      "age": 20,
      "email": "zhangsan@example.com"
    }
    ```
* **PUT 更新学生**

  * URL: `http://localhost:8080/student/{{id}}`
  * 方法: PUT
  * Body (raw JSON):

    ```json
    {
      "name": "李四",
      "age": 22,
      "email": "lisi@example.com"
    }
    ```
* **DELETE 删除学生**

  * URL: `http://localhost:8080/student/{{id}}`
  * 方法: DELETE



