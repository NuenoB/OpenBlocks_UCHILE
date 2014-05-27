package openblocks.client.gui;

import net.minecraft.client.gui.GuiButton;

public class GuiBattleButton extends GuiButton{
	private static int heightButton = 20, widthButton = 80;
	private static int height, width;

	public GuiBattleButton(int par1, int par2, int par3, int par4, int par5,
			String par6Str) {
		super(par1, par2, par3, par4, par5, par6Str);
		// TODO Auto-generated constructor stub
	}
	
	public GuiBattleButton(int idCasillero , String string){
		super(idCasillero,getPosXbyId(idCasillero),getPosYbyId(idCasillero),widthButton,heightButton,string);
	}
	
	public GuiBattleButton(int idCasillero, int x, int y, String string ){
		super(idCasillero, getPosXbyId(idCasillero)+x,getPosYbyId(idCasillero)+y, widthButton, heightButton, string );
	}
    public void setResolution(int height, int width){
    	this.height = height;
    	this.width = width;
    }
	private static int getPosYbyId(int idCasillero) {
		switch(idCasillero){
		case 0:
			return width*5/6 - 40;
		case 1:
			return width*2/6 - 40;
		case 2:
			return width*4/6 - 40;
		case 3:
			return width*1/6 - 40;
		case 4:
			return width*3/6 - 40;
		case 6:
			return width/2 - 88;
		default:
			return 0;
		}
	}

	private static int getPosXbyId(int idCasillero) {
		switch(idCasillero){
		case 0:case 1: case 2: case 3: case 4:
			return height - 72;
		case 6:
			return height - 19;
		default:
			return 0;
		}
	}

}
