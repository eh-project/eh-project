package com.ehais.schoolweixin.mapper;

import com.ehais.schoolweixin.model.activityDetail;
import com.ehais.schoolweixin.model.activityDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface activityDetailMapper {
    int countByExample(activityDetailExample example);

    int deleteByExample(activityDetailExample example);

    int insert(activityDetail record);

    int insertSelective(activityDetail record);

    List<activityDetail> selectByExample(activityDetailExample example);

    int updateByExampleSelective(@Param("record") activityDetail record, @Param("example") activityDetailExample example);

    int updateByExample(@Param("record") activityDetail record, @Param("example") activityDetailExample example);
}