package openblocks.shapes;

import java.util.ArrayList;

import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import openmods.shapes.IShapeGenerator;
import openmods.shapes.IShapeable;

public interface IShapeGen extends IShapeGenerator{

	/**
	 * Genera una figura y se la aplica al shapeable
	 * 
	 * @param xSize
	 *            Tamaño en el plano x (Width)
	 * @param ySize
	 *            Tamaño en el plano y (Height)
	 * @param zSize
	 *            Tamaño en el plano z (Depth)
	 * @param shapable
	 *            Objeto sobre el cual se genera la figura
	 */
	public void generateShape(int xSize, int ySize, int zSize, IShapeable shapeable);
	
	/**
	 * Define ciertos detalles a la figura generada
	 * @param entityPos Las coordenadas de la entidad
	 * @param worldObj El worldObject
	 * @return El arreglo con los BlockRepresetation de los detalles a agregar
	 */
	public ArrayList<BlockRepresentation> fill(ChunkCoordinates entityPos, World worldObj);
	
	public ArrayList<BlockRepresentation> fillConditions(ChunkCoordinates entityPos); 


}
