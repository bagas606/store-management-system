package com.branch.service.impl;

import com.branch.dto.BranchReq;
import com.branch.dto.BranchRes;
import com.branch.entity.Branch;
import com.branch.repository.BranchRepository;
import com.branch.service.BranchService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BranchServiceImpl implements BranchService {
    private final BranchRepository branchRepository;

    public BranchServiceImpl(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    @Override
    public List<BranchRes> getBranchesByProvinceId(Long provinceId) {
        return branchRepository.findByProvinceId(provinceId).stream()
                .map(branch -> new BranchRes(
                        branch.getId(),
                        branch.getProvinceId(),
                        branch.getName(),
                        branch.getCreatedAt(),
                        branch.getUpdatedAt(),
                        branch.getIsDeleted()
                ))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public BranchRes updateBranch(Long id, BranchReq request) {
        Branch branch = branchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Branch not found"));

        branch.setName(request.getName());
        branch.setProvinceId(request.getProvinceId());
        if (branch.getCreatedAt() == null) {
            branch.setCreatedAt(LocalDateTime.now());
        } else {
            branch.setUpdatedAt(LocalDateTime.now());
        }
        branch.setIsDeleted(request.getIsDeleted());
        branchRepository.saveAndFlush(branch);
        return BranchRes.builder()
                .id(id)
                .provinceId(branch.getProvinceId())
                .name(branch.getName())
                .isDeleted(branch.getIsDeleted())
                .build();
    }

    @Override
    @Transactional
    public void deleteBranch(Long id) {
        branchRepository.deleteById(id);
    }
}
