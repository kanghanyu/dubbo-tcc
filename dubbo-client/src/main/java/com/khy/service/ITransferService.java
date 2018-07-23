package com.khy.service;

import com.khy.ServiceException;

public interface ITransferService {

	public void transfer(String sourceAcctId, String targetAcctId, double amount) throws ServiceException;

}
