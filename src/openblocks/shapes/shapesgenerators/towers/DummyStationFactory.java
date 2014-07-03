package openblocks.shapes.shapesgenerators.towers;

public class DummyStationFactory implements IStationFactory{

	@Override
	public HoleStationShapeGenerator produceN() {
		return new DummyStationShapeGenerator();
	}

	@Override
	public HoleStationShapeGenerator produceS() {
		return new DummyStationShapeGenerator();
	}

	@Override
	public HoleStationShapeGenerator produceO() {
		return new DummyStationShapeGenerator();
	}

	@Override
	public HoleStationShapeGenerator produceE() {
		return new DummyStationShapeGenerator();
	}

}
