package openmods.structured;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.lang.reflect.Field;

import openmods.utils.FieldAccess;
import openmods.utils.io.IStreamSerializable;
import openmods.utils.io.TypeRW;

import com.google.common.base.Preconditions;

public class ElementField extends FieldAccess<Object> implements IStructureElement {

	public int elementId;
	public final IStreamSerializable<Object> serializer;

	@SuppressWarnings("unchecked")
	public ElementField(Object parent, Field field) {
		super(parent, field);

		Class<?> fieldType = field.getType();
		serializer = (IStreamSerializable<Object>)TypeRW.TYPES.get(fieldType);
		Preconditions.checkNotNull(serializer, "Invalid field type");
	}

	@Override
	public void writeToStream(DataOutput output) throws IOException {
		Object value = get();
		serializer.writeToStream(value, output);
	}

	@Override
	public void readFromStream(DataInput input) throws IOException {
		Object value = serializer.readFromStream(input);
		set(value);
	}
}