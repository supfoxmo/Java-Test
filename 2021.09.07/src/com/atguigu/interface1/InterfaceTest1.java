package com.atguigu.interface1;

public class InterfaceTest1 {
	public static void main(String[] args) {
		Computer com = new Computer();
		com.photo();
		com.video();
		com.novel();
	}

}

interface TakePhoto{
	public abstract void photo();
}

interface TakeVideo{
	public abstract void video();
}
//接口之间可以多继承
interface ReadNovel extends TakePhoto,TakeVideo{
	public abstract void novel();
	
}

