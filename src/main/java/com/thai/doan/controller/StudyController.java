package com.thai.doan.controller;

import com.thai.doan.dao.model.Study;
import com.thai.doan.dto.request.StudyAddingRequest;
import com.thai.doan.dto.request.StudyUpdateRequest;
import com.thai.doan.service.impl.StudyService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@SecurityRequirement(name = "bearerAuth")
@Data
@RestController
@RequestMapping("/api")
public class StudyController {
    private final StudyService studyService;

    @PostMapping("/admin/studies")
    public ResponseEntity<Study> add(@Valid @RequestBody StudyAddingRequest studyAddingReq) {
        return new ResponseEntity<>(studyService.add(studyAddingReq), HttpStatus.OK);
    }

    @PatchMapping("/admin/studies/{studyId}")
    public ResponseEntity<Study> update(@Valid @RequestBody StudyUpdateRequest studyUpdateReq,
                                        @PathVariable Integer studyId) {
        return new ResponseEntity<>(studyService.update(studyId, studyUpdateReq), HttpStatus.OK);
    }

}
