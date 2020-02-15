package com.bsu.edu.restapi.service;

import com.bsu.edu.restapi.DTO.IOSStudentDTO;
import com.bsu.edu.restapi.DTO.LoginDTO;

public interface IOSStudentService {
    public IOSStudentDTO getStudent(LoginDTO model);
}
