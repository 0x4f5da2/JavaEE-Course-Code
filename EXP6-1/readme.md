# JavaEE上机实验6
## 简要内容

* struts2拦截器

* struts2数据校验

## 遇到的坑

* `strut.xml`中拦截器要放在package前面

* 再配置某一action中的拦截器的时候不能没有`<interceptor-ref name="defaultStack"/>`