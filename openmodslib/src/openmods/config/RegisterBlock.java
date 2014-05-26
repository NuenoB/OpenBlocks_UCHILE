package openmods.config;

import java.lang.annotation.*;

import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import openmods.item.ItemOpenBlock;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface RegisterBlock {
	public static final String DEFAULT = "[default]";
	public static final String NONE = "[none]";

	public @interface RegisterTileEntity {
		public String name();

		public Class<? extends TileEntity> cls();
	}

	public String name();

	public Class<? extends ItemBlock> itemBlock() default ItemOpenBlock.class;

	public Class<? extends TileEntity> tileEntity() default TileEntity.class;

	public RegisterTileEntity[] tileEntities() default {};

	public String unlocalizedName() default DEFAULT;
}
