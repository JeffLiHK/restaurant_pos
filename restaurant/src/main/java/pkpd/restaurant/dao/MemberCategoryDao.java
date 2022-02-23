package pkpd.restaurant.dao;


import pkpd.restaurant.entity.MemberCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface MemberCategoryDao extends tk.mybatis.mapper.common.Mapper<MemberCategory>{
    List<MemberCategory> findAll();
    MemberCategory findById(Long id);
    int insert(MemberCategory memberCategory);
    int update(MemberCategory memberCategory);
    int deleteByIds(List<Long> idList);
    MemberCategory findByMcName(MemberCategory memberCategory);
}
