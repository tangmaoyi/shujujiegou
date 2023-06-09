package com.tang;

public interface List {
    /*
     清除所有元素
    */
    void clear();


    /*
     获取元素的数据大小
     */
   int size();

    /*
    判断是否为空
     */
     boolean isEmpty() ;

    /*
     是否包含
     */
     boolean contains() ;


    /*
    添加元素到最后面
     */
      void add() ;


    /*
    返回对应索引的元素
     */
      int get(int index) ;

    /*
     设置index位置的元素
     */
    int set(int index, int element);

    /*
     在index位置添加元素
     */
  void add(int index, int element) ;

    /*
    删除index位置对应的元素
     */
   int remove(int index);

    /*
     查看元素索引
     */
    int indexOf(int element) ;
}
