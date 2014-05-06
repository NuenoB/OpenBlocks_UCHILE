package openblocks.shapes;

import java.util.ArrayList;

import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import openmods.shapes.IShapeGenerator;
import openmods.shapes.IShapeable;

public interface IShapeGen extends IShapeGenerator{
	
	/**
	 * Define ciertos detalles a la figura generada
	 * @param entityPos Las coordenadas de la entidad
	 * @param worldObj El worldObject
	 * @return El arreglo con los BlockRepresentation de los detalles a agregar
	 */
	public ArrayList<BlockRepresentation> fill(ChunkCoordinates entityPos, World worldObj);
	
	/**
	 * Devuelve un array con la representación de los bloques que requiere de condición para ejecutar 
	 * el llenado de la figura
	 * @param entityPos Las coordenadas de la entidad
	 * @return El arreglo con los BlockRepresentation que representan las posibles condiciones
	 */
	public ArrayList<BlockRepresentation> fillConditions(ChunkCoordinates entityPos); 

}
