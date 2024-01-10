package com.lab.dto;

public class GraduateDTO extends AbstractDTO<GraduateDTO> {
	    private int graduateId;
	    private String graduateProgram;
	    private String graduateDate;
	    private String graduateType;
	    private BranchDTO branch;
	    private SchoolDTO school;
	    private StudentDTO student;

	    // Constructors, getters, setters

	    public GraduateDTO() {
	        // Default constructor
	    }

	    public GraduateDTO(int graduateId, int studentIdCard, int schoolId, int branchId, String graduateProgram,
	                    String graduateDate, String graduateType) {
	        this.graduateId = graduateId;
	        this.graduateProgram = graduateProgram;
	        this.graduateDate = graduateDate;
	        this.graduateType = graduateType;
	    }

	    // Getters and setters for each field

	    public int getGraduateId() {
	        return graduateId;
	    }

	    public void setGraduateId(int graduateId) {
	        this.graduateId = graduateId;
	    }

	    public String getGraduateProgram() {
	        return graduateProgram;
	    }

	    public void setGraduateProgram(String graduateProgram) {
	        this.graduateProgram = graduateProgram;
	    }

	    public String getGraduateDate() {
	        return graduateDate;
	    }

	    public void setGraduateDate(String graduateDate) {
	        this.graduateDate = graduateDate;
	    }

	    public String getGraduateType() {
	        return graduateType;
	    }

	    public void setGraduateType(String graduateType) {
	        this.graduateType = graduateType;
	    }

		public BranchDTO getBranch() {
			return branch;
		}

		public void setBranch(BranchDTO branch) {
			this.branch = branch;
		}

		public SchoolDTO getSchool() {
			return school;
		}

		public void setSchool(SchoolDTO school) {
			this.school = school;
		}

		public StudentDTO getStudent() {
			return student;
		}

		public void setStudent(StudentDTO student) {
			this.student = student;
		}
	    

}
