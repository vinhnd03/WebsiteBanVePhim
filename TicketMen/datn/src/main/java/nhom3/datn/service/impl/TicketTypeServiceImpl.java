package nhom3.datn.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nhom3.datn.dao.TicketTypeDao;
import nhom3.datn.entity.TicketType;
import nhom3.datn.service.TicketTypeService;

@Service 
public class TicketTypeServiceImpl implements TicketTypeService{
    @Autowired
    TicketTypeDao tdao;

    @Override
    public List<TicketType> fillAll() {
       return tdao.findAll();
    }

}
