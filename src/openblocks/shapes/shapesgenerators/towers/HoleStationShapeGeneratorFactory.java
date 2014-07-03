package openblocks.shapes.shapesgenerators.towers;

public class HoleStationShapeGeneratorFactory implements IStationFactory{

	@Override
	public HoleStationShapeGenerator produceN() {
		return new HoleStationShapeGeneratorN();
	}

	@Override
	public HoleStationShapeGenerator produceS() {
		return new HoleStationShapeGeneratorS();
	}

	@Override
	public HoleStationShapeGenerator produceO() {
		return new HoleStationShapeGeneratorO();
	}

	@Override
	public HoleStationShapeGenerator produceE() {
		return new HoleStationShapeGeneratorE();
	}

}
