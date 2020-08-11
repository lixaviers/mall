## 素焉商城
`mall`项目是一套电商系统，包含网关、消息中心、文件中心、商品中心、运营平台、订单中心、支付中心、用户中心。使用Spring Cloud Alibaba框架，Nacos作为注册中心和配置中心，持续更新中。<br>
<br>
配置步骤：<br>
1、启动nacos<br>
2、导入各个系统的sql<br>
3、初始化用户，店铺用户可以注册<br>

### 任务列表
1、nacos集群：已完成<br>
2、zipkin数据未持久化(ES)<br>

### 组织架构
``` lua
mall
├── mall-component  -- 公用类/配置
├── mall-gateway    -- 网关
├── mall-message    -- 消息中心
├── mall-goods      -- 商品中心
├── mall-job        -- 公共定时任务
├── mall-operation  -- 运营平台
├── mall-order      -- 订单中心
├── mall-pay        -- 支付中心
└── mall-user       -- 用户中心
```

### 项目端口

``` lua
mall
├── mall-web前端页面          -- 10001
├── mall-gateway             -- 10002
├── mall-message-web         -- 10003
├── mall-file-web            -- 10004
├── mall-user-b-web          -- 10005
├── mall-user-c-web          -- 10006
├── mall-user-e-web          -- 10007
├── mall-operation-e-web     -- 10008
├── mall-operation-b-web     -- 10009
├── mall-operation-c-web     -- 10010
├── mall-goods-e-web         -- 10011
├── mall-goods-b-web         -- 10012
├── mall-goods-c-web         -- 10013
├── mall-mmc-e-web           -- 10014
├── mall-mmc-b-web           -- 10015
├── mall-mmc-c-web           -- 10016
├── mall-order-e-web         -- 10017
├── mall-order-b-web         -- 10018
├── mall-order-c-web         -- 10019
└── mall-xxxx-c-web     -- xxxxx
```





### 异常范围定义

| 系统名称                                 | 异常编码范围                                                  |
| --------------------------------------- | --------------------------------------- |
| message | 2001-3000 |
| file | 3001-4000 |
| user | 4001-6000 |
| operation | 6001-8000 |
| goods | 8001-10000 |
| mmc | 10001-12000 |
| order | 12001-14000 |
