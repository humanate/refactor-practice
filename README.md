## 背景
这是一个影片出租店用的程序，计算每一位顾客的消费金额并打印详单，操作者告诉程序：顾客租了哪些影片，租期多长，程序便根据租赁时间和影片类型算出费用。影片分为三类：普通片、儿童片和新片。除了计算费用，还要为常客计算积分，积分会根据租片种类是否为新片而有不同。
### example:
```
Rental Record for user1
	regular movie	3.5
	new movie	6.0
	children movie	4.5
Amount owed is 14.0
You earned 4 frequent renter points
```
## 新需求
用户希望以HTML格式输出详单，这样就可以直接在网页进行显示，这非常符合时下的潮流。
### example:
```
<H1>Rentals for <EM>user1</EM></H1><P>
regular movie: 3.5<BR>
new movie: 6.0<BR>
children movie: 4.5<BR>
<P>You owe <EM>14.0</EM><P>
On this rental you earned <EM>4</EM> frequent renter points<P>
```
用户希望改变影片的分类规则，但还没决定怎么改。

## 要求
根据新需求的要求对代码进行重构，使其更加符合面向对象精神，并添加HTML格式的输出详单实现。