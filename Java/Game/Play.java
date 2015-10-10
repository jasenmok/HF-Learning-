import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Play extends JPanel implements KeyListener
{
	int i=0,j=0,velx=0,vely=0;
	int x=0,y=75,w=60,h=60,he=0,k=700,p=0;

	boolean right = false,left = false,collision = false,pl = false,kr = false;

	int cx,cy;



	public void increment()
	{
		
		cx = i+=velx;
		cy = j+=vely;
		if(i<=0) i=0;
		if(j<=0) j=0;
		if(i+w>=1000)
		{
			i=1000-w;
		}
		if(j+h>=500)
		{
			j=500-h;
		}

		
		//moving for x

		if(x==970)
			right = true;
		if(x==0)
			right = false;
		if(right)
			x--;
		else
			x++;

		//moving for y

		if(y==440)
			left = true;
		if(y==0)
			left = false;
		if(left)
			y--;
		else
			y++;

		//another

		if(k==970)
			kr = true;
		if(k==0)
			kr = false;
		if(kr)
			k--;
		else
			k++;

		//moving for y

		if(p==440)
			pl = true;
		if(p==0)
			pl = false;
		if(pl)
			p--;
		else
			p++;
	}

		int count=he++;

	//drawing graphics
	public void paintComponent(Graphics g)
	{
			
			Image bk=new ImageIcon("bg.jpg").getImage();
			Image bat=new ImageIcon("bat1.png").getImage();
			Image det=new ImageIcon("det1.png").getImage();
			Image joker=new ImageIcon("joker1.png").getImage();
			Image pengi=new ImageIcon("pengi3.png").getImage();
			Image pegi3=new ImageIcon("pegi1.png").getImage();
			Image har=new ImageIcon("har1.png").getImage();
			Image df=new ImageIcon("df1.png").getImage();
			Image hal1=new ImageIcon("hal2.png").getImage();
			Image ban2=new ImageIcon("ban2.png").getImage();
			Image ban=new ImageIcon("ban.png").getImage();
			
			Rectangle r1 = new Rectangle(i,j,60,60);
			Rectangle r2 = new Rectangle(x,y,60,60);
			Rectangle r3 = new Rectangle(10,y,60,60);
			Rectangle r4 = new Rectangle(x,100,60,60);
			Rectangle r5 = new Rectangle(320,y,60,60);
			Rectangle r6 = new Rectangle(x,400,60,60);
			Rectangle r7 = new Rectangle(620,y,60,60);
			Rectangle r8 = new Rectangle(x,226,60,60);
			Rectangle r9 = new Rectangle(k,p,60,60);
			Rectangle r10 = new Rectangle(920,y,60,60);

				


			g.drawImage(bk,0,0,this);
			g.setColor(Color.BLUE);
			g.fillRect(r1.x,r1.y,r1.width,r1.height);
			g.drawImage(bat,i,j,this);
			
			g.setColor(Color.RED);
			g.fillRect(r2.x,r2.y,r2.width,r2.height);
			g.drawImage(joker,x,y,this);

			g.setColor(Color.RED);
			g.fillRect(r3.x,r3.y,r3.width,r3.height);
			g.drawImage(har,10,y,this);

			g.setColor(Color.RED);
			g.fillRect(r4.x,r4.y,60,60);
			g.drawImage(df,x,100,this);					

			g.setColor(Color.RED);
			g.fillRect(r5.x,r5.y,r5.width,r5.height);
			g.drawImage(pegi3,320,y,this);

			g.setColor(Color.RED);
			g.fillRect(r6.x,r6.y,r6.width,r6.height);
			g.drawImage(pengi,x,400,this);

			g.setColor(Color.RED);
			g.fillRect(r7.x,r7.y,r7.width,r7.height);
			g.drawImage(det,620,y,this);

			g.setColor(Color.RED);
			g.fillRect(r8.x,r8.y,r8.width,r8.height);
			g.drawImage(hal1,x,226,this);

			g.setColor(Color.RED);
			g.fillRect(r9.x,r9.y,r9.width,r9.height);
			g.drawImage(ban2,k,p,this);

			g.setColor(Color.RED);
			g.fillRect(r10.x,r10.y,r10.width,r10.height);
			g.drawImage(ban,920,y,this);


			if(r1.intersects(r2) || r1.intersects(r3) || r1.intersects(r4) || r1.intersects(r5) || r1.intersects(r6) || r1.intersects(r7) || r1.intersects(r8) || r1.intersects(r9))
			{
				collision = true;
			}

			if(collision)
			{

				g.setColor(Color.BLACK);
				g.setFont(new Font("serif",Font.BOLD+Font.ITALIC,100));
				g.drawString("Game Over",270,260);

			}
			
	}

	

	// key input
	public void keyPressed(KeyEvent e) 
	{
		 System.out.println("test");
		int key = e.getKeyCode();
		
			switch(key)
			{
			case KeyEvent.VK_W:
				vely=-2;
				break;
			case KeyEvent.VK_A:
				velx-=2;
				break;
			case KeyEvent.VK_D:
				velx=+2;
				break;
			case KeyEvent.VK_S:
				vely=+2;
				break;
			}
		
	}



	
	public void keyReleased(KeyEvent e) 
	{
		int key = e.getKeyCode();
		
			switch(key)
			{
			case KeyEvent.VK_W:
				vely=0;
				break;
			case KeyEvent.VK_S:
				vely=0;
				break;
			case KeyEvent.VK_A:
				velx=0;
				break;
			case KeyEvent.VK_D:
				velx=0;
				break;
			}
		
		
	}

	public void keyTyped(KeyEvent e) { }
	

	
}
