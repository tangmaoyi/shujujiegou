package com.tang;

import java.util.Arrays;

public class ArrayList {
    private int size;//大小
    private int[] elements;//采用数组存储数据，因此这里指向数组
    private static final int DEFAULT_CAPACITY=10;//默认分配的内存空间
    private static final int ELEMENT_NOT_FOUND=-1;//设置没有找到返回的默认值
    public ArrayList(int capaticy){
        if(capaticy<DEFAULT_CAPACITY){
            capaticy=DEFAULT_CAPACITY;//如果传入的数据小于默认数据大小就采用默任大小
        }
        elements =new int[capaticy];//分配内存空间
        size=0;
    }
    public ArrayList(){
        elements =new int[DEFAULT_CAPACITY];
        size=0;
    }
    /*
     动态扩容
     */
    private void  ensureCapacity(int capacity){
        int oldcapacity=elements.length;//获取创建的内存长度
        if(oldcapacity>=capacity) return;
        int newcapacity=oldcapacity+(oldcapacity>>1);//创建扩容后的内存大小为1.5倍
        int[] newElements=new int[newcapacity];
        for(int i=0;i<size;i++){
            newElements[i]=elements[i];
        }
        elements=newElements;//改变数据指向
        System.out.println("容量已经扩大");
    }

    /*
      清除所有元素
     */
    public void clear() {
        size=0;
        //没有必要销毁之前的数据空间，根据java对象管理，不用担心内存回收
    }

    /*
     获取元素的数据大小
     */
    public int size() {
     return this.size;
    }

    /*
    判断是否为空
     */
    public boolean isEmpty() {
       return this.size==0;//等于0返回true
    }

    /*
     是否包含
     */
    public  boolean contains(int element) {

        return indexOf(element)!=ELEMENT_NOT_FOUND;
    }


    /*
    添加元素到最后面
     */
    public  void add(int element) {
        ensureCapacity(size+1);
       elements[size]=element;
       size++;
    }


    /*
    返回对应索引的元素
     */
    public  int get(int index) {
      rangeCheck(index);
        return elements[index];
    }

    /*
     设置index位置的元素
     */
    public  int set(int index, int element) {
       rangeCheck(index);
        ensureCapacity(size+1);
        int old=elements[index];
        elements[index]=element;

        return old;//返回原来的数据
    }

    /*
     在index位置添加元素
     */
    public void add(int index, int element) {
        if(index<0||index>size){//这里可以大于size;
            throw new IndexOutOfBoundsException("index："+index+",下标出错");
        }//如果传入数据出错，采用处理方式(采用的是异常处理)
        ensureCapacity(size+1);
      for(int i=size-1;i>=index;i--){
          elements[i+1]=elements[i];
      }
      elements[index]=element;
      size++;

    }
  /*
   检查输入小标是否正确
   */
    public void rangeCheck(int index){
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException("index："+index+",下标出错");
        }//如果传入数据出错，采用处理方式(采用的是异常处理)
    }
    /*
    删除index位置对应的元素
     */
    public  int remove(int index) {
       rangeCheck(index);
        int old=elements[index];
        for(int i=index+1;i<size;i++){
            elements[index]=elements[i];
        }
        size--;
        return old;
    }

    /*
     查看元素索引
     */
   public int indexOf(int element) {
       for(int i=0;i<size;i++){
           if(elements[i]==element){
               return i;
           }
       }
       //找不到返回固定的数
        return ELEMENT_NOT_FOUND;
    }

    @Override
    public String toString() {

        StringBuilder string = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                string.append(",");
            }
            string.append(elements[i]);

        } return "ArrayList{" +
                "size=" + size +
                ", elements=" + string +
                '}';
    }
}
