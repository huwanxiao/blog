# 讲一下post请求怎样才能传送数据到服务器。
## 1.回顾一下ajax请求是怎么发送post请求的
document.getElementById("btn").onclick = () => {
    let xhr = new XMLHttpRequest();    //新建一个请求对象
    xhr.onreadystatechange = () => {  //请求状态码改变时调用
        if (xhr.readyState == 4 && xhr.status == 200) {      //请求已完成，响应已就绪且返回成功
            alert("请求成功"+xhr.responseText);              //匿名函数这里不能用this.xxx。记录个坑
          }
        };
    xhr.open("POST", "./2.php");    //请求路径
    **xhl.setRequestHeader('Content-type','application/x-www-form-data-urlencoded')**
    //get请求可以不写请求头,但是post请求必须写
    xhr.send("user='lisi'&age=23");      //发送请求,里面写需要传送的数据
};
## 2.xhl.setRequestHeader
请求头必须写,要不然post请求根本发不出去,发出去了服务器也收不到
## 3.讲一下问为什么以及两种请求头:application/x-www-form-data-urlencoded和application/form-data的区别
### ①post、get请求提交的数据要进行urlencoded编码之后再传输
举个例子:打开百度,搜索"nodejs的有哪些",再把url复制过来,中文全被转码了(英文转码后不变),这就是转码后的数据。我们看到中文其实是浏览器把url处理了(自己动手试一下)。qureystring的作用也是把转码后的内容再还原回来
https://www.baidu.com/s?wd=nodejs%E7%9A%84%E4%BC%98%E7%82%B9%E6%9C%89%E5%93%AA%E4%BA%9B&rsv_spt=1&rsv_iqid=0x993ad91800005f56&issp=1&f=8&rsv_bp=1&rsv_idx=2&ie=utf-8&tn=baiduhome_pg&rsv_enter=1&rsv_dl=ib&rsv_sug3=57&rsv_sug1=31&rsv_sug7=101
### ②为什么我们必须写请求头
因为我们的请求中含有编码不同的字符,对于不同类型的字符和数据,需要用统一的规则转码,这样计算机才能识别
### ③x-www-form-data-urlencoded与form-data的区别
- 都是对表单的数据进行转码。form-data会把表单的所有数据打包在一个大的对象里面进行传输。
- form-data源于ajax的升级,让我们能够通过ajax的形式对图片进行文件上传。使用js对整个表单使用form-data对象进行打包，包括浏览器度过来的文件。把对象交给服务器,服务器对对象进行解析
- form-data是x-www-form-data-urlencoded具有相同功能的另一种实现