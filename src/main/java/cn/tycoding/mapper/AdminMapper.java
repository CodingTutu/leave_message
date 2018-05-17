package cn.tycoding.mapper;

import cn.tycoding.pojo.Admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface AdminMapper {
    
    Admin login(String a_name);

    void insert(Admin admin);

    Integer lastId();

    Admin findByName(String a_name);

    int selectCount();

    List<Admin> findByPage(HashMap<String, Object> map);

    List<Admin> conFindByPage(Map<String, Object> conMap);

    Admin findById(int a_id);

    void delete(int a_id);

    void update(Admin admin);

    int selectCount_u();
}
