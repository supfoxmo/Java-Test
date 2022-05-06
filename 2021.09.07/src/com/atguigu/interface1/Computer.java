package com.atguigu.interface1;
//类可以实现多个接口，从一定程度上弥补了类不能多继承
public class Computer implements TakeVideo, TakePhoto, ReadNovel {

	@Override
	public void novel() {
		System.out.println("用电脑看小说");
		
	}

	@Override
	public void video() {
		System.out.println("用电脑录视频");
		
	}

	@Override
	public void photo() {
		System.out.println("用电脑拍照片");
		
	}
	

}
