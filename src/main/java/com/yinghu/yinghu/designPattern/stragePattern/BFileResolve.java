package com.yinghu.yinghu.designPattern.stragePattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class BFileResolve implements IFileStrategy {

    final static Logger logger = LoggerFactory.getLogger(BFileResolve.class);

    @Override
    public FileTypeResolveEnum gainFileType() {
        return FileTypeResolveEnum.File_B_RESOLVE;
    }

    @Override
    public void resolve(Object objectparam) {
        logger.info("B 类型解析文件，参数：{}",objectparam);
        //B类型解析具体逻辑
    }
}