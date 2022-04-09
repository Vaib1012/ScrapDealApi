package com.ibm.app.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ibm.app.models.Stock;
import com.ibm.app.models.User;
import com.ibm.app.payload.response.StockResponse;
import com.ibm.app.repository.StockRepository;
import com.ibm.app.repository.UserRepository;

@Service
public class StockServiceImpl {
	@Autowired
	UserRepository userRepository;
	@Autowired
	StockRepository stockRepository;
	
	public void saveStocks(Stock stock,String username) {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

		stock.setUser(user);
//		Date timestamp=new Date();
//		long[] savedStocks = stockRepository.getStockId(user.getId(), stock.getCompanyName(), timestamp);
//		System.out.println(savedStocks.length);
//		System.out.println(timestamp+" "+stock.getCompanyName());
//		
//		if(savedStocks.length == 0)
		stockRepository.save(stock);
	}

	//returns list of stocks along with the time-stamps in a user's watchlist
	public List<StockResponse> retrieveStocks(String username) {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
		//Set<Stock> stocks = user.getSavedStocks();
		Set<Stock> stocks = stockRepository.findStockListByUserId(user.getId());
		List<StockResponse>  stockList= new ArrayList<>();

		for (Stock s : stocks) {
			StockResponse stockResponse=new StockResponse(user.getId(),s.getRank(),
					s.getCompanyName(),s.getBsePrice(),s.getNsePrice(),s.getPercentDiff(),
					s.getBuyFrom(), s.getCurrentTimestamp());
			stockList.add(stockResponse);
		}
		return stockList;

	}

	//a function to return name of companies in user's watchlist
	public Set<String> getWatchList(String username) {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
		//Set<Stock> stocks = user.getSavedStocks();
		Set<Stock> stocks = stockRepository.findStockListByUserId(user.getId());

		List<String>  stockList= new ArrayList<>();

		for (Stock s : stocks) {
			stockList.add(s.getCompanyName());
		}
		Set<String> stockSet = new HashSet<>(stockList);  
		return stockSet;
	}

	public List<StockResponse> retrieveStocksByName(String username, String companyName) {

		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
		Set<Stock> stocks = stockRepository.findStockListByCompanyNameAndUserId(companyName, user.getId());
		List<StockResponse>  stockList= new ArrayList<>();

		for (Stock s : stocks) {
			StockResponse stockResponse=new StockResponse(user.getId(),s.getRank(),
					s.getCompanyName(),s.getBsePrice(),s.getNsePrice(),s.getPercentDiff(),s.getBuyFrom(),s.getCurrentTimestamp());
			stockList.add(stockResponse);
		}
		return stockList;
	}

	public String deleteStock(String username, String companyName, Date saveAt) {

		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
		long[] stock_id = stockRepository.getStockId(user.getId(), companyName, saveAt) ;


		if(stock_id.length>0) {
			for(int index=0; index < stock_id.length; index++) {
				stockRepository.deleteById(stock_id[index]);
			}
			return "Stock deleted";
		} else {
			return "Stock not found";
		}
	}

}
