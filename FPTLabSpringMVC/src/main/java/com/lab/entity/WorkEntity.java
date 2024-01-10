package com.lab.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_work")
public class WorkEntity extends BaseEnity {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column (name= "work_id", columnDefinition = "int(10)")
    private int workId;
	
	@Column (name= "work_date_join", columnDefinition = "varchar(255)")
    private String workDateJoin;
	
	@Column (name= "work_name", columnDefinition = "varchar(255)")
    private String workName;
	
	@Column (name= "work_company_name", columnDefinition = "varchar(255)")
    private String workCompanyName;
	
	@Column (name= "work_company_address", columnDefinition = "varchar(255)")
    private String workCompanyAddress;
	
	@Column (name= "work_company_time", columnDefinition = "varchar(255)")
    private String workCompanyTime;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id_card")
    private StudentEntity student;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_id")
    private BranchEntity branch;

    // Constructors, getters, setters

    public WorkEntity() {
        // Default constructor
    }

    public WorkEntity(int workId, String workDateJoin, String workName,
                String workCompanyName, String workCompanyAddress, String workCompanyTime) {
        this.workId = workId;
        this.workDateJoin = workDateJoin;
        this.workName = workName;
        this.workCompanyName = workCompanyName;
        this.workCompanyAddress = workCompanyAddress;
        this.workCompanyTime = workCompanyTime;
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

	public StudentEntity getStudent() {
		return student;
	}

	public void setStudent(StudentEntity student) {
		this.student = student;
	}

	public BranchEntity getBranch() {
		return branch;
	}

	public void setBranch(BranchEntity branch) {
		this.branch = branch;
	}
    
    
    
}
