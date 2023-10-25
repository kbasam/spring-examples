package kkb.examples.springbank.common.service;

import kkb.examples.springbank.common.dto.ServiceException;
import kkb.examples.springbank.common.dto.SystemInfo;

public interface SystemInfoService {

    SystemInfo getSystemInfo() throws ServiceException;

}
