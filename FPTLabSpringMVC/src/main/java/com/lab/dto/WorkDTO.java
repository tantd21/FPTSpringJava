package com.lab.dto;


public class WorkDTO extends AbstractDTO<WorkDTO> {
    private int workId;
    private String workDateJoin;
    private String workName;
    private String workCompanyName;
    private String workCompanyAddress;
    private String workCompanyTime;
    private BranchDTO branch;
    private StudentDTO student;
    // Constructors, getters, setters

	public WorkDTO() {
        // Default constructor
    }


	// Getters and setters for each field
	public int getWorkId() {
        return workId;
    }

    public void setWorkId(int workId) {
        this.workId = workId;
    }


    public String getWorkDateJoin() {
        return workDateJoin;
    }

    public void setWorkDateJoin(String workDateJoin) {
        this.workDateJoin = workDateJoin;
    }


    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    public String getWorkCompanyName() {
        return workCompanyName;
    }

    public void setWorkCompanyName(String workCompanyName) {
        this.workCompanyName = workCompanyName;
    }

    public String getWorkCompanyAddress() {
        return workCompanyAddress;
    }

    public void setWorkCompanyAddress(String workCompanyAddress) {
        this.workCompanyAddress = workCompanyAddress;
    }

    public String getWorkCompanyTime() {
        return workCompanyTime;
    }

    public void setWorkCompanyTime(String workCompanyTime) {
        this.workCompanyTime = workCompanyTime;
    }

	public StudentDTO getStudent() {
		return student;
	}

	public void setStudent(StudentDTO student) {
		this.student = student;
	}
    public BranchDTO getBranch() {
		return branch;
	}

	public void setBranch(BranchDTO branch) {
		this.branch = branch;
	}
    
}
