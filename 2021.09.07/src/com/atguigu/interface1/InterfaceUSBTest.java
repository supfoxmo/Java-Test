package com.atguigu.interface1;

//接口的使用上体现了多态性
public class InterfaceUSBTest {
	public static void main(String[] args) {
		Computer1 com = new Computer1();
		Flash flash = new Flash();
		com.tranferDate(flash);
		
		System.out.println("**********************");
		//匿名实现类的非匿名对象
		USB usb = new USB() {

			@Override
			public void start() {
				System.out.println("通过匿名实现类的非匿名对象实现U盘开启传输工作");
				
			}

			@Override
			public void stop() {
				System.out.println("通过匿名实现类的非匿名对象实现U盘关闭传输工作");
				
			}
			
		};
		
		com.tranferDate(usb);
		
	}

}

class Computer1{
	public Computer1() {
		super();
	}
	
	public void tranferDate(USB usb) { 
		usb.start();
		
		System.out.println("具体传输数据的细节");
		
		usb.stop();
	}
	
}

interface USB{
	public abstract void start();
	public abstract void stop();
}

class Flash implements USB{

	@Override
	public void start() {
		System.out.println("U盘开启传输工作");
	}


	@Override
	public void stop() {
		System.out.println("U盘关闭传输工作");
		
	}
	
}
