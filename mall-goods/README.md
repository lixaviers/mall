## 商品中心
对应数据库为：suyan_goods
<br>

#### 一、什么是商品中心
从使用层面来讲，商品中心分为前端和后端<br>
前端商品为商城、购物车、订单、营销活动等提供商品基础数据支撑；后端为供应商管理、采购订单等提供数据支持。

#### 二、基础名词
1.SPU（Standard Product Unit）<br>
标准化产品单元。是商品信息聚合的最小单位，是一组可复用、易检索的标准化信息的集合，该集合描述了一个产品的特征。<br>
如iPhone12就是一个SPU

2.SKU（Stock Keeping Unit）<br>
库存控制的最小可用单位。


| 功能列表                                 | 状态                                                  |
| --------------------------------------- | --------------------------------------- |
| 商品多规格 | 已完成 Goods、GoodsSku |
| 商品类目属性 | 已完成 GoodsCategory、GoodsCategoryAttribute、GoodsCategoryValue |
| 前后台类目聚合 | 已完成 GoodsCategoryRelation，差一个中台类目 |
