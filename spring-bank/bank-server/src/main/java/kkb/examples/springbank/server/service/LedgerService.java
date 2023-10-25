package kkb.examples.springbank.server.service;

import java.util.Collection;

import kkb.examples.springbank.common.dto.LedgerRecord;
import kkb.examples.springbank.common.dto.ServiceException;

public interface LedgerService {

    void saveRecord(LedgerRecord ledgerRecord) throws ServiceException;

    Collection<LedgerRecord> getLedger();

}
