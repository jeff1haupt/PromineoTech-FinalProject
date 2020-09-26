package com.finalproject.finalproject.Service;

import com.finalproject.finalproject.Repository.ClientMatterRepository;
import com.finalproject.finalproject.Repository.ClientRepository;
import com.finalproject.finalproject.Repository.LawyerRepository;
import com.finalproject.finalproject.entity.Client;
import com.finalproject.finalproject.entity.ClientMatter;
import com.finalproject.finalproject.entity.Lawyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ClientMatterService {

    @Autowired
    private ClientMatterRepository repo;

    @Autowired
    private LawyerRepository lawyerRepo;

    @Autowired
    private ClientRepository clientRepo;

    

}
