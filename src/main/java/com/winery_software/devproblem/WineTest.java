package com.winery_software.devproblem;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.winery_software.devproblem.constants.VintraceWineryConstants;
import com.winery_software.devproblem.utils.VintraceWineryUtils;

public class WineTest {

	private static final Logger LOGGER = Logger.getLogger(WineTest.class);

	public static void main(String[] args) {
		final ObjectMapper objectMapper = new ObjectMapper();
		final List<Wine> wines = new ArrayList<>();
		try {
			Wine wine1 = objectMapper.readValue(new File(VintraceWineryConstants.LOTCODE_11YVCHAR001), Wine.class);
			Wine wine2 = objectMapper.readValue(new File(VintraceWineryConstants.LOTCODE_11YVCHAR002), Wine.class);
			Wine wine3 = objectMapper.readValue(new File(VintraceWineryConstants.LOTCODE_15MPPN002_VK), Wine.class);
			wines.add(wine1);
			wines.add(wine2);
			wines.add(wine3);
		} catch (JsonParseException jsonParseException) {
			jsonParseException.printStackTrace();
			LOGGER.error(VintraceWineryConstants.EXCEPTION_JASON_PARSE_MESSAGE, jsonParseException);
		} catch (JsonMappingException jsonMappingException) {
			jsonMappingException.printStackTrace();
			LOGGER.error(VintraceWineryConstants.EXCEPTION_JASON_MAPPING_MESSAGE, jsonMappingException);
		} catch (IOException ioException) {
			ioException.printStackTrace();
			LOGGER.error(VintraceWineryConstants.EXCEPTION_IO_MESSAGE, ioException);
		}
		for (Wine wine : wines) {
			System.out.println("Lot code " + wine.getLotCode() + " Breakdown");
			System.out.println(
					"----------------------------------------------------------------------------------------------");
			VintraceWineryUtils.printYearBreakdown(wine);
			VintraceWineryUtils.printVarietyBreakdown(wine);
			VintraceWineryUtils.printRegionBreakdown(wine);
			VintraceWineryUtils.printYearAndVarietyBreakdown(wine);
			System.out.println('\n');
		}
	}
}
