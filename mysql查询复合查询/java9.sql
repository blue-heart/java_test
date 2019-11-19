有一个商店的数据，记录客户及购物情况，有以下三个表组成：
商品goods(商品编号goods_id，商品名goods_name, 单价unitprice, 商品类别category, 供应商provider)
客户customer(客户号customer_id,姓名name,住址address,邮箱email,性别sex，身份证card_id)
购买purchase(购买订单号order_id,客户号customer_ id,商品号goods_ id,购买数量nums)
要求：
每个表的主外键
客户的姓名不能为空值
邮箱不能重复
客户的性别(男，女)

create database if not exists shops charset=utf8 collate utf8_bin engine innodb;

商品goods(商品编号goods_id，商品名goods_name, 单价unitprice, 商品类别category, 供应商provider)
客户customer(客户号customer_id,姓名name,住址address,邮箱email,性别sex，身份证card_id)
购买purchase(购买订单号order_id,客户号customer_ id,商品号goods_ id,购买数量nums)

create table if not exists goods(
goods_id int primary key auto_increment comment'商品编号',
goods_name varchar(20) not null comment'商品名称',
unitprice fioat(6,2) not null default 0 comment'商品单价',
category varchar(10) not null comment'商品类别',
);

create table if not exists customer(
customer_id int primary key auto_increment comment'客户编号',
name varchar(10) not null comment'客户姓名',
email varchar(10) unique comment'用户邮箱',
sex  enum('男','女') default'男'comment'客户性别',
card_id char(18) unique comment'客户身份证'
);


create table if not exists purchase(
order_id int primary key auto_increment comment'购买订单号',
customer_id int comment'客户编号',
goods_id int comment'商品编号',
nums  int  not null comment'购买数量',
foreign key (goods_id)references goods(goods_id),
foreign key (customer_id)references customer(customer_id)
);

select * from exam_result
where  name like '孙_' or (yuwen+shuxue+yingyu)>200 
and yuwen<shuxue
and yingyu>80;

select name,yuwen,shuxue,yingyu
from exam_result
order by yingyu desc,shuxue asc, yuwen asc;


查询工资高于500或岗位为MANAGER的雇员，同时还要满足他们的姓名首字母为大写的J
select ename,sal,job
from emp
where (sal>500 or job = 'MANAGER')
and ename like 'J%';

按照部门号升序而雇员的工资降序排序
 select ename,deptno,sal from emp order by deptno,sal desc;

使用年薪进行降序排序
select ename,sal*12+ifnull(comm,0) total from emp order by total desc;

显示工资最高的员工的名字和工作岗位
select ename,job from emp where sal = (select max(sal) from emp);

显示工资高于平均工资的员工信息
select ename,job from emp where sal >(select avg(sal) from emp);

显示每个部门的平均工资和最高工资
select deptno,format(avg(sal),2),max(sal) from emp group by deptno;

显示平均工资低于2000的部门号和它的平均工资
select deptno,avg(sal) from emp group by deptno having avg(sal)<2000;

显示每种岗位的雇员总数，平均工资

select job,avg(sal),count(*),job from emp group by job;

显示雇员名、雇员工资以及所在部门的名字因为上面的数据来自EMP和DEPT表，

select emp.ename,emp.sal,dept.dname from emp,dept where emp.deptno=dept.deptno;

显示部门号为10的部门名，员工名和工资

select dept.deptno,dname,ename,sal
from emp,dept
where emp.deptno = dept.deptno
and dept.deptno=10; 
两张表都有 必须加表名
显示各个员工的姓名，工资，及工资级别
select emp.ename,emp.sal,s.grade 
from emp,salgrade s
where sal between s.losal and s.hisal;

必须有关联关系 这个就是一个数值 在一个范围之中

自连接

显示员工FORD的上级领导的编号和姓名（mgr是员工领导的编号--empno）

select empno,ename
from emp
where empno=(select mgr from emp where ename='FORD');
就是 让领导的号码 等于 员工的号码 表里有两个 号码属性的

双表写法 就是上面要写领导表 因为要找领导
select l.empno,l.ename
from emp w,emp l
where w.mgr = l.empno
and w.ename='FORD'

子查询
显示SMITH同一部门的员工
select ename,deptno,job,sal
from emp
where deptno=(select deptno from emp where ename='SMITH');

查询和10号部门的工作相同的雇员的名字，岗位，工资，部门号，但是不包含10自己的
select ename,job,sal,deptno
from emp
where job in
(select job from emp where deptno=10);
多个岗位用in  in 是在之中一个岗位用=

显示工资比部门30的所有员工的工资高的员工的姓名、工资和部门号
select ename,sal,deptno
from emp
where sal>(select max(sal) from emp where deptno=30);

select ename,sal,deptno
from emp
where sal> all (select sal from emp where deptno=30);

all 关键字 所有的

显示工资比部门30的任意员工的工资高的员工的姓名、工资和部门号

select ename,sal,deptno
from emp
where sal>(select min(sal) from emp where deptno=30);

要用下面 因为这个只有一条 有几条 就要用下面 否则显示两条以上

select ename,sal,deptno
from emp
where sal> any(select sal from emp where deptno=30);

查询和SMITH的部门和岗位完全相同的所有雇员，不含SMITH本人

select ename,deptno,job,sal
from emp
where (deptno,job) =(select deptno,job from emp where ename='SMITH');


select ename,deptno,job,sal
from emp
where deptno =(select deptno from emp where ename='SMITH')
and job=(select job from emp where ename='SMITH');



























