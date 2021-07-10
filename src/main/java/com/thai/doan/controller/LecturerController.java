package com.thai.doan.controller;

import com.thai.doan.dao.model.Lecturer;
import com.thai.doan.dto.request.LecturerAddingRequest;
import com.thai.doan.dto.request.LecturerUpdatingRequest;
import com.thai.doan.service.LecturerService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@SecurityRequirement(name = "bearerAuth")
@RestController
@Data
public class LecturerController {
    private final LecturerService lecturerSv;

    // view
    @GetMapping("/admin/giang-vien/them")
    public ModelAndView getAdd() {
        return new ModelAndView("admin/lecturer/add-lecturer");
    }

    @GetMapping("/admin/giang-vien/sua")
    public ModelAndView getEdit() {
        return new ModelAndView("admin/lecturer/edit-lecturer");
    }

    @GetMapping("/admin/giang-vien/xoa")
    public ModelAndView getDelete() {
        return new ModelAndView("admin/lecturer/delete-lecturer");
    }

    //Restful api
    @GetMapping("/admin/lecturers")
    public @ResponseBody List<Lecturer> getAllLecturerWithDepartment(@RequestParam String department) {
        return lecturerSv.getAllLecturer(department);
    }

    @RequestMapping(value = "/api/admin/lecturers", method = RequestMethod.GET, params = "departmentId")
    public @ResponseBody List<Lecturer> getWithDepartmentId(@RequestParam String departmentId) {
        return lecturerSv.getWithDepartmentId(departmentId);
    }

    @PostMapping("/api/admin/lecturers")
    public ResponseEntity<?> add(@RequestBody @Valid LecturerAddingRequest lecturerAddingReq) {
        lecturerSv.add(lecturerAddingReq);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/api/admin/lecturers/{id}")
    public ResponseEntity<?> getOne(@PathVariable String id) {
        return new ResponseEntity<>(lecturerSv.getOne(id), HttpStatus.OK);
    }

    @PatchMapping("/api/admin/lecturers/{id}")
    public ResponseEntity<?> update(@RequestBody @Valid LecturerUpdatingRequest lecturerUpdatingReq,
                                    @PathVariable @RequestBody Integer id) {
        lecturerSv.updateWithId(lecturerUpdatingReq, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/api/admin/lecturers/{id}")
    public ResponseEntity<?> delete(@PathVariable @RequestBody Integer id) {
        lecturerSv.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
