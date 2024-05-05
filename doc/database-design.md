# 数据库设计

## 1. 数据表

| 序号 | 表名                              | 描述                         |
| ---- | --------------------------------- | ---------------------------- |
| 1    | [employee](#21-employee)          | 员工信息表                   |
| 2    | [category](#22-category)          | 分类信息表，对菜品、套餐分类 |
| 3    | [dish](#23-dish)                  | 菜品信息表                   |
| 4    | [dish_flavor](#24-dish_flavor)    | 菜品口味表                   |
| 5    | [combo](#25-combo)                | 套餐信息表                   |
| 6    | [combo_dish](#26-combo_dish)      | 套餐-菜品关系表              |
| 7    | [customer](#27-customer)          | 顾客信息表                   |
| 8    | [address](#28-address)            | 地址信息表                   |
| 9    | [cart](#29-cart)                  | 购物车信息表                 |
| 10   | [order_info](#210-order_info)     | 订单基本信息表               |
| 11   | [order_detail](#211-order_detail) | 订单明细信息表               |

## 2. 详细设计

### 2.1 employee

| 字段名  | 数据类型        | 描述   | 备注和约束       |
|------|-------------|------|-------------|
| id   | bigint      | 员工id | PRIMARY KEY |
| name | varchar(64) | 员工姓名 |             |
| username       | varchar(32) | 用户名 | UNIQUE |
| password | varchar(255) | 密码 |  |
| phone | varchar(24) | 手机号 |  |
| gender | enum{"M","F","O"} | 性别 |  |
| id_number | varchar(32) |  |  |
| status | int |  | 0-锁定，1-启用 |
| create_time | timestamp |  |  |
| update_time | timestamp |  |  |
| created_by | bigint |  | FOREIGN KEY |
| updated_by | bigint |  | FOREIGN KEY |



### 2.2. category

| 字段名      | 数据类型      | 说明         | 备注                 |
| ----------- | ------------- | ------------ | -------------------- |
| id          | bigint        | 主键         | 自增                 |
| name        | varchar(32)   | 分类名称     | 唯一                 |
| type        | enum{"D","C"} | 分类类型     | D菜品分类  C套餐分类 |
| sort        | int           | 排序字段     | 用于分类数据的排序   |
| status      | int           | 状态         | 1启用 0禁用          |
| create_time | timestamp     | 创建时间     |                      |
| update_time | timestamp     | 最后修改时间 |                      |
| created_by  | bigint        | 创建人id     |                      |
| updated_by  | bigint        | 最后修改人id |                      |



### 2.3. dish

| 字段名      | 数据类型      | 说明         | 备注        |
| ----------- | ------------- | ------------ | ----------- |
| id          | bigint        | 主键         | 自增        |
| name        | varchar(32)   | 菜品名称     | 唯一        |
| category_id | bigint        | 分类id       | 逻辑外键    |
| price       | decimal(10,2) | 菜品价格     |             |
| image       | longtext      | 图片路径     |             |
| description | longtext      | 菜品描述     |             |
| status      | int           | 售卖状态     | 1起售 0停售 |
| create_time | timestamp     | 创建时间     |             |
| update_time | timestamp     | 最后修改时间 |             |
| create_by   | bigint        | 创建人id     |             |
| update_by   | bigint        | 最后修改人id |             |



### 2.4. dish_flavor

| 字段名  | 数据类型     | 说明     | 备注     |
| ------- | ------------ | -------- | -------- |
| id      | bigint       | 主键     | 自增     |
| dish_id | bigint       | 菜品id   | 逻辑外键 |
| name    | varchar(32)  | 口味名称 |          |
| value   | varchar(255) | 口味值   | ?        |



### 2.5. combo

| 字段名      | 数据类型      | 说明         | 备注        |
| ----------- | ------------- | ------------ | ----------- |
| id          | bigint        | 主键         | 自增        |
| name        | varchar(32)   | 套餐名称     | 唯一        |
| category_id | bigint        | 分类id       | 逻辑外键    |
| price       | decimal(10,2) | 套餐价格     |             |
| image       | longtext      | 图片路径     |             |
| description | longtext      | 套餐描述     |             |
| status      | int           | 售卖状态     | 1起售 0停售 |
| create_time | timestamp     | 创建时间     |             |
| update_time | timestamp     | 最后修改时间 |             |
| created_by  | bigint        | 创建人id     |             |
| updated_by  | bigint        | 最后修改人id |             |



### 2.6. combo_dish

| 字段名   | 数据类型      | 说明     | 备注     |
| -------- | ------------- | -------- | -------- |
| id       | bigint        | 主键     | 自增     |
| combo_id | bigint        | 套餐id   | 逻辑外键 |
| dish_id  | bigint        | 菜品id   | 逻辑外键 |
| name     | varchar(32)   | 菜品名称 |          |
| price    | decimal(10,2) | 菜品单价 |          |
| copies   | int           | 菜品份数 |          |

### 2.7. customer



| 字段名      | 数据类型          | 说明               | 备注 |
| ----------- | ----------------- | ------------------ | ---- |
| id          | bigint            | 主键               | 自增 |
| open_id     | longtext          | 微信用户的唯一标识 |      |
| name        | varchar(32)       | 用户姓名           |      |
| phone       | varchar(32)       | 手机号             |      |
| gender      | enum{"M","F","O"} | 性别               |      |
| id_number   | varchar(18)       | 身份证号           |      |
| avatar      | longtext          | 微信用户头像路径   |      |
| create_time | timestamp         | 注册时间           |      |

### 2.8. address_book

| 字段名        | 数据类型          | 说明         | 备注           |
| ------------- | ----------------- | ------------ | -------------- |
| id            | bigint            | 主键         | 自增           |
| user_id       | bigint            | 用户id       | 逻辑外键       |
| consignee     | varchar(50)       | 收货人       |                |
| gender        | enum{"M","F","O"} | 性别称呼     |                |
| phone         | varchar(11)       | 手机号       |                |
| province_code | varchar(12)       | 省份编码     |                |
| province_name | varchar(32)       | 省份名称     |                |
| city_code     | varchar(12)       | 城市编码     |                |
| city_name     | varchar(32)       | 城市名称     |                |
| district_code | varchar(12)       | 区县编码     |                |
| district_name | varchar(32)       | 区县名称     |                |
| detail        | varchar(200)      | 详细地址信息 | 具体到门牌号   |
| label         | varchar(100)      | 标签         | 公司、家、学校 |
| is_default    | tinyint(1)        | 是否默认地址 | 1是 0否        |

### 2.9. shopping_cart

| 字段名      | 数据类型      | 说明         | 备注     |
| ----------- | ------------- | ------------ | -------- |
| id          | bigint        | 主键         | 自增     |
| name        | varchar(32)   | 商品名称     |          |
| image       | varchar(255)  | 商品图片路径 |          |
| user_id     | bigint        | 用户id       | 逻辑外键 |
| dish_id     | bigint        | 菜品id       | 逻辑外键 |
| combo_id    | bigint        | 套餐id       | 逻辑外键 |
| dish_flavor | varchar(50)   | 菜品口味     |          |
| number      | int           | 商品数量     |          |
| amount      | decimal(10,2) | 商品单价     |          |
| create_time | timestamp     | 创建时间     |          |

### 2.10. order_info

| 字段名                  | 数据类型      | 说明         | 备注                                            |
| ----------------------- | ------------- | ------------ | ----------------------------------------------- |
| id                      | bigint        | 主键         | 自增                                            |
| number                  | varchar(50)   | 订单号       |                                                 |
| status                  | int           | 订单状态     | 1待付款 2待接单 3已接单 4派送中 5已完成 6已取消 |
| user_id                 | bigint        | 用户id       | 逻辑外键                                        |
| address_book_id         | bigint        | 地址id       | 逻辑外键                                        |
| order_time              | timestamp     | 下单时间     |                                                 |
| checkout_time           | timestamp     | 付款时间     |                                                 |
| pay_method              | int           | 支付方式     | 1微信支付 2支付宝支付                           |
| pay_status              | tinyint       | 支付状态     | 0未支付 1已支付 2退款                           |
| total                   | decimal(10,2) | 订单金额     |                                                 |
| remark                  | longtext      | 备注信息     |                                                 |
| phone                   | varchar(11)   | 手机号       |                                                 |
| address                 | varchar(255)  | 详细地址信息 |                                                 |
| user_name               | varchar(32)   | 用户姓名     |                                                 |
| consignee               | varchar(32)   | 收货人       |                                                 |
| cancel_reason           | varchar(255)  | 订单取消原因 |                                                 |
| rejection_reason        | varchar(255)  | 拒单原因     |                                                 |
| cancel_time             | timestamp     | 订单取消时间 |                                                 |
| estimated_delivery_time | timestamp     | 预计送达时间 |                                                 |
| delivery_status         | tinyint       | 配送状态     | 1立即送出  0选择具体时间                        |
| delivery_time           | timestamp     | 送达时间     |                                                 |
| pack_amount             | int           | 打包费       |                                                 |
| tableware_number        | int           | 餐具数量     |                                                 |
| tableware_status        | tinyint       | 餐具数量状态 | 1按餐量提供  0选择具体数量                      |

### 2.11. order_detail

| 字段名      | 数据类型      | 说明         | 备注     |
| ----------- | ------------- | ------------ | -------- |
| id          | bigint        | 主键         | 自增     |
| name        | varchar(64)   | 商品名称     |          |
| image       | longtext      | 商品图片路径 |          |
| order_id    | bigint        | 订单id       | 逻辑外键 |
| dish_id     | bigint        | 菜品id       | 逻辑外键 |
| combo_id    | bigint        | 套餐id       | 逻辑外键 |
| dish_flavor | varchar(50)   | 菜品口味     |          |
| amount      | int           | 商品数量     |          |
| price       | decimal(10,2) | 商品单价     |          |

