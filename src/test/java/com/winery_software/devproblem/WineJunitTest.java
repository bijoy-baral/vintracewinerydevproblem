package com.winery_software.devproblem;

import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.mockito.Mockito;

import com.winery_software.devproblem.utils.VintraceWineryUtils;

public class WineJunitTest {

	/**
	 * Method to verify successful execution of main method.
	 */
	@Test
	public void testMain() {
		WineTest.main(null);
	}

	/**
	 * Method to verify successfully print variety breakdown information.
	 */
	@Test
	public void testPrintVarietyBreakdown() {
		Wine wineMock = mockWineData();
		VintraceWineryUtils.printRegionBreakdown(wineMock);
	}

	/**
	 * Method to verify successfully print year breakdown information.
	 */
	@Test
	public void testPrintYearBreakdown() {
		Wine wineMock = mockWineData();
		VintraceWineryUtils.printYearBreakdown(wineMock);
	}

	/**
	 * Method to verify successfully print region breakdown information.
	 */
	@Test
	public void testPrintRegionBreakdown() {
		Wine wineMock = mockWineData();
		VintraceWineryUtils.printRegionBreakdown(wineMock);
	}

	/**
	 * Method to verify successfully print year and variety breakdown information.
	 */
	@Test
	public void testPrintYearAndVarietyBreakdown() {
		Wine wineMock = mockWineData();
		VintraceWineryUtils.printYearAndVarietyBreakdown(wineMock);
	}

	/**
	 * Method is used to set mock data for varieties of wines.
	 * 
	 * @return Wine
	 */
	private Wine mockWineData() {
		Wine wineMock = Mockito.mock(Wine.class);
		when(wineMock.getLotCode()).thenReturn("11YVCHAR001");
		when(wineMock.getVolume()).thenReturn(Double.valueOf(1000.0));
		when(wineMock.getDescription()).thenReturn("2011 Yarra Valley Chardonnay");
		when(wineMock.getTankCode()).thenReturn("T25-01");
		when(wineMock.getProductState()).thenReturn("Ready for bottling");
		when(wineMock.getOwnerName()).thenReturn("YV Wines Pty Ltd");
		final Set<GrapeComponent> grapeComponents = new HashSet<>();
		final GrapeComponent grapeComponent = new GrapeComponent();
		grapeComponent.setPercentage(80D);
		grapeComponent.setYear(2011);
		grapeComponent.setRegion("Yarra Valley");
		grapeComponent.setVariety("Chardonnay");
		final GrapeComponent grapeComponent2 = new GrapeComponent();
		grapeComponent2.setPercentage(10D);
		grapeComponent2.setYear(2010);
		grapeComponent2.setRegion("Macedon");
		grapeComponent2.setVariety("Chardonnay");
		grapeComponents.add(grapeComponent);
		grapeComponents.add(grapeComponent2);
		when(wineMock.getComponents()).thenReturn(grapeComponents);
		return wineMock;
	}
}
