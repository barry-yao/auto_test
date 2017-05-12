package com.kodak.selenium.icw.enums;



public enum SRFileStatus {
	ApproveRequred("approveIcon iconFileRequested-enabled"),

	Approved("approveIcon iconFileApproved-enabled"),

	Rejected("approveIcon iconFileRejected-enabled"),

	Reference("referenceIcon");

	private SRFileStatus(String className) {
		this._className = className;
	}

	private String _className;

	public String getClassName() {
		return _className;
	}
	
	@Override
	public String toString(){
		return String.format("[%s]: %s", this.name(),this.getClassName());
	}
	
	public static SRFileStatus parse(String className) throws Exception{
		
		
		for(SRFileStatus sr : SRFileStatus.values()){
			if(sr.getClassName().equalsIgnoreCase(className)){
				return sr;
			}
		}
		throw new Exception("[SRFileStatus] Not recognized class name:"+className);
		
	}

}
