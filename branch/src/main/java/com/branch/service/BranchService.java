package com.branch.service;

import com.branch.dto.BranchReq;
import com.branch.dto.BranchRes;

import java.util.List;

public interface BranchService {
    List<BranchRes> getBranchesByProvinceId(Long provinceId);
    BranchRes updateBranch(Long id, BranchReq request);
    void deleteBranch(Long id);
}
