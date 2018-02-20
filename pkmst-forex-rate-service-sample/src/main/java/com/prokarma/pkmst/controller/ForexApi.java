/**
 * NOTE: This class is auto generated by the swagger code generator program (2.3.1).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.prokarma.pkmst.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.prokarma.pkmst.model.Forex;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Provides the info about api methods
 * 
 * @author pkmst
 *
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaPKMSTServerCodegen", date = "2018-02-20T12:58:06.831Z")

@Api(value = "Forex", description = "the Forex API")
public interface ForexApi {

	@ApiOperation(value = "Lookup a forex detail by the ticker", notes = "Returns details of a single foreign exchange pair representer by a ticker", response = Forex.class, tags = {
			"Forex", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successful operation", response = Forex.class),
			@ApiResponse(code = 400, message = "Invalid ticker supplied"),
			@ApiResponse(code = 404, message = "Forex not found") })
	@RequestMapping(value = "/forex/{ticker}", method = RequestMethod.GET)
	ResponseEntity<Forex> getForexSummaryByTicker(
			@ApiParam(value = "Ticker of the stock to return", required = true) @PathVariable("ticker") String ticker) throws Exception;

}
