package kkb.examples.springbank.server.service;

import kkb.examples.springbank.common.dto.ServiceException;
import kkb.examples.springbank.common.dto.SystemInfo;
import kkb.examples.springbank.common.service.SystemInfoService;

import org.springframework.stereotype.Service;

@Service
public class SystemInfoServiceImpl implements SystemInfoService {

    @Override
    public SystemInfo getSystemInfo() throws ServiceException {
        return new SystemInfo("1.0.0");
    }

}
