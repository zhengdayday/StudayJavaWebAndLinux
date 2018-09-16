* SQL支持以下三种注释
```mysql
# 注释
-- 注释
/*
  注释 
*/ 
```
* 数据库的创建与使用
```mysql
create database test;
use test;
```

* 创建表
```mysql
create table mytable (
  id int not null auto_increment,
  col1 int not null default 1,
  col2 varchar(45) null,
  primary key ('id')
);
```
* 修改表
    * 添加列
    ```mysql
    alter table mytale add col char(20);
    ```
    * 删除列
    ```mysql
    drop table mytable;
    ```
    * 删除表
    ```mysql
    drop table mytable;
    ```
* 插入
    * 普通插入
    ```mysql
    insert into mytable(col1, col2) values(val1, val2);
    ```
    * 插入检索出来的数据
    ```mysql
    insert into mytable1(col1, clo2) 
    select col1,col2 from mytabl2; 
    ```
    * 将一个表的内容插入到一个新表
    ```mysql
    create table newtable as select * from mytable;

* 更新
```mysql
update mytable set col = val where id = 1;
```
* 删除
```mysql
delete from mytable where id = 1;
```
* truncate table 可以清空表数据但是不删除表
```mysql
truncate table mytable;
```
* 使用更新和删除操作一定要用where自居，不然会把整张表的数据都破坏。
* 查询
    * distinct
        * 相同值只会出现一次，它作用于所有列，也就是说所有列的值都相同才算相同。
        ```mysql
        select distinct col1,col2 from mytable;
        ```
    * limit
        * 限制返回的行数。可以有两个参数，第一个参数为开始行，从0开始，第二个参数为返回的总行数。
        * 返回前五行
        ```mysql
        select * from mytable limit 5;
        select * from mytable limit 0, 5;
       ```
        * 返回3~5行
        ```mysql 
        select * from mytable limit 2,3;
        ```
    * 排序
        * asc 升序（默认）
        * desc 降序
        * 可以按多个列进行排序，并且为每个列指定不同的排序方式
        ```mysql
        select * from mytable order by col1 desc, clo2 asc;
        ```
    * 过滤
        * <> != 不等于
        * <= !> 小于等于
        * >= !< 大于等于
        * between 在两个值之间
        * is null 为null的值
        * and 和 or用于多个过滤 条件，优先处理and
        * in操作符用于匹配一组值，其后也可以接一个select子句，从而匹配子查询得到一组值。
        * not操作符用于否定一个条件
    * 通配符
        * 通配符也是过滤语句中，但它只能用于文本字段。
        * %匹配 >= 0个任意字符;
        * _匹配 == 1个任意字符;
        * []可以匹配集合内的字符，
* 计算字段
    * as 来取别名
    * concat()用于连接两个字段
    ```mysql
    select  concat(trim(col1), '(',trim(col2),')') as concat_col from mytable;
    ``` 
* 函数
    * left() 左边的字符
    * right() 右边的字符
    * lower() 转换为小写字符
    * upper() 转换为大写字符
    * ltrim() 去除左边的空格
    * rtrim()去除右边的空格
    * length() 长度
    * soundex() 转换为语音值
        * 可以将一个字符串转换为描述其语音表示的字母数字模式    
        ```mysql
        select * from mytable where soundex(col1) = soundex('apple');
        ```
    * 日期和时间处理
        * 日期格式YYYY-MM-DD
        * 时间格式HH:MM:SS 
        * 函数 
            * AddDate() 增加一个日期
            * AddTime() 增加一个时间
            * CurDate() 返回当前日期
            * CurTime() 返回当前时间
            * Date() 返回日期时间的日期部分
            * DateDiff() 计算两个日期之差 
            * Date_Add() 高度灵活的日期运算函数
            * Date_Format() 返回一个格式化的日期或时间串
            * Day() 返回一个日期的天数部分
            * DayOfWeek() 对于一个日期，返回对应的星期几
            * Hour() 返回一个时间的小时部分
            * Minute() 返回一个时间的分钟部分
            * Month() 返回一个日期的月份部分
            * Now() 返回当前日期和时间
            * Second() 返回一个时间的秒部分
            * Time() 返回一个日期时间的时间部分
            * Year() 返回一个日期的年份部分
    * 数值处理
        * sin()
        * cos()
        * tan()
        * abs() 绝对值
        * sqrt() 平方根
        * mod() 余数
        * exp() 指数
        * pi() 圆周率
        * rand() 随机数
* 分组
    * 分组就是把具有相同的数据值的行放在同一组中 
    * 可以对同一分组数据使用汇总函数处理
    ```mysql
    select col , count(*) as num from mytable group by col;
    ```                         
    * having过滤分组，where过滤行，行过滤应该优先于分组
    * 分组规定
        * group by 子句出现在where子句之后，order by 子句之前
        * 除了汇总字段外，select 语句中的每一字段都必须在group by子句中给出
        * null的行会单独分为自足
        * 大多数SQL实现不支持group by 列具有可变长度的数据类型
        
        
    

  
    
