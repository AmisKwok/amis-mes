# AMIS-MES 生产链系统

## 项目简介
AMIS-MES 生产链系统是一个基于Java的企业级制造执行系统，用于管理生产流程、质量控制、设备维护等制造环节。

## 技术栈
- 后端: Spring Boot, MyBatis
- 前端: Vue.js
- 数据库: MySQL
- 其他: Redis, Druid

## 快速开始

### 环境要求
- JDK 1.8+
- Maven 3.6+
- MySQL 5.7+

### 安装步骤
1. 克隆仓库: `git clone [仓库地址]`
2. 导入数据库: 执行`sql/mes.sql`
3. 配置数据库连接: 修改`amis-admin/src/main/resources/application-druid.yml`
4. 启动项目: `mvn spring-boot:run`

## 项目结构
```
amis-admin/        - 主应用模块
amis-common/       - 公共模块
amis-framework/    - 框架核心
amis-mes/          - MES业务模块
amis-system/       - 系统管理模块
```

## 许可证
MIT License