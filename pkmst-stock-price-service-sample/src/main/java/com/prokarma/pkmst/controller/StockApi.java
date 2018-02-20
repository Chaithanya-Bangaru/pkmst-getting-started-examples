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

import com.prokarma.pkmst.model.Stock;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
/**
 * Provides the info about api methods
 * @author pkmst
 *
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaPKMSTServerCodegen", date = "2018-02-15T21:21:34.533Z")

@Api(value = "Stock", description = "the Stock API")
public interface StockApi {

    @ApiOperation(value = "Lookup a stock detail by the ticker", notes = "Returns a single stock price", response = Stock.class, tags={ "Stock", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Stock.class),
        @ApiResponse(code = 400, message = "Invalid ticker supplied"),
        @ApiResponse(code = 404, message = "Stock not found") })
    	@RequestMapping(value = "/stock/{ticker}",
        method = RequestMethod.GET)
    ResponseEntity<Stock> getStockSummaryByTicker(@ApiParam(value = "Ticker of the stock to return",required=true ) @PathVariable("ticker") String ticker) throws Exception;

}
