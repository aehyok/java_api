package com.sun.xxm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sun.xxm.dto.KeyValueDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.util.List;

@Mapper
public interface KeyValueMapper extends BaseMapper<KeyValue> {
    @Select(" SELECT kv.id, kv.value, kc.label FROM keyconfig kc " +
            " INNER JOIN keyvalue kv on kc.id = kv.key_config_id  " +
            " WHERE kv.region_id = #{regionId} and kc.dictionary_code = #{code}" +
            " ORDER BY kc.display_order")
    public List<KeyValueDto> getKeyValuesAsync(@Param("regionId") Long regionId, @Param("code") String code);
}
