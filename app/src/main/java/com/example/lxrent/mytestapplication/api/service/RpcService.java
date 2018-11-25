package com.example.lxrent.mytestapplication.api.service;

import com.example.lxrent.mytestapplication.api.vo.Block;
import com.example.lxrent.mytestapplication.api.vo.ChainInfo;
import com.example.lxrent.mytestapplication.api.vo.TableRows;
import com.example.lxrent.mytestapplication.api.vo.TableRowsReq;
import com.example.lxrent.mytestapplication.api.vo.account.Account;
import com.example.lxrent.mytestapplication.api.vo.transaction.Transaction;
import com.example.lxrent.mytestapplication.api.vo.transaction.push.TxRequest;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * 
 * @author espritblock http://eblock.io
 *
 */
public interface RpcService {

	@GET("/v1/chain/get_info")
	Call<ChainInfo> getChainInfo();

	@POST("/v1/chain/get_block")
	Call<Block> getBlock(@Body Map<String, String> requestFields);

	@POST("/v1/chain/get_account")
	Call<Account> getAccount(@Body Map<String, String> requestFields);

	@POST("/v1/chain/push_transaction")
	Call<Transaction> pushTransaction(@Body TxRequest request);

	@POST("/v1/chain/get_table_rows")
	Call<TableRows> getTableRows(@Body TableRowsReq request);

}
