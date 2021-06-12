package com.thai.doan.service;

import com.thai.doan.dao.model.Classes;
import com.thai.doan.dto.request.ClassAddingRequest;
import com.thai.doan.dto.request.ClassUpdatingRequest;

import java.util.List;

public interface ClassesService {
    List<Classes> getWithDepartmentAndSession(String departmentName, int sessionId);
    List<Classes> getWithSessionIdAndDepartmentId(int sessionId, int departmentId);
    void add(ClassAddingRequest classAddingReq);
    void updateWithId(int id, ClassUpdatingRequest classUpdatingReq);
    void deleteWithId(int id);
}
