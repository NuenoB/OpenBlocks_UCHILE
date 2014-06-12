package openblocks.shapes.shapesgenerators.towers;

public class RailIntermedioShapeGeneratorFactory implements IStationFactory {

	@Override
	public HoleStationShapeGenerator produceN() {
		return new RailIntermedioShapeGenerator();
	}

	@Override
	public HoleStationShapeGenerator produceS() {
		return new RailIntermedioShapeGenerator();
	}

	@Override
	public HoleStationShapeGenerator produceO() {
		return new RailIntermedioShapeGenerator();
	}

	@Override
	public HoleStationShapeGenerator produceE() {
		return new RailIntermedioShapeGenerator();
	}		

}
