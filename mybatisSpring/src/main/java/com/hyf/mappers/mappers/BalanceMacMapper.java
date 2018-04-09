package com.hyf.mappers.mappers;

import com.hyf.models.BalanceMacModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * balance相关的mac处理方法和类
 *
 * @author yafei.hou  on 2018/3/20
 */

public interface BalanceMacMapper {

    void insertBalanceMac(@Param("dataSets")List<BalanceMacModel> dataSet);

}



