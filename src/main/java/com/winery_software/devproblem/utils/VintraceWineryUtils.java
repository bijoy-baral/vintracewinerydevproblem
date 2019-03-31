package com.winery_software.devproblem.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import com.winery_software.devproblem.GrapeComponent;
import com.winery_software.devproblem.Wine;
import com.winery_software.devproblem.constants.VintraceWineryConstants;

public final class VintraceWineryUtils {

	private VintraceWineryUtils() {
		// private constructor to prevent instantiation.
	}

	/**
	 * Method is used to print wine variety breakdown for the required grape
	 * components in descending order based on percentage.
	 *
	 * @param wine
	 */
	public static void printVarietyBreakdown(Wine wine) {
		if(null == wine) {
			return;
		}
		final List<GrapeComponent> grapeComponents = sortGrapeComponents(wine);
		if(CollectionUtils.isEmpty(grapeComponents)) {
			return;
		}
		final List<GrapeComponent> sortedGrapeComponents = new ArrayList<>();
		for (int i = 0; i < grapeComponents.size(); i++) {
			final int year = grapeComponents.get(i).getYear();
			final Double percentage = grapeComponents.get(i).getPercentage();
			final String variety = grapeComponents.get(i).getVariety();
			final String region = grapeComponents.get(i).getRegion();
			final GrapeComponent grapeComponent = new GrapeComponent(percentage, year, variety, region);
			if (!hasSameVariety(variety, sortedGrapeComponents)) {
				sortedGrapeComponents.add(grapeComponent);
			}
		}
		System.out.println(VintraceWineryConstants.WINE_VARIETY_MESSAGE);
		for (int i = 0; i < sortedGrapeComponents.size(); i++) {
			System.out.println(String.format(VintraceWineryConstants.PERCENTAGE_FORMAT, sortedGrapeComponents.get(i).getPercentage()) + " - "
					+ sortedGrapeComponents.get(i).getVariety());
		}
		System.out.println('\n');
	}

	/**
	 * Method is used to print wine year breakdown for the required grape components
	 * in descending order based on percentage.
	 *
	 * @param wine
	 */
	public static void printYearBreakdown(Wine wine) {
		if(null == wine) {
			return;
		}
		final List<GrapeComponent> grapeComponents = sortGrapeComponents(wine);
		if(CollectionUtils.isEmpty(grapeComponents)) {
			return;
		}
		final List<GrapeComponent> sortedGrapeComponents = new ArrayList<>();
		for (int i = 0; i < grapeComponents.size(); i++) {
			final int year = grapeComponents.get(i).getYear();
			final Double percentage = grapeComponents.get(i).getPercentage();
			final String variety = grapeComponents.get(i).getVariety();
			final String region = grapeComponents.get(i).getRegion();
			final GrapeComponent grapeComponent = new GrapeComponent(percentage, year, variety, region);
			if (!hasSameYear(year, sortedGrapeComponents)) {
				sortedGrapeComponents.add(grapeComponent);
			}
		}
		System.out.println(VintraceWineryConstants.WINE_YEAR_MESSAGE);
		for (int i = 0; i < sortedGrapeComponents.size(); i++) {
			System.out.println(String.format(VintraceWineryConstants.PERCENTAGE_FORMAT, sortedGrapeComponents.get(i).getPercentage()) + " - "
					+ sortedGrapeComponents.get(i).getYear());
		}
		System.out.println('\n');
	}

	/**
	 * Method is used to print wine region breakdown for the required grape
	 * components in descending order based on percentage.
	 *
	 * @param wine
	 */
	public static void printRegionBreakdown(Wine wine) {
		if(null == wine) {
			return;
		}
		final List<GrapeComponent> grapeComponents = sortGrapeComponents(wine);
		if(CollectionUtils.isEmpty(grapeComponents)) {
			return;
		}
		final List<GrapeComponent> sortedGrapeComponents = new ArrayList<>();
		for (int i = 0; i < grapeComponents.size(); i++) {
			final int year = grapeComponents.get(i).getYear();
			final Double percentage = grapeComponents.get(i).getPercentage();
			final String variety = grapeComponents.get(i).getVariety();
			final String region = grapeComponents.get(i).getRegion();
			final GrapeComponent grapeComponent = new GrapeComponent(percentage, year, variety, region);
			if (!hasSameRegion(region, sortedGrapeComponents)) {
				sortedGrapeComponents.add(grapeComponent);
			}
		}
		System.out.println(VintraceWineryConstants.WINE_REGION_MESSAGE);
		for (int i = 0; i < sortedGrapeComponents.size(); i++) {
			System.out.println(String.format(VintraceWineryConstants.PERCENTAGE_FORMAT, sortedGrapeComponents.get(i).getPercentage()) + " - "
					+ sortedGrapeComponents.get(i).getRegion());
		}
		System.out.println('\n');
	}

	/**
	 * Method is used to print wine year and variety breakdown for the required
	 * grape components in descending order based on percentage.
	 *
	 * @param wine
	 */
	public static void printYearAndVarietyBreakdown(Wine wine) {
		if(null == wine) {
			return;
		}
		final List<GrapeComponent> grapeComponents = sortGrapeComponents(wine);
		if(CollectionUtils.isEmpty(grapeComponents)) {
			return;
		}
		final List<GrapeComponent> sortedGrapeComponents = new ArrayList<>();
		for (int i = 0; i < grapeComponents.size(); i++) {
			final int year = grapeComponents.get(i).getYear();
			final Double percentage = grapeComponents.get(i).getPercentage();
			final String variety = grapeComponents.get(i).getVariety();
			final String region = grapeComponents.get(i).getRegion();
			final GrapeComponent grapeComponent = new GrapeComponent(percentage, year, variety, region);
			if (!hasSameYearAndVariety(year, variety, sortedGrapeComponents)) {
				sortedGrapeComponents.add(grapeComponent);
			}
		}
		System.out.println(VintraceWineryConstants.WINE_YEAR_AND_VARIETY_MESSAGE);
		for (int i = 0; i < sortedGrapeComponents.size(); i++) {
			System.out.println(String.format(VintraceWineryConstants.PERCENTAGE_FORMAT, sortedGrapeComponents.get(i).getPercentage()) + " - "
					+ sortedGrapeComponents.get(i).getYear() + " - " + sortedGrapeComponents.get(i).getVariety());
		}
		System.out.println('\n');
	}

	/**
	 * Method is used to sort the grape components based on the percentage
	 * attributes. Sorting occurs in descending order (highest percentage to lowest
	 * percentage)
	 * 
	 * @param wine
	 * @return List<GrapeComponent>
	 */
	public static List<GrapeComponent> sortGrapeComponents(Wine wine) {
		final List<GrapeComponent> grapeComponents = new ArrayList<>(wine.getComponents());
		for (int i = 0; i < grapeComponents.size(); i++) {
			int m = i;
			for (int j = i + 1; j < grapeComponents.size(); j++) {
				if (grapeComponents.get(m).getPercentage() < grapeComponents.get(j).getPercentage()) {
					m = j;
				}
			}
			GrapeComponent grapeComponent = grapeComponents.get(i);
			grapeComponents.set(i, grapeComponents.get(m));
			grapeComponents.set(m, grapeComponent);
		}
		return grapeComponents;
	}

	/**
	 * This method will verify to true if grape component of highest percentage
	 * already present in the list for the respective manufacturing year.
	 * 
	 * @param year
	 * @param sortedGrapeComponents
	 * @return true if grape component of highest percentage already present in the
	 *         list w.r.t year.
	 */
	public static boolean hasSameYear(int year, List<GrapeComponent> sortedGrapeComponents) {
		for (GrapeComponent grapeComponent : sortedGrapeComponents) {
			if (year == grapeComponent.getYear()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * This method will verify to true if grape component of highest percentage
	 * already present in the list for the respective variety.
	 * 
	 * @param variety
	 * @param sortedGrapeComponents
	 * @return true if grape component of highest percentage already present in the
	 *         list w.r.t variety.
	 */
	public static boolean hasSameVariety(String variety, List<GrapeComponent> sortedGrapeComponents) {
		for (GrapeComponent grapeComponent : sortedGrapeComponents) {
			if (variety.equalsIgnoreCase(grapeComponent.getVariety())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * This method will verify to true if grape component of highest percentage
	 * already present in the list for the respective region.
	 * 
	 * @param region
	 * @param sortedGrapeComponents
	 * @return true if grape component of highest percentage already present in the
	 *         list w.r.t region.
	 */
	public static boolean hasSameRegion(String region, List<GrapeComponent> sortedGrapeComponents) {
		for (GrapeComponent grapeComponent : sortedGrapeComponents) {
			if (region.equalsIgnoreCase(grapeComponent.getRegion())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * This method will verify to true if grape component of highest percentage
	 * already present in the list for the respective year and variety.
	 * 
	 * @param year
	 * @param variety
	 * @param sortedGrapeComponents
	 * @return true if grape component of highest percentage already present in the
	 *         list w.r.t year and variety.
	 */
	public static boolean hasSameYearAndVariety(int year, String variety, List<GrapeComponent> sortedGrapeComponents) {
		for (GrapeComponent grapeComponent : sortedGrapeComponents) {
			if (year == grapeComponent.getYear() && variety.equalsIgnoreCase(grapeComponent.getVariety())) {
				return true;
			}
		}
		return false;
	}
}
