package next;

import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Generation {
    private int p[][];
    private int count[][];
    public Generation() {
    	count=new int[31][31];//��ʼ��ֵ0
		p=new int[32][32];//��ʼ��ֵ0
		Random random = new Random();//Ĭ�Ϲ��췽��
		for(int i=1; i<31; i++)
			for(int j=1;j<31;j++) {
				int x=random.nextInt(2);
				p[i][j]=x;
			}
	}
    //���Ը�������
    public void clear() {
    	for(int i=0;i<32;i++) {
			Arrays.fill(p[i], 0);
		}
    }
    public void set(int i,int j,int x) {
    	p[i][j]=x;
    }
    //��ȡi,j�����״̬
    public int select(int i,int j) {
		/*if(p[i][j]==0)
			return 0;
		else
			return 1;*/
		return p[i][j];
	}
    
    //���Ժ������ڿ���̨��ӡ����״̬
	/*public void printTheLife() {
		for(int i=0;i<32;i++) {	
			System.out.println(Arrays.toString(p[i]));
		}
	}*/
	
	//��ȡÿ���������ΧΪ����ϸ������
	public int getNeighborCount(int m,int n) {
			int count=0;
			for(int i=m-1;i<=m+1;i++)
				for(int j=n-1;j<=n+1;j++)
					count+=select(i,j);
			count=count-select(m, n);
			return count;
				
	}

	//һ�ε���������ÿ��ϸ��������״̬
	public void update() {
		//��ȡÿ��ϸ����Χ�Ļ�ϸ����Ŀ
		for(int i=1;i<31;i++) {
			for(int j=1;j<31;j++) {
				count[i][j]=getNeighborCount(i,j);
			}
		}	
		for(int i=1;i<31;i++) {
			for(int j=1;j<31;j++) {
				switch(count[i][j]) {
				case 3:
					p[i][j]=1;
					break;
				case 2:
					break;
				default:
					p[i][j]=0;
					break;
				}
			}
		}
	}
	
	/*
	public void start() {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
				update();		
				printTheLife();	
				System.out.println();
			}
		},0,500);
	}
	*/
	public static void main(String[] args)
	{
		Generation g=new Generation();
		/*g.printTheLife();
		g.update();
		System.out.println();
		g.printTheLife();*/
		g.clear();
		//g.printTheLife();
	}
}
