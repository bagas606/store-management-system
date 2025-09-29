package com.branch.controller;

import com.branch.dto.BranchReq;
import com.branch.dto.BranchRes;
import com.branch.service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/branch")
@RequiredArgsConstructor
public class BranchController {

    private final BranchService branchService;

    @GetMapping("/province/{provinceId}")
    public ResponseEntity<List<BranchRes>> getBranchesByProvinceId(@PathVariable Long provinceId) {
        List<BranchRes> branches = branchService.getBranchesByProvinceId(provinceId);
        return ResponseEntity.ok(branches);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BranchRes> updateBranch(@PathVariable Long id, @RequestBody BranchReq request) {
        try {
            BranchRes updatedBranch = branchService.updateBranch(id, request);
            return ResponseEntity.ok(updatedBranch);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBranch(@PathVariable Long id) {
        branchService.deleteBranch(id);
        return ResponseEntity.noContent().build();
    }

}
