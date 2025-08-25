# xh-admin-cloud

晓寒开源管理系统是一个免费开源的中后台系统解决方案，采用前后端分离架构。本项目是基于 [xh-admin-backend](https://github.com/Alixhan/xh-admin-backend) 的二次开发版本，主要将原项目的 Spring Boot 架构升级为 Spring Cloud Alibaba 架构，并采用 DDD 模式进行开发。

## ⚙️ 环境配置

| 技术栈       | 版本信息         |
|--------------|------------------|
| Node.js      | v20.19.4         |
| Vite         | 7.0.6            |
| MySQL        | 8.0.33           |
| Redis        | 7.0.5            |
| pnpm         | 10.14.0          |
| JDK          | OpenJDK 21       |
| Nacos        | 2.5.1（自带）    |
| Seata        | 待集成           |
| RocketMQ     | 待集成           |

默认登录账号：`admin`，密码：`admin123`

数据库初始化脚本路径：`xh-admin-front/docs/docker/mysql/docker-entrypoint-initdb.d`

## 📦 开发说明

1. **架构升级**：从 Spring Boot 升级为 Spring Cloud Alibaba。
2. **开发模式**：采用 DDD（领域驱动设计）模式。
3. **配置中心**：集成 Nacos 作为配置中心。
4. **数据访问层**：使用 MyBatis Plus 替代原生 JDBC。
5. **权限认证**：使用 Sa-Token-JWT 替代 Sa-Token。

## 📚 原项目介绍

晓寒开源管理系统是一个开源免费的中后台管理系统基础解决方案，无专业版收费，所有功能完全开源。

- **前端技术栈**：Vue3、TypeScript、Element Plus、Pinia、Vite
- **后端技术栈**：JDK21、Spring Boot 3、Spring Cloud、Spring Cloud Alibaba、SaToken

前端代码仓库：[xh-admin-frontend](https://github.com/Alixhan/xh-admin-frontend)  
后端代码仓库：[xh-admin-backend](https://github.com/Alixhan/xh-admin-backend)

Gitee 仓库地址：
- 前端：[xh-admin-frontend](https://gitee.com/sun-xiaohan/xh-admin-frontend)
- 后端：[xh-admin-backend](https://gitee.com/sun-xiaohan/xh-admin-backend)

## 🚀 前端启动说明

1. 安装 pnpm
   ```bash
   npm install pnpm -g
   ```

2. 进入项目目录
   ```bash
   cd xh-admin-frontend
   ```

3. 安装依赖
   ```bash
   pnpm i
   ```

4. 启动开发环境
   ```bash
   pnpm dev
   ```

## 📄 开源许可

本项目遵循开源协议，所有代码均可自由使用、修改和分发。如需了解更多信息，请参阅项目根目录下的 `LICENSE` 文件。

## 🤝 贡献指南

欢迎贡献代码和文档。请遵循以下步骤：
1. Fork 项目
2. 创建新分支
3. 提交 Pull Request

## 📢 联系与支持

- **交流群**：加入微信群参与讨论
- **捐赠支持**：如果您喜欢本项目，欢迎通过微信或支付宝进行捐赠支持

## 📄 特别鸣谢

感谢所有开源前辈的贡献，让我们能够站在巨人的肩膀上构建更好的系统。

---

该项目旨在为开发者提供一个现代化、可扩展、可维护的中后台管理系统模板，欢迎社区参与共建。