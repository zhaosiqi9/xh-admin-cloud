# xh-admin-cloud

> fork from https://gitee.com/sun-xiaohan/xh-admin-backend
的二次开发

## ⚡ 配置环境

nodeJs v20.19.4 <br>
vite 7.0.6 <br>
mysql 8.0.33 <br>
redis 7.0.5 <br>
pnpm 10.14.0 <br>
openjdk 21 <br>
nacos 2.5.1(自带) <br>
seata (todo) <br>
rocketmq (todo)

登录账号：admin 密码：admin123

初始化脚本位置: xh-admin-front/docs/docker/mysql/docker-entrypoint-initdb.d<br>

## ⚡ 开发说明
更改说明(主要是改了后端代码,前端代码暂未修改): 
1. springboot -> springcloud Alibaba
2. DDD模式开发
3. 代码集成nacos 作为配置中心
4. jdbc -> mybatis plus join
5. sa-token -> sa-token-jwt

## ⚡ 原项目介绍

XHan Admin（晓寒开源管理系统）是一个开源免费（前后端分离）中后台管理系统基础解决方案, 无专业版收费，所有功能毫无保留的贡献给开源社区。
前端技术栈： Vue3, TypeScript, Element Plus, Pinia , Vite等
后端技术栈： jdk21, springboot3, spring-cloud, spring-cloud-alibaba, SaToken等

前端代码库: [xh-admin-frontend](https://github.com/Alixhan/xh-admin-frontend)<br>
后端代码库: [xh-admin-backend](https://github.com/Alixhan/xh-admin-backend)

gitee 码云代码仓库<br>
前端代码库: [xh-admin-frontend](https://gitee.com/sun-xiaohan/xh-admin-frontend)<br>
后端代码库: [xh-admin-backend](https://gitee.com/sun-xiaohan/xh-admin-backend)


> 开始文档：[https://www.xhansky.cn/guide/install/)

### 前端启动说明
1. 安装 pnpm
`npm install pnpm -g`
2. 命令行进入项目目录
`cd xh-admin-frontend`
3. 安装依赖
`pnpm i`
4. 前端开发环境启动
`pnpm dev`
