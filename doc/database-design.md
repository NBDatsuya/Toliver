# 数据库设计

## 1. 数据表

| 序号 | 表名                       | 描述             |
|----|--------------------------|----------------|
| 1  | [employee](#21-employee) | 员工信息表          |
| 2  | category                 | 分类信息表，对菜品、套餐分类 |
| 3  | dish                     | 菜品信息表          |
| 4  | dish_flavor              | 菜品口味表          |
| 5  | combo                    | 套餐信息表          |
| 6  | combo_dish               | 套餐-菜品关系表       |
| 7  | customer                 | 顾客信息表          |
| 8  | address                  | 地址信息表          |
| 9  | cart                     | 购物车信息表         |
| 10 | order_info               | 订单基本信息表        |
| 11 | order_detail             | 订单明细信息表        |

## 2. 详细设计

### 2.1 employee

| 字段名  | 数据类型        | 描述   | 备注和约束       |
|------|-------------|------|-------------|
| id   | bigint      | 员工id | PRIMARY KEY |
| name | varchar(64) | 员工姓名 |             |
| username       | varchar(32) | 用户名 | NOT REPEATABLE |
| password | varchar(255) | 密码 |  |
| phone | varchar(24) | 手机号 |  |
| gender | enum{"M","F","O"} | 性别 |  |
| id_number | varchar(32) |  |  |
| status | int |  | 0-锁定，1-启用 |
| create_time | timestamp |  |  |
| update_time | timestamp |  |  |
| created_by | bigint |  | FOREIGN KEY |
| updated_by | bigint |  | FOREIGN KEY |



### 2. category

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



### 3. dish

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
