package com.ty.springboot_hospital_app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hospital_app.dto.Address;
import com.ty.springboot_hospital_app.dto.Branch;
import com.ty.springboot_hospital_app.dto.Hospital;
import com.ty.springboot_hospital_app.repository.BranchRepository;

@Repository
public class BranchDao {

	@Autowired
	private BranchRepository repository;

	@Autowired
	private HospitalDao dao;

	@Autowired
	private AddressDao addressDao;

	public Branch saveBranch(Branch branch, int hid, int aid) {
		Hospital hospital = dao.getHospitalById(hid);
		branch.setHospital(hospital);
		Address address = addressDao.getAddressById(aid);
		branch.setAddress(address);
		return repository.save(branch);
	}

	public Branch updateBranch(int id, Branch branch) {

		if (repository.findById(id).isPresent()) {
			Branch dbbranch = repository.findById(id).get();
			branch.setId(id);
			branch.setHospital(dbbranch.getHospital());
			branch.setAddress(dbbranch.getAddress());
			return repository.save(branch);
		} else {
			return null;
		}
	}

	public Branch getBranchById(int id) {
		if (repository.findById(id).isPresent()) {
			return repository.findById(id).get();
		} else {
			return null;
		}
	}

	public List<Branch> getBranchs(int hid, Branch branch) {
		Hospital hospital = dao.getHospitalById(hid);
		if (hospital != null) {
			return repository.findByhospital(hospital);
		} else {
			return null;
		}
	}

	public Branch deleteBranch(int id) {
		if (repository.findById(id).isPresent()) {
			Branch branch = repository.findById(id).get();
			repository.delete(branch);
			return branch;

		} else {
			return null;
		}

	}

	public List<Branch> getBranchByHospitalId(int hid) {
		Hospital hospital = dao.getHospitalById(hid);
		if (hospital != null) {
			return repository.findByhospital(hospital);
		} else {
			return null;
		}
	}

}
